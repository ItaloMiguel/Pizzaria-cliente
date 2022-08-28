package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsolePizzariaRender implements PizzariaRender {

	@Override
	public void render(Pizzaria pizzaria) {

		List<String> nomesDosClientes = pizzaria.getClientes().stream().map(c -> c.getNome())
				.collect(Collectors.toList());
		System.out.println("## Clientes dentro da pizzaria: " + nomesDosClientes);
	}

}
