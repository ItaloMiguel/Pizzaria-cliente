package pizzaria.eventos;

import pizzaria.domain.Cliente;
import pizzaria.domain.Garcom;
import pizzaria.domain.Pedido;

public class EventoClienteRecebeuPedido extends EventoPizzaria {

	private Pedido pedido;
	private Garcom garcom;
	private Cliente cliente;
	
	public EventoClienteRecebeuPedido(Pedido pedido, Garcom garcomDisponivel, Cliente clienteAtendido) {
		super(TipoEvento.CLIENTE_RECEBE_PIZZA);
		this.pedido = pedido;
		this.garcom = garcomDisponivel;
		this.cliente = clienteAtendido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
