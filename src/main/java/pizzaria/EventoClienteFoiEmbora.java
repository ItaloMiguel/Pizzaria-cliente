package pizzaria;

public class EventoClienteFoiEmbora extends EventoPizzaria {

	private Cliente cliente;
	
	public EventoClienteFoiEmbora(Cliente clienteAtendido) {
		super(TipoEvento.CLIENTE_FOI_EMBORA);
		this.cliente = clienteAtendido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

}
