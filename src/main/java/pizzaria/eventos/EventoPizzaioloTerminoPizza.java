package pizzaria.eventos;

import pizzaria.domain.Pedido;
import pizzaria.domain.Pizzaiolo;

public class EventoPizzaioloTerminoPizza extends EventoPizzaria {

	private Pizzaiolo pizzaiolo;
	private Pedido pedido;
	
	public EventoPizzaioloTerminoPizza(Pizzaiolo pizzaioloOcupado, Pedido sabores) {
		super(TipoEvento.PIZZAIOLO_TERMINO_PEDIDO);
		this.pizzaiolo = pizzaioloOcupado;
		this.pedido = sabores;
	}

	public Pizzaiolo getPizzaiolo() {
		return pizzaiolo;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
