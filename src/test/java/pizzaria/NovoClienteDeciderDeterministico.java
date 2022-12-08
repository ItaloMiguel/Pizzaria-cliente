package pizzaria;

import pizzaria.decider.NovoClienteDecider;

import java.util.List;

public class NovoClienteDeciderDeterministico implements NovoClienteDecider {

	private List<Integer> temposParaCriarClientes;
	
	public NovoClienteDeciderDeterministico(List<Integer> temposParaCriarClientes) {
		this.temposParaCriarClientes = temposParaCriarClientes;
	}

	@Override
	public boolean deveGerarNovoCliente(int tempoSimulacao) {
		return temposParaCriarClientes.contains(tempoSimulacao);
	}

}
