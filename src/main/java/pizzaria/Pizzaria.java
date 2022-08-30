package pizzaria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzaria {

	private PizzariaListener listener;
	private Queue<Cliente> clientesNaoAtendidos = new LinkedList<>();
	private Queue<Cliente> clientesAtendidos = new LinkedList<>();
	private Queue<Garcom> garconsDisponiveis;
	private Queue<Garcom> garconsOcupados = new LinkedList<>();
	private Queue<Pizzaiolo> pizzaioloDisponivel;
	private Queue<Pizzaiolo> pizzaioloOcupado = new LinkedList<>();

	public Pizzaria(Queue<Garcom> garcons, Queue<Pizzaiolo> pizzaiolo,PizzariaListener listener) {
		this.garconsDisponiveis = garcons;
		this.listener = listener;
		this.pizzaioloDisponivel = pizzaiolo;
	}

	public Queue<Pizzaiolo> getPizzaioloDisponivel() {
		return pizzaioloDisponivel;
	}

	public Queue<Pizzaiolo> getPizzaioloOcupado() {
		return pizzaioloOcupado;
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
		return clientesNaoAtendidos;
	}

	public Collection<Cliente> getClientesAtendidos() {
		return clientesAtendidos;
	}

	public Collection<Garcom> getGarcons() {
		List<Garcom> todos = new ArrayList<>();
		todos.addAll(this.garconsDisponiveis);
		todos.addAll(this.garconsOcupados);
		return todos;
	}

	public Collection<Garcom> getGarconsDisponiveis() {
		return garconsDisponiveis;
	}

	public Collection<Garcom> getGarconsOcupados() {
		return garconsOcupados;
	}

	public void clientesFazemPedidos() {

		for (Cliente cliente : this.clientesNaoAtendidos) {
			if (temGarconDisponivel()) {
				clienteFazPedido(cliente);
			}
		}
	}

	private void clienteFazPedido(Cliente cliente) {

		Garcom garcom = pegarGarconDisponivel();
		Pedido novoPedido = cliente.novoPedido();
		garcom.setPedido(novoPedido);
		clientesNaoAtendidos.remove(cliente);
		clientesAtendidos.add(cliente);

		EventoGarconPegouPedido evento = new EventoGarconPegouPedido(garcom, novoPedido, cliente);
		this.listener.ocorreuEvento(evento);
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
		if (verificaTempo(tempo)) {
			Garcom garcomOcupado = garconsOcupados.poll();
			garconsDisponiveis.add(garcomOcupado);
		}
	}

	private boolean verificaTempo(int tempo) {
		if(tempo % 2 == 0) {
			return true;
		}
		return false;
	}

}
