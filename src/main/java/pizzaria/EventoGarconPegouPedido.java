package pizzaria;

public class EventoGarconPegouPedido extends EventoPizzaria {

	private Cliente cliente;
	private Garcom garcon;
	private Pedido pedido;

	public EventoGarconPegouPedido(Garcom garcon, Pedido pedido, Cliente cliente) {
		super(TipoEvento.GARCON_PEGOU_PEDIDO);
		this.garcon = garcon;
		this.pedido = pedido;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Garcom getGarcon() {
		return garcon;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
}
