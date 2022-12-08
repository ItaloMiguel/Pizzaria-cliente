package pizzaria.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Fogao {

	private Queue<Pedido> fazerPedido = new LinkedList<>();
	
	public Fogao() {
		//Por enquanto nao faz nada. Aguarde =)
	}

	public void setPedido(Pedido pedidoNaoFeito) {
		this.fazerPedido.add(pedidoNaoFeito);
	}

	public Pedido getPedido() {
		return fazerPedido.poll();
	}
	
}
