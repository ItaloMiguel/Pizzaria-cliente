package pizzaria;

import java.util.Random;

public class GarcomFactory {

	private static Random random = new Random();
	private static String[] NOMES_POSSIVEIS = new String[] { "Amélie", "Nathan", "Camille", "Pierre", "Dominique",
			"Marcel", "Sophie", "Michelle", "Simon", "Bernard", "Vincent", "Antoine" };

	public Garcom novoGarcom() {

		String nome = escolheNomeAleatorio();
		return new Garcom(nome);
	}

	private String escolheNomeAleatorio() {
		int posicaoEsoclhida = random.nextInt(NOMES_POSSIVEIS.length);
		return NOMES_POSSIVEIS[posicaoEsoclhida];
	}

}
