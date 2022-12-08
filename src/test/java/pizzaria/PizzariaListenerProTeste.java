package pizzaria;

import pizzaria.eventos.EventoPizzaria;
import pizzaria.listener.PizzariaListener;

import java.util.ArrayList;
import java.util.List;

public class PizzariaListenerProTeste implements PizzariaListener {

	private List<EventoPizzaria> eventos = new ArrayList<>();
	
	@Override
	public void ocorreuEvento(EventoPizzaria evento) {
		this.eventos.add(evento);
		
	}

	public List<EventoPizzaria> getEventos() {
		return this.eventos;
	}

	public void limparEventosGuardados() {
		this.eventos = new ArrayList<>();
	}

}
