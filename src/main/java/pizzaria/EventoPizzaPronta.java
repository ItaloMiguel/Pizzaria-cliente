package pizzaria;

public class EventoPizzaPronta extends EventoPizzaria {

	private Pizzaiolo pizzaiolo;
	private Pedido pedido;
	
	public EventoPizzaPronta(Pedido pedido, Pizzaiolo pizzaiolo) {
		super(TipoEvento.PIZZA_ESTA_PRONTA);
		this.pedido = pedido;
		this.pizzaiolo = pizzaiolo;
	}
	
	public Pizzaiolo getPizzaiolo() {
		return pizzaiolo;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

}
