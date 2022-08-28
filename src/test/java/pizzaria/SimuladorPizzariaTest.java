package pizzaria;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SimuladorPizzariaTest {
	
	private static List<Integer> TEMPOS_PRA_CRIAR_CLIENTES = Arrays.asList(2, 3, 5, 7, 8);

	private SimuladorPizzaria simulador;
	private Pizzaria pizzaria;
	
	@Before
	public void setup() {
		
		Pausinha pausinha = new SemPausinha();
		NovoClienteDecider novoClienteDecider = new NovoClienteDeciderDeterministico(TEMPOS_PRA_CRIAR_CLIENTES);
		
		simulador = new SimuladorPizzaria(pausinha, novoClienteDecider);
		pizzaria = simulador.getPizzaria();
	}
	
	@Test
	public void testeDeAceitacao() {

		assertEquals(3, simulador.getPizzaria().getGarcons().size());
		
		simulador.avancarSimulacao(); /// tempo 1
		assertEstadoPizzaria(0, 0, 3, 0);
		
		simulador.avancarSimulacao(); // tempo 2
		assertEstadoPizzaria(1, 0, 2, 1);

		simulador.avancarSimulacao(); // tempo 3
		assertEstadoPizzaria(2, 0, 1, 2);

		simulador.avancarSimulacao(); // tempo 4
		assertEstadoPizzaria(2, 0, 1, 2);

		simulador.avancarSimulacao(); // tempo 5
		assertEstadoPizzaria(3, 0, 0, 3);

		simulador.avancarSimulacao(); // tempo 6
		assertEstadoPizzaria(3, 0, 0, 3);

		simulador.avancarSimulacao(); // tempo 7
		assertEstadoPizzaria(3, 1, 0, 3);

		simulador.avancarSimulacao(); // tempo 8
		assertEstadoPizzaria(3, 2, 0, 3);

		simulador.avancarSimulacao(); // tempo 9
		assertEstadoPizzaria(3, 2, 0, 3);

		simulador.avancarSimulacao(); // tempo 10
		assertEstadoPizzaria(3, 2, 0, 3);
	}

	private void assertEstadoPizzaria(int qtdClientesAtendidos, int QtdClientesNaoAtendidos, int garconsDisponiveis, int garconsOcupados) {

		assertEquals(qtdClientesAtendidos, pizzaria.getClientesAtendidos().size());
		assertEquals(QtdClientesNaoAtendidos, pizzaria.getClientesNaoAtendidos().size());
		assertEquals(garconsDisponiveis, pizzaria.getGarconsDisponiveis().size());
		assertEquals(garconsOcupados, pizzaria.getGarconsOcupados().size());
	}
}
