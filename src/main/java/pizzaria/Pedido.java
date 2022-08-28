package pizzaria;

import java.util.Collection;

public class Pedido {

	private Collection<String> sabores;

	public Pedido(Collection<String> sabores) {
		super();
		this.sabores = sabores;
	}

	public Collection<String> getSabores() {
		return sabores;
	}
	
}
