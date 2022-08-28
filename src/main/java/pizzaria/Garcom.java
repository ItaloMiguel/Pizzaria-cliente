package pizzaria;

import java.util.Objects;

public class Garcom {

	private String nome;
	private Pedido pedido;

	public Garcom(String nome) {
		this.nome = nome;
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
		Garcom other = (Garcom) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(pedido, other.pedido);
	}

	@Override
	public String toString() {
		return "Garcom [nome=" + nome + ", pedido=" + pedido + "]";
	}

}
