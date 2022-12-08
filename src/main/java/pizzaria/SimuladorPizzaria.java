package pizzaria;

import pizzaria.decider.NovoClienteDecider;
import pizzaria.domain.Cliente;
import pizzaria.domain.Pizzaria;
import pizzaria.factory.ClienteFactory;
import pizzaria.factory.PizzariaFactory;
import pizzaria.listener.PizzariaListener;
import pizzaria.pausas.Pausinha;
import pizzaria.render.ConsolePizzariaRender;
import pizzaria.render.PizzariaRender;

public class SimuladorPizzaria {

	private final PizzariaFactory pizzariaFactory = new PizzariaFactory();
	private final ClienteFactory clienteFactory = new ClienteFactory();
	private final PizzariaRender render = new ConsolePizzariaRender();
	private final Pausinha pausinha;
	private final NovoClienteDecider novoClienteDecider;
	private final Pizzaria pizzaria;
	
	private int tempo = 0;
	private boolean pizzariaAberta;
	
	public SimuladorPizzaria(Pausinha pausinha, NovoClienteDecider novoClienteDecider, PizzariaListener listener) {
		this.pausinha = pausinha;
		this.novoClienteDecider = novoClienteDecider;
		this.pizzaria = pizzariaFactory.criarPizzaria(listener);
		this.pizzariaAberta = true;
	}
	
	public void iniciarSimulacao() {
		while (this.pizzariaAberta) {
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

		pizzaria.garcomLevarPedidoParaCliente();
		pizzaria.clientesFazemPedidos();
		
		pizzaria.deixarGarcomDisponivel(tempo);
		pizzaria.deixarPizzaioloDIsponivel(tempo);
		pizzaria.clienteVaiEmbora(tempo);
		

		render.render(pizzaria);
		fecharPizzaria();
	}

	private void fecharPizzaria() {
		boolean pausar = pausinha.pausar();
		if(!pausar) {
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
