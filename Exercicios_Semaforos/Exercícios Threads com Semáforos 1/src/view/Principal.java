package view;

import controller.ThreadsDeProcessamento;

public class Principal {

	public static void main(String[] args) {
		for(int id = 1; id <= 21; id++) {
			Thread transação = new ThreadsDeProcessamento(id);
			transação.start();
		}

	}

}
