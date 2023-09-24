package view;

import controller.ThreadCozinhar;

public class Principal {

	public static void main(String[] args) {
		
		for(int quantidadeDePratos = 1; quantidadeDePratos <= 5; quantidadeDePratos++) {
			Thread prato = new ThreadCozinhar(quantidadeDePratos);
			prato.start();

//			try {
//				prato.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

}
