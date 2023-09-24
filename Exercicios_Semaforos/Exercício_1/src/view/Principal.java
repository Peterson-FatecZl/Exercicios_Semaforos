package view;

import controller.ThreadSentidoCarro;

public class Principal {

	public static void main(String[]args) {
		String[] vetorDe = {"Esquerda","Cima","Direita","Baixo"};
		String[] vetorPara = {"Direita","Baixo","Esquerda","Cima"};
		
		for(int ctd = 0; ctd < vetorDe.length; ctd++) {
			Thread sentido = new ThreadSentidoCarro(ctd, vetorDe[ctd], vetorPara[ctd]);
			sentido.start();
		}
		
	}
	
}
