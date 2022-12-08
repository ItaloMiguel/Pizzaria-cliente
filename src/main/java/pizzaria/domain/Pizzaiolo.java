package pizzaria.domain;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Pizzaiolo {

	private String nome;
	private Pedido pedido;
	private Queue<Pedido> pedidosFeito = new LinkedList<>();
	
	
	public Pizzaiolo(String nome) {
		this.nome = nome;
	}

	public Pedido getPedido() {
		return pedidosFeito.poll();
	}

	public String getNome() {
		return nome;
	}

	public void setPedido(Pedido pedido) {
		this.pedidosFeito.add(pedido);
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
		Pizzaiolo other = (Pizzaiolo) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(pedido, other.pedido);
	}

	@Override
	public String toString() {
		return "Pizzaiolo [nome=" + nome + ", pedido=" + pedido + "]";
	}
 
}
