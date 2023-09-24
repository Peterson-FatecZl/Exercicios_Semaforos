package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread {
	private int numeroCarro;
	private Semaphore semaforoDaCorrida = new Semaphore(5);
	private double distanciaPistaMetros = 50000.0;
	private double melhorTempoDaVoltaEmSegundos = Integer.MAX_VALUE;

	public ThreadCorrida(int numeroDoCarro) {
		this.numeroCarro = numeroDoCarro;

	}

	public void run() {
		try {
			semaforoDaCorrida.acquire();// aqui garantimos que apenas 5 carros estão na pista
			volta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoDaCorrida.release();
		}
	}

	public void volta() {// cada escuderia envia um carro por vez, pegamos o melhor tempo e retornamos
		Semaphore semaforoDaEscuderia = new Semaphore(1);

		try {
			semaforoDaEscuderia.acquire();
			for (int volta = 0; volta < 3; volta++) {
				int velocidadeMediaDoCarro_MetrosPorSegundo = (int) (Math.random() * 201) + 100;
				double novoTempoDeVolta = distanciaPistaMetros / velocidadeMediaDoCarro_MetrosPorSegundo;
				System.out.printf("O carro %d deu uma volta de %.2f \n",numeroCarro, novoTempoDeVolta);

				if (melhorTempoDaVoltaEmSegundos > novoTempoDeVolta) {
					melhorTempoDaVoltaEmSegundos = novoTempoDeVolta;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println();
			semaforoDaEscuderia.release();
		}

	}

	public double pegaMelhorTempo() {
		return melhorTempoDaVoltaEmSegundos;// pega o tempo do carro
	}

	public int pegaNumero() {
		return numeroCarro;
	}
}
