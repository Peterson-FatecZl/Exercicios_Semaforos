package controller;

import java.util.concurrent.Semaphore;

public class ThreadsDeProcessamento extends Thread {

	private int threadID;
	private Semaphore semaforo = new Semaphore(1);

	public ThreadsDeProcessamento(int _ThreadID) {
		this.threadID = _ThreadID;
	}

	public void run() {
		try {
			calculos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calculos() throws Exception {
		if (threadID % 3 == 0) {
			int calculo = (int) (Math.random() * 1001) + 1000;// de 1 a 2 segundo
			System.out.println("Fazendo Calculo...");
			Thread.sleep(calculo);// tempo dos calculos

			semaforo.acquire();
			System.out.println("Thread " + threadID + " Fazendo Transação com Banco de Dados");
			Thread.sleep(1500);// tempo de transação para o BD
			semaforo.release();

		} else if (threadID % 3 == 1) {
			int calculo = (int) (Math.random() * 801) + 200;// de 0,2 a 1 segundo
			System.out.println("Fazendo Calculo...");
			Thread.sleep(calculo);// tempo dos calculos

			semaforo.acquire();
			System.out.println("Thread " + threadID + " Fazendo Transação com Banco de Dados");
			Thread.sleep(1000);// tempo de transação para o BD
			semaforo.release();

		} else if (threadID % 3 == 2) {
			int calculo = (int) (Math.random() * 1001) + 500;// de 0,2 a 1 segundo
			System.out.println("Fazendo Calculo...");
			Thread.sleep(calculo);// tempo dos calculos

			semaforo.acquire();
			System.out.println("Thread " + threadID + " Fazendo Transação com Banco de Dados");
			Thread.sleep(1500);// tempo de transação para o BD
			semaforo.release();

		}

	}
}
