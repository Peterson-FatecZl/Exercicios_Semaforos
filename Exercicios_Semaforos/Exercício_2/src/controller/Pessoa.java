package controller;

import java.util.concurrent.Semaphore;

public class Pessoa extends Thread {
	private String pessoaId;
	private int percorrido = 0;
	private int passo = 0;
	private Semaphore porta = new Semaphore(1);

	public Pessoa(String PessoaId) {
		this.pessoaId = PessoaId;
	}

	public void run() {
		while (percorrido <= 200) {
			passo = (int) (Math.random() * 3) + 4;//pessoa da um passo
			try {
				sleep(1000);//o passo demora 1 segundo
//				System.out.println("Pessoa "+pessoaId+" deu um passo de "+passo);//caso queira ver cada passo, retire as "//" do começo da linha
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			percorrido += passo;
		}
		if(percorrido >= 200) {//primeiro a chegar
			try {
				porta.acquire();
				System.out.println("A "+pessoaId+" está cruzando a Porta");
				sleep((int)(Math.random()*1001)+1000);//de 1 a 2 segundos (aleatoriamente)
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				porta.release();
			}
		}
	}

}
