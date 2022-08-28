package pizzaria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzaria {

	private Queue<Cliente> clientesNaoAtendidos = new LinkedList<>();
	private Queue<Cliente> clientesAtendidos = new LinkedList<>();
	private Queue<Garcom> garconsDisponiveis;
	private Queue<Garcom> garconsOcupados = new LinkedList<>();

	public Pizzaria(Queue<Garcom> garcons) {
		this.garconsDisponiveis = garcons;
	}

	public void novoClienteChegou(Cliente novoCliente) {
		this.clientesNaoAtendidos.add(novoCliente);
		System.out.println("Cliente " + novoCliente.getNome() + " chegou na pizzaria.");
	}

	public List<Cliente> getClientes() {
		List<Cliente> todos = new ArrayList<>();
		todos.addAll(this.clientesNaoAtendidos);
		todos.addAll(this.clientesAtendidos);
		return todos;
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
			} else {
				System.out.println("Cliente " + cliente.getNome() + " está esperando um garçon.");
			}
		}
	}

	private void clienteFazPedido(Cliente cliente) {
		Garcom garcom = pegarGarconDisponivel();
		System.out.println("Garçon " + garcom.getNome() + " vai atender cliente " + cliente.getNome() + ".");
		Pedido novoPedido = cliente.novoPedido();
		garcom.setPedido(novoPedido);
		clientesNaoAtendidos.remove(cliente);
		clientesAtendidos.add(cliente);
		System.out.println("Garçon " + garcom.getNome() + " pegou o pedido " + novoPedido.getSabores()
				+ " do cliente " + cliente.getNome() + ".");
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

}
