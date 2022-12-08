package pizzaria.domain;

import pizzaria.eventos.*;
import pizzaria.listener.PizzariaListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzaria {

	private final PizzariaListener listener;
	private final Queue<Fogao> fogoesDisponiveis;
	private final Queue<Pizzaiolo> pizzaioloDisponiveis;
	private final Queue<Garcom> garconsDisponiveis;

	private final Queue<Cliente> clientesNaoAtendidos = new LinkedList<>();
	private final Queue<Cliente> clientesAtendidos = new LinkedList<>();
	private final Queue<Cliente> clienteRecebeuComida = new LinkedList<>();
	private final Queue<Garcom> garconsOcupados = new LinkedList<>();
	private final Queue<Pizzaiolo> pizzaioloOcupados = new LinkedList<>();
	private final Queue<Fogao> fogoesOcupados = new LinkedList<>();
	private final Queue<Pedido> pedidosNaoFeitos = new LinkedList<>();
	private final Queue<Pedido> pedidosPronto = new LinkedList<>();

	public int getFogoesDisponiveis() {
		return this.fogoesDisponiveis.size();
	}

	public Queue<Cliente> getClienteRecebeuComida() {
		return this.clienteRecebeuComida;
	}

	public int getFogoesOcupados() {
		return this.fogoesOcupados.size();
	}

	public Queue<Pedido> getFilaDePedido() {
		return this.pedidosNaoFeitos;
	}

	public Pizzaria(Queue<Garcom> garcons, Queue<Pizzaiolo> pizzaiolo, Queue<Fogao> fogoes, PizzariaListener listener) {
		this.garconsDisponiveis = garcons;
		System.out.println("========= LIST DE GARCONS ==========\n" + garcons + "\n=========== FIM DA LISTA ============\n");
		this.listener = listener;
		this.pizzaioloDisponiveis = pizzaiolo;
		this.fogoesDisponiveis = fogoes;
	}

	public Queue<Pizzaiolo> getPizzaioloDisponivel() {
		return this.pizzaioloDisponiveis;
	}

	public Queue<Pizzaiolo> getPizzaioloOcupado() {
		return this.pizzaioloOcupados;
	}

	public void novoClienteChegou(Cliente novoCliente) {
		this.clientesNaoAtendidos.add(novoCliente);

		EventoChegouCliente evento = new EventoChegouCliente(novoCliente);
		listener.ocorreuEvento(evento);
	}

	public Collection<Cliente> getClientes() {
		List<Cliente> todos = new ArrayList<>();
		todos.addAll(this.clientesNaoAtendidos);
		todos.addAll(this.clientesAtendidos);
		return todos;
	}

	public Collection<Cliente> getClientesNaoAtendidos() {
		return this.clientesNaoAtendidos;
	}

	public Collection<Cliente> getClientesAtendidos() {
		return this.clientesAtendidos;
	}

	public Collection<Garcom> getGarcons() {
		List<Garcom> todos = new ArrayList<>();
		todos.addAll(this.garconsDisponiveis);
		todos.addAll(this.garconsOcupados);
		return todos;
	}

	public Queue<Garcom> getGarconsDisponiveis() {
		System.out.println("\n========= LIST DE GARCONS ==========\n" + this.garconsDisponiveis + "\n=========== FIM DA LISTA ============\n");
		return this.garconsDisponiveis;
	}

	public Collection<Garcom> getGarconsOcupados() {
		return this.garconsOcupados;
	}

	public void clientesFazemPedidos() {
		if (temGarconDisponivel()) {
			if (temClienteNaoFoiAtendido()) {
				Cliente cliente = clientesNaoAtendidos.poll();
				clienteFazPedido(cliente);
			}
		}
	}

	private boolean temClienteNaoFoiAtendido() {
		return !clientesNaoAtendidos.isEmpty();
	}

	private void clienteFazPedido(Cliente cliente) {
		Garcom garcom = pegarGarconDisponivel();
		Pedido novoPedido = cliente.novoPedido();
		garcom.setPedido(novoPedido);

		EventoGarconPegouPedido evento = new EventoGarconPegouPedido(garcom, novoPedido, cliente);
		this.listener.ocorreuEvento(evento);

		garcomLevaPedido(garcom);
		clientesNaoAtendidos.remove(cliente);
		clientesAtendidos.add(cliente);

	}

	private void garcomLevaPedido(Garcom garcom) {
		Pedido pedido = garcom.getPedido();
		pedidosNaoFeitos.add(pedido);
		cozinhando();
	}

	private void cozinhando() {
		if (temFogaoDisponivel() && temPizzaioloDisponivel()) {
			Pedido pedidoNaoFeito = pegarPedidoDaLista();
			pegarPizzaioloDisponivel();
			Fogao fogaoDisponivel = pegarFogaoDisponivel();
			colocaPedidoNoForno(pedidoNaoFeito, fogaoDisponivel);
		}
	}

	private void colocaPedidoNoForno(Pedido pedidoNaoFeito, Fogao fogaoDisponivel) {
		fogaoDisponivel.setPedido(pedidoNaoFeito);
	}

	private Fogao pegarFogaoDisponivel() {
		Fogao fogaoDisponivel = fogoesDisponiveis.poll();
		fogoesOcupados.add(fogaoDisponivel);
		return fogaoDisponivel;
	}

	private Pedido pegarPedidoDaLista() {
		return pedidosNaoFeitos.poll();
	}

	private boolean temPizzaioloDisponivel() {
		return !pizzaioloDisponiveis.isEmpty();
	}

	private boolean temFogaoDisponivel() {
		return !fogoesDisponiveis.isEmpty();
	}

	private Pizzaiolo pegarPizzaioloDisponivel() {
		Pizzaiolo pizzaiolo = pizzaioloDisponiveis.poll();
		indisponibilizarPizzaiolo(pizzaiolo);
		return pizzaiolo;
	}

	private void indisponibilizarPizzaiolo(Pizzaiolo pizzaiolo) {
		this.pizzaioloOcupados.add(pizzaiolo);
	}

	private Garcom pegarGarconDisponivel() {
		Garcom garcon = garconsDisponiveis.poll();
		indisponibilizarGarcon(garcon);
		return garcon;
	}

	private void indisponibilizarGarcon(Garcom garcon) {
		this.garconsOcupados.add(garcon);
	}

	private boolean temGarconDisponivel() {
		return !garconsDisponiveis.isEmpty();
	}

	public void deixarGarcomDisponivel(int tempo) {
		if (verificaTempo(tempo) && !garconsOcupados.isEmpty()) {
			Garcom garcomOcupado = garconsOcupados.poll();
			garconsDisponiveis.add(garcomOcupado);
		}
	}

	private boolean verificaTempo(int tempo) {
		return tempo % 2 == 0;
	}

	public void deixarPizzaioloDIsponivel(int tempo) {
		if (tempoMultiploDeCinco(tempo)) {
			Pizzaiolo pizzaioloOcupado = pizzaioloOcupados.poll();
			Fogao fogaoOcupado = fogoesOcupados.poll();
			Pedido sabores = fogaoOcupado.getPedido();
			pedidosPronto.add(sabores);

			EventoPizzaioloTerminoPizza evento = new EventoPizzaioloTerminoPizza(pizzaioloOcupado, sabores);
			this.listener.ocorreuEvento(evento);

			fogoesDisponiveis.add(fogaoOcupado);
			pizzaioloDisponiveis.add(pizzaioloOcupado);
		}
	}

	public Queue<Pedido> getPedidoPronto() {
		return pedidosPronto;
	}

	public void garcomLevarPedidoParaCliente() {
		if (temClienteQueJaPediu() && temGarconDisponivel() && temPedidoPronto()) {
			Garcom garcomDisponivel = pegarGarconDisponivel();
			Cliente clienteAtendido = pegarClienteAtendido();
			Pedido pedidoPronto = pedidosPronto.poll();
			garcomDisponivel.pegaPedidoPronto(pedidoPronto);
			garcomLevaPedidoParaCliente(garcomDisponivel, clienteAtendido);
		}
	}

	private void garcomLevaPedidoParaCliente(Garcom garcomDisponivel, Cliente clienteAtendido) {
		Pedido pedido = garcomDisponivel.getPedidoPronto();
		clienteAtendido.setPedido(pedido);
		clienteRecebeuComida.add(clienteAtendido);

		EventoClienteRecebeuPedido evento = new EventoClienteRecebeuPedido(pedido, garcomDisponivel, clienteAtendido);
		this.listener.ocorreuEvento(evento);
	}

	private boolean temClienteQueJaPediu() {
		return !clientesAtendidos.isEmpty();
	}

	private Cliente pegarClienteAtendido() {
		return clientesAtendidos.poll();
	}

	private boolean temPedidoPronto() {
		return !pedidosPronto.isEmpty();
	}

	public void clienteVaiEmbora(int tempo) {
		if (tempoMultiploDetre(tempo)) {
			if (clienteJaRecebeuPedido()) {
				Cliente clienteAtendido = clientesAtendidos.poll();
				EventoClienteFoiEmbora vento = new EventoClienteFoiEmbora(clienteAtendido);
			}
		}

	}

	private boolean tempoMultiploDetre(int tempo) {
		return tempo % 3 == 0;
	}

	private boolean clienteJaRecebeuPedido() {
		return !clientesAtendidos.isEmpty();
	}

	private boolean tempoMultiploDeCinco(int tempo) {
		return tempo % 5 == 0;
	}
}