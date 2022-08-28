package pizzaria;

public class PizzariaListenerConsolePrinter implements PizzariaListener {

	@Override
	public void ocorreuEvento(EventoPizzaria evento) {

		switch (evento.getTipoEvento()) {

		case CLIENTE_CHEGOU:
			String nomeCliente = ((EventoChegouCliente) evento).getCliente().getNome();
			System.out.println("Cliente " + nomeCliente + " chegou na pizzaria.");
			break;

		case GARCON_PEGOU_PEDIDO:
			EventoGarconPegouPedido ev = (EventoGarconPegouPedido) evento;
			System.out.println("Garçon " + ev.getGarcom().getNome() + " pegou o pedido " + ev.getPedido().getSabores()
					+ " do cliente " + ev.getCliente().getNome() + ".");
			break;
			
		default:
			throw new IllegalStateException(
					"Não conheço o tipo evento " + evento.getTipoEvento() + ". Favor atualizar a classe "
							+ this.getClass().getName() + " para lidar com esse tipo de evento.");
		}

	}

}
