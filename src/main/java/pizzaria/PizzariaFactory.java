package pizzaria;

import java.util.LinkedList;
import java.util.Queue;

public class PizzariaFactory {

	private static final int QUANTIDADE_GARCONS = 3;

	private GarcomFactory garcomFactory = new GarcomFactory();

	public Pizzaria criarPizzaria(PizzariaListener listener) {

		Queue<Garcom> garcons = new LinkedList<>();
		for (int i = 0; i < QUANTIDADE_GARCONS; i++) {
			Garcom novoGarcon = garcomFactory.novoGarcom();
			garcons.add(novoGarcon);
		}
		return new Pizzaria(garcons, listener);
	}

}
