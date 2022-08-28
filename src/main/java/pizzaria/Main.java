package pizzaria;

public class Main {

	public static void main(String[] args) {

		Pausinha pausinha = new PausinhaInterativa();
		NovoClienteDecider novoClienteDecider = new NovoClienteDeciderAleatorio();
		
		SimuladorPizzaria simulador = new SimuladorPizzaria(pausinha, novoClienteDecider);
		
		simulador.iniciarSimulacao();
	}

}
