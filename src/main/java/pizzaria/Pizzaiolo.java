package pizzaria;

import java.util.Objects;

public class Pizzaiolo {

	private String nome;
	private Pedido pedido;

	public Pizzaiolo(String nome) {
		this.nome = nome;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public String getNome() {
		return nome;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
