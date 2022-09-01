package pizzaria;

import java.util.LinkedList;
import java.util.Queue;

public class PizzariaFactory {

	private static final int QUANTIDADE_GARCONS = 3;
	private static final int QUANTIDADE_PIZZAIOLOS = 3;
	private static final int QUANTIDADE_FOGOES = 3;

	Queue<Pizzaiolo> pizzaiolos = new LinkedList<>();
	Queue<Garcom> garcons = new LinkedList<>();
	Queue<Fogao> fogoes = new LinkedList<>();

	private GarcomFactory garcomFactory = new GarcomFactory();
	private PizzaioloFactory pizzaioloFactory = new PizzaioloFactory();

	public Pizzaria criarPizzaria(PizzariaListener listener) {

		for (int i = 0; i < QUANTIDADE_GARCONS; i++) {
			Garcom novoGarcon = garcomFactory.novoGarcom();
			garcons.add(novoGarcon);
		}

		for (int i = 0; i < QUANTIDADE_PIZZAIOLOS; i++) {
			Pizzaiolo novoPizzaiolo = pizzaioloFactory.novoPizzaiolo();
			pizzaiolos.add(novoPizzaiolo);
		}

		for (int i = 0; i < QUANTIDADE_FOGOES; i++) {
			Fogao novoFogao = new Fogao();
			fogoes.add(novoFogao);
		}

		return new Pizzaria(garcons, pizzaiolos, fogoes, listener);
	}

}
