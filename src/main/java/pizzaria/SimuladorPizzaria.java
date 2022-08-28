package pizzaria;

public class SimuladorPizzaria {

	private Pizzaria pizzaria = new Pizzaria();
	private NovoClienteDecider novoClienteDecider = new NovoClienteDeciderAleatorio();
	private ClienteFactory clienteFactory = new ClienteFactory();
	private PizzariaRender render = new ConsolePizzariaRender();
	
	public void iniciarSimulacao() {
		
		System.out.println("### INICIANDO O SIMULADOR DE PIZZARIA =D ###");
		
		int tempo = 0;
		while(true) {
			
			pausinha();
			tempo++;
			System.out.println("\n## Simulação está no tempo " + tempo);
			
			boolean deveCriarNovoCliente = novoClienteDecider.deveGerarNovoCliente(tempo);
			if (deveCriarNovoCliente) {
				Cliente novoCliente = clienteFactory.novoCliente();
				pizzaria.novoClienteChegou(novoCliente);
			}
			
			render.render(pizzaria);
		}
		
	}

	private void pausinha() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new IllegalStateException("Sleep não funcionou, nunca deveria acontecer! ", e);
		}
	}

}
