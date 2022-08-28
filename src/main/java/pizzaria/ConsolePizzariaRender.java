package pizzaria;

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
		System.out.println("## Garçons disponíveis: " + nomesDosGarconsDisponiveis);

		List<String> nomesDosGarconsOcupados = pizzaria.getGarconsOcupados().stream().map(g -> g.getNome())
				.collect(Collectors.toList());
		System.out.println("## Garçons ocupados: " + nomesDosGarconsOcupados);

	}

}
