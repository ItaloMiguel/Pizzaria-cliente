package pizzaria;

public class Main {

	public static void main(String[] args) {

		Pausinha pausinha = new PausinhaInterativa();
		NovoClienteDecider novoClienteDecider = new NovoClienteDeciderAleatorio();
		PizzariaListener listener = new PizzariaListenerConsolePrinter();
		
		SimuladorPizzaria simulador = new SimuladorPizzaria(pausinha, novoClienteDecider, listener);
		
		simulador.iniciarSimulacao();
	}

}
