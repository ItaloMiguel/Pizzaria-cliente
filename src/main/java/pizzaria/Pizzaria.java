package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pizzaria {

	private List<Cliente> clientes = new ArrayList<>();

	public void novoClienteChegou(Cliente novoCliente) {
		this.clientes.add(novoCliente);
		System.out.println("Cliente " + novoCliente.getNome() + " chegou na pizzaria.");
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	
	
}
