package controller;

import java.util.concurrent.Semaphore;

public class ThreadSentidoCarro extends Thread{

	private int carro;
	private String de;
	private String para;
	
	private Semaphore semaforo;
	
	public ThreadSentidoCarro(int carro, String de, String para) {
		this.carro = carro;
		this.de = de;
		this.para = para;
		this.semaforo = new Semaphore(1);
	}
	
	public void run(){
		try {
			semaforo.acquire();
			if(de.contains("baixo")||de.contains("cima")) {
				System.out.println("O Carro "+carro+" está indo de "+de+" para "+para);
			}else {
				System.out.println("O Carro "+carro+" está indo da "+de+" para "+para);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();			
		}
		
	}
	
}
