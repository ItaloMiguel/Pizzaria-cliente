package pizzaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SimuladorPizzariaTest {
	
	private static List<Integer> TEMPOS_PRA_CRIAR_CLIENTES = Arrays.asList(2, 3, 5, 7, 8, 10);

	private PizzariaListenerProTeste listener = new PizzariaListenerProTeste();
	private SimuladorPizzaria simulador;
	private Pizzaria pizzaria;
	
	@Before
	public void setup() {
		
		Pausinha pausinha = new SemPausinha();
		NovoClienteDecider novoClienteDecider = new NovoClienteDeciderDeterministico(TEMPOS_PRA_CRIAR_CLIENTES);
		
		simulador = new SimuladorPizzaria(pausinha, novoClienteDecider, listener);
		pizzaria = simulador.getPizzaria();
	}
	
	@Test
	public void testeDeAceitacao() {

		assertEquals(3, simulador.getPizzaria().getGarcons().size());
		
		simulador.avancarSimulacao(); /// tempo 1
		assertEstadoPizzaria(0, 0, 3, 0);
		List<EventoPizzaria> eventos = listener.getEventos();
		assertEquals(0, eventos.size());
		
		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 2
		assertEventos(eventos, new TipoEvento[] {TipoEvento.CLIENTE_CHEGOU, TipoEvento.GARCON_PEGOU_PEDIDO});
		assertEstadoPizzaria(1, 0, 3, 0);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 3
		assertEventos(eventos, new TipoEvento[] {TipoEvento.CLIENTE_CHEGOU, TipoEvento.GARCON_PEGOU_PEDIDO});
		assertEstadoPizzaria(2, 0, 2, 1);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 4
		assertEventos(eventos, new TipoEvento[] {});
		assertEstadoPizzaria(2, 0, 3, 0);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 5
		assertEventos(eventos, new TipoEvento[] {TipoEvento.CLIENTE_CHEGOU, TipoEvento.GARCON_PEGOU_PEDIDO});
		assertEstadoPizzaria(3, 0, 2, 1);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 6
		assertEventos(eventos, new TipoEvento[] {});
		assertEstadoPizzaria(3, 0, 3, 0);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 7
		assertEventos(eventos, new TipoEvento[] {TipoEvento.CLIENTE_CHEGOU, TipoEvento.GARCON_PEGOU_PEDIDO});
		assertEstadoPizzaria(4, 0, 2, 1);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 8
		assertEventos(eventos, new TipoEvento[] {TipoEvento.CLIENTE_CHEGOU, TipoEvento.GARCON_PEGOU_PEDIDO});
		assertEstadoPizzaria(5, 0, 2, 1);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 9
		assertEventos(eventos, new TipoEvento[] {});
		assertEstadoPizzaria(5, 0, 2, 1);

		listener.limparEventosGuardados();
		simulador.avancarSimulacao(); // tempo 10
		assertEventos(eventos, new TipoEvento[] {TipoEvento.CLIENTE_CHEGOU, TipoEvento.GARCON_PEGOU_PEDIDO});
		assertEstadoPizzaria(6, 0, 2, 1);
	}

	private void assertEstadoPizzaria(int qtdClientesAtendidos, int QtdClientesNaoAtendidos, int garconsDisponiveis, int garconsOcupados) {

		assertEquals(qtdClientesAtendidos, pizzaria.getClientesAtendidos().size());
		assertEquals(QtdClientesNaoAtendidos, pizzaria.getClientesNaoAtendidos().size());
		assertEquals(garconsDisponiveis, pizzaria.getGarconsDisponiveis().size());
		assertEquals(garconsOcupados, pizzaria.getGarconsOcupados().size());
	}
	
	private void assertEventos(List<EventoPizzaria> eventos, TipoEvento[] tiposEventos) {
		eventos = listener.getEventos();
		assertEquals(tiposEventos.length, eventos.size());
		for (TipoEvento tipoEvento : tiposEventos) {
			boolean achou = eventos.stream().anyMatch(e -> e.getTipoEvento() == tipoEvento);
			assertTrue("Não achei tipoEvento " + tipoEvento + " na lista de eventos " + eventos + ".", achou);
		}
		
	}
}
