package view;

import controller.Pessoa;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		for (int ctd = 1; ctd <= 4; ctd++) {
			Thread pessoa = new Pessoa(String.valueOf(ctd));
			pessoa.start();
			
		}
	}

}
