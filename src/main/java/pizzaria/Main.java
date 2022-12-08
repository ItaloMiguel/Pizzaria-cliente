package pizzaria;

import pizzaria.decider.NovoClienteDecider;
import pizzaria.decider.NovoClienteDeciderAleatorio;
import pizzaria.listener.PizzariaListener;
import pizzaria.listener.PizzariaListenerConsolePrinter;
import pizzaria.pausas.Pausinha;
import pizzaria.pausas.PausinhaInterativa;

public class Main {

	public static void main(String[] args) {

		Pausinha pausinha = new PausinhaInterativa();
		NovoClienteDecider novoClienteDecider = new NovoClienteDeciderAleatorio();
		PizzariaListener listener = new PizzariaListenerConsolePrinter();
		
		SimuladorPizzaria simulador = new SimuladorPizzaria(pausinha, novoClienteDecider, listener);
		
		simulador.iniciarSimulacao();
	}

}