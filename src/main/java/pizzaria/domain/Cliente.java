package pizzaria.domain;

import pizzaria.factory.PedidoFactory;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	private PedidoFactory pedidoFactory = new PedidoFactory();
	private ArrayList<Pedido> recebePedido = new ArrayList<>();
	
	private String nome;
	private Pedido pedido;
	private boolean jaPediu = false;

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean jaPediu() {
		return jaPediu;
	}

	public boolean aindaNaoPediu() {
		return !jaPediu;
	}

	public Pedido novoPedido() {
		this.pedido = pedidoFactory.novoPedido();
		this.jaPediu = true;
		return this.pedido;
	}

	public void setPedido(Pedido recebePedido) {
		this.recebePedido.add(recebePedido);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}

}
