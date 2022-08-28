package pizzaria;

public class EventoChegouCliente extends EventoPizzaria {

	private Cliente cliente;

	public EventoChegouCliente(Cliente cliente) {
		super(TipoEvento.CLIENTE_CHEGOU);
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
