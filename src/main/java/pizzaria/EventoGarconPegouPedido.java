package pizzaria;

public class EventoGarconPegouPedido extends EventoPizzaria {

	private Cliente cliente;
	private Garcom garcom;
	private Pedido pedido;

	public EventoGarconPegouPedido(Garcom garcon, Pedido pedido, Cliente cliente) {
		super(TipoEvento.GARCON_PEGOU_PEDIDO);
		this.garcom = garcon;
		this.pedido = pedido;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
}
