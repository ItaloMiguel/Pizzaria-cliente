package pizzaria;

import java.util.LinkedList;
import java.util.Queue;

public class PizzariaFactory {

	private static final int QUANTIDADE_GARCONS = 3;
	private static final int QUANTIDADE_PIZZAIOLOS = 3;

	private GarcomFactory garcomFactory = new GarcomFactory();
	private PizzaioloFactory pizzaioloFactory = new PizzaioloFactory();
 
	public Pizzaria criarPizzaria(PizzariaListener listener) {

		Queue<Garcom> garcons = new LinkedList<>();
		for (int i = 0; i < QUANTIDADE_GARCONS; i++) {
			Garcom novoGarcon = garcomFactory.novoGarcom();
			garcons.add(novoGarcon);
		}

		Queue<Pizzaiolo> pizzaiolos = new LinkedList<>();
		for(int i = 0; i< QUANTIDADE_PIZZAIOLOS; i++) {
			Pizzaiolo novoPizzaiolo = pizzaioloFactory.novoPizzaiolo();
			pizzaiolos.add(novoPizzaiolo);
		}
		
		return new Pizzaria(garcons, pizzaiolos,listener);
	}

}
