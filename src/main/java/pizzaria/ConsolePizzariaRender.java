package pizzaria;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConsolePizzariaRender implements PizzariaRender {

	@Override
	public void render(Pizzaria pizzaria) {

		System.out.println("# Situação atual da pizzaria:");

		List<String> nomesDosClientesAtendidos = pizzaria.getClientesAtendidos().stream().map(c -> c.getNome())
				.collect(Collectors.toList());
		System.out.println("## Clientes dentro da pizzaria já atendidos: " + nomesDosClientesAtendidos);

		List<String> nomesDosClientesNaoAtendidos = pizzaria.getClientesNaoAtendidos().stream().map(c -> c.getNome())
				.collect(Collectors.toList());
		System.out.println("## Clientes dentro da pizzaria ainda não atendidos: " + nomesDosClientesNaoAtendidos);

		List<String> nomesDosGarconsDisponiveis = pizzaria.getGarconsDisponiveis().stream().map(g -> g.getNome())
				.collect(Collectors.toList());
		System.out.println(("## Garçons disponíveis: " + nomesDosGarconsDisponiveis));

		List<String> nomesDosGarconsOcupados = pizzaria.getGarconsOcupados().stream().map(g -> g.getNome())
				.collect(Collectors.toList());
		System.out.println("## Garçons ocupados: " + nomesDosGarconsOcupados);

		List<String> nomesDosPizzaioloDisponiveis = pizzaria.getPizzaioloDisponivel().stream().map(g -> g.getNome())
				.collect(Collectors.toList());
		System.out.println("## Pizzaiolo disponiveis: " + nomesDosPizzaioloDisponiveis);

		List<String> nomesDosPizzaioloOcupados = pizzaria.getPizzaioloOcupado().stream().map(g -> g.getNome())
				.collect(Collectors.toList());
		System.out.println("## Pizzaiolo ocupados: " + nomesDosPizzaioloOcupados);

		int fogoesDisponiveis = pizzaria.getFogoesDisponiveis();
		System.out.println("## total de fogao disponivel: " + fogoesDisponiveis);

		int fogoesOcupados = pizzaria.getFogoesOcupados();
		System.out.println("## total de fogao ocupados: " + fogoesOcupados);

		List<Collection<String>> filaDePedidos = pizzaria.getFilaDePedido().stream().map(p -> p.getSabores())
				.collect(Collectors.toList());
		System.out.println("## Pedidos na fila de espera: " + filaDePedidos);

		List<Collection<String>> pedidosPronto = pizzaria.getPedidoPronto().stream().map(pp -> pp.getSabores()).collect(Collectors.toList());
		System.out.println("## Pedidos pronto para entrega: " + pedidosPronto);
		
		
	}

}
