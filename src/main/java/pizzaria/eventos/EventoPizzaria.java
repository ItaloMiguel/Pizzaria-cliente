package pizzaria.eventos;

public abstract class EventoPizzaria {

	private TipoEvento tipoEvento;
	
	public EventoPizzaria(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	@Override
	public String toString() {
		return "EventoPizzaria [tipoEvento=" + tipoEvento + "]";
	}
	
}
