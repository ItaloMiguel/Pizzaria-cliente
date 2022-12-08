package pizzaria.eventos;

import pizzaria.domain.Garcom;
import pizzaria.domain.Pedido;
import pizzaria.domain.Pizzaiolo;

public class EventoPizzaioloPegouPedido extends EventoPizzaria {

	private Garcom garcom;
	private Pedido pedido;
	private Pizzaiolo pizzaiolo;

	public EventoPizzaioloPegouPedido(Garcom garcom, Pedido pedido, Pizzaiolo pizzaiolo) {
		super(TipoEvento.PIZZAIOLO_PEGO_PEDIDO);
		this.garcom = garcom;
		this.pedido = pedido;
		this.pizzaiolo = pizzaiolo;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Pizzaiolo getPizzaiolo() {
		return pizzaiolo;
	}

}
