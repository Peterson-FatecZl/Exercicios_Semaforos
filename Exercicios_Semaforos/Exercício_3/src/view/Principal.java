package view;

import controller.ThreadBanco;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		for (int ctd = 0; ctd < 20; ctd++) {
			int operacao = (int) (Math.random() * 2) + 1;
			Thread threadBanco = new ThreadBanco(ctd, operacao, 500, (Math.random() * 401 + 100));
			threadBanco.start();
			
		}

	}

}
