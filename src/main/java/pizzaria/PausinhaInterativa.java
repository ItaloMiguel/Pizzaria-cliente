package pizzaria;

import java.util.Scanner;

public class PausinhaInterativa implements Pausinha {
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public boolean pausar() {
		System.out.print("Deseja manter a pizzaria aberta? 'y' para 'Yes': ");
		char scannerTeclado = scanner.next().charAt(0);
		if(scannerTeclado == 'y' || scannerTeclado == 'Y') {
			return true;
		}
		return false;
	}

}
