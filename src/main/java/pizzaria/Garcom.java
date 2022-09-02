package pizzaria;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Garcom {

	private String nome;
	private Queue<Pedido> pedido = new LinkedList<>();
	private Queue<Pedido> pedidoPronto = new LinkedList<>();

	public Garcom(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setPedido(Pedido pedido) {
		this.pedido.add(pedido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garcom other = (Garcom) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(pedido, other.pedido);
	}

	@Override
	public String toString() {
		return "Garcom [nome=" + nome + ", pedido=" + pedido + "]";
	}

	public void pegaPedidoEntregaAoPizzaiolo(Pedido novoPedido) {
		
	}

	public Pedido getPedido() {
		return pedido.poll();
	}

	public void pegaPedidoPronto(Pedido pedidoPronto) {
		this.pedidoPronto.add(pedidoPronto);
	}

	public Pedido getPedidoPronto() {
		return this.pedidoPronto.poll();
	}

}
