package pizzaria;

public class SimuladorPizzaria {

	private PizzariaFactory pizzariaFactory = new PizzariaFactory();
	private ClienteFactory clienteFactory = new ClienteFactory();
	private PizzariaRender render = new ConsolePizzariaRender();
	private Pausinha pausinha;
	private NovoClienteDecider novoClienteDecider;
	private Pizzaria pizzaria;
	
	private int tempo = 0;
	private boolean pizzariaAberta;
	
	public SimuladorPizzaria(Pausinha pausinha, NovoClienteDecider novoClienteDecider, PizzariaListener listener) {
		this.pausinha = pausinha;
		this.novoClienteDecider = novoClienteDecider;
		this.pizzaria = pizzariaFactory.criarPizzaria(listener);
		this.pizzariaAberta = true;
	}
	
	public void iniciarSimulacao() {
		while (this.pizzariaAberta == true) {
			avancarSimulacao();
		}
	}
	
	public void avancarSimulacao() {

		if (tempo == 0) {
			System.out.println("INICIANDO O SIMULADOR DE PIZZARIA =D");
		}

		tempo++;
		System.out.println("\nSimulação está no tempo " + tempo);

		criarNovosClientes();

		pizzaria.clientesFazemPedidos();
		
		pizzaria.deixarGarcomDisponivel(tempo);
		pizzaria.deixarPizzaioloDIsponivel(tempo);

		render.render(pizzaria);
		fecharPizzaria();
	}

	private void fecharPizzaria() {
		boolean pausar = pausinha.pausar();
		if(pausar == false) {
			System.out.println("\nFINALIZANDO O SIMULADOR DE PIZZARIA =(");
			this.pizzariaAberta = false;
		}
	}

	private void criarNovosClientes() {
		boolean deveCriarNovoCliente = novoClienteDecider.deveGerarNovoCliente(tempo);
		if (deveCriarNovoCliente) {
			Cliente novoCliente = clienteFactory.novoCliente();
			pizzaria.novoClienteChegou(novoCliente);
		}
	}

	public Pizzaria getPizzaria() {
		return this.pizzaria;
	}
	
	public boolean pizzariaAberta() {
		return this.pizzariaAberta;
	}

}
