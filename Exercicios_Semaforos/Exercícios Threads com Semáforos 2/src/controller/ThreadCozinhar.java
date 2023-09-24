package controller;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class ThreadCozinhar extends Thread {

	private int threadId;
	 private Random random = new Random();
	private Semaphore entrega = new Semaphore(1);

	public ThreadCozinhar(int _ThreadID) {
		this.threadId = _ThreadID;
	}

	public void run() {
        String prato;
        long tempoDeCozimento;

        if (threadId % 2 == 0) {
            prato = "Lasanha a Bolonhesa";
            tempoDeCozimento = 600 + random.nextInt(601); // Entre 0,6 e 1,2 segundos
        } else {
            prato = "Sopa de Cebola";
            tempoDeCozimento = 500 + random.nextInt(301); // Entre 0,5 e 0,8 segundos
        }

        System.out.println("Iniciando o cozimento do prato: " + prato + " " + threadId);

        for (int i = 1; i <= tempoDeCozimento; i += 100) {
            int percentual = i * 100 / (int) tempoDeCozimento;//Formula usada para calcular o percentual de cozimento.
            System.out.println("Prato " + prato + " " + threadId + " está " + percentual + "% pronto");
            try {
                Thread.sleep(100); // Aguarda 0,1 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Prato " + prato + " " + threadId + " pronto para entrega");

        try {
        	entrega.acquire();
//        	System.out.println();
            Thread.sleep(500); // Simula o tempo de entrega
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        	entrega.release();
        }

        System.out.println("\nPrato: " + prato + " " + threadId + " entregue");
    }
}