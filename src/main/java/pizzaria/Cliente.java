package pizzaria;

import java.util.Objects;

public class Cliente {

	private PedidoFactory pedidoFactory = new PedidoFactory();
	
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
