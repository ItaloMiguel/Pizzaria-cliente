package pizzaria;

import java.util.Scanner;

public class SimuladorPizzaria {

	private PizzariaFactory pizzariaFactory = new PizzariaFactory();
	private NovoClienteDecider novoClienteDecider = new NovoClienteDeciderAleatorio();
	private ClienteFactory clienteFactory = new ClienteFactory();
	private PizzariaRender render = new ConsolePizzariaRender();

	private Pizzaria pizzaria = pizzariaFactory.criarPizzaria();
	private int tempo;

	public void iniciarSimulacao() {

		System.out.println("INICIANDO O SIMULADOR DE PIZZARIA =D");

		tempo = 0;
		while (true) {

			tempo++;
			System.out.println("\nSimulação está no tempo " + tempo);

			criarNovosClientes();

			pizzaria.clientesFazemPedidos();

			render.render(pizzaria);

			pausinha();
		}

	}

	private void criarNovosClientes() {
		boolean deveCriarNovoCliente = novoClienteDecider.deveGerarNovoCliente(tempo);
		if (deveCriarNovoCliente) {
			Cliente novoCliente = clienteFactory.novoCliente();
			pizzaria.novoClienteChegou(novoCliente);
		}
	}

	private void pausinha() {

		System.out.println("Prosseguir? 'y' para 'Yes': ");
		Scanner scanner = new Scanner(System.in);
		scanner.next();
	}
}
