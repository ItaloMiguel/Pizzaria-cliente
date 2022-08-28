package pizzaria;

import java.util.Scanner;

public class PausinhaInterativa implements Pausinha {

	@Override
	public void pausar() {
		System.out.println("Prosseguir? 'y' para 'Yes': ");
		Scanner scanner = new Scanner(System.in);
		scanner.next();
	}

}
