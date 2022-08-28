package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PedidoFactory {

	private static int QTD_MAX_PIZZAS = 5;
	private static Random random = new Random();
	private static String[] SABORES_POSSIVEIS = new String[] { "Calabresa", "Mussarela", "Peperoni", "Portuguesa", "Alho-Poró", "Vegetariana" };

	public Pedido novoPedido() {

		int quantidadePizzas = random.nextInt(QTD_MAX_PIZZAS)+1;
		List<String> sabores = new ArrayList<>();
		for (int i=0; i<quantidadePizzas; i++) {
			String sabor = escolheSaborAleatorio();
			sabores.add(sabor);
		}
		return new Pedido(sabores);
	}

	private String escolheSaborAleatorio() {
		int posicaoEsoclhida = random.nextInt(SABORES_POSSIVEIS.length);
		return SABORES_POSSIVEIS[posicaoEsoclhida];
	}

}
