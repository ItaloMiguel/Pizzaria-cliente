package pizzaria.factory;

import pizzaria.domain.Pizzaiolo;

import java.util.Random;

public class PizzaioloFactory {

	private static Random random = new Random();
	private static String[] NOMES_POSSIVEIS = new String[] { "Amélie", "Nathan", "Camille", "Pierre", "Dominique",
			"Marcel", "Sophie", "Michelle", "Simon", "Bernard", "Vincent", "Antoine" };

	public Pizzaiolo novoPizzaiolo() {
		String nome = escolheNomeAleatorio();
		return new Pizzaiolo(nome);
	}

	private String escolheNomeAleatorio() {
		int posicaoEsoclhida = random.nextInt(NOMES_POSSIVEIS.length);
		return NOMES_POSSIVEIS[posicaoEsoclhida];
	}
	
}
