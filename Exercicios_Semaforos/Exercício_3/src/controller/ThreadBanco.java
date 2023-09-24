package controller;

import java.util.concurrent.Semaphore;

public class ThreadBanco extends Thread {
	private int codigoDaConta;
	private int tipoDeOperacao;
	private double saldoDaConta;
	private double valorDaTransacao;
	private Semaphore semaforo = new Semaphore(1);

	public ThreadBanco(int codigoConta, int operacao, double saldoConta, double valorTransacao) {
		this.codigoDaConta = codigoConta;
		this.tipoDeOperacao = operacao;
		this.saldoDaConta = saldoConta;
		this.valorDaTransacao = valorTransacao;
	}

	public void run() {
		if (tipoDeOperacao == 1) {
			try {
				sacar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (tipoDeOperacao == 2) {
			try {
				depositar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Desculpe Tipo de Operação Inválido\nInsira 1 para Saque.\nou\nInsira 2 para Depósito.");
		}
	}

	private void sacar() throws InterruptedException {
		try {
			semaforo.acquire();
//			Thread.sleep(1000);
			System.out.println("Saque de " + valorDaTransacao + " efetuado pela conta " + codigoDaConta);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();

		}
	}

	private void depositar() throws InterruptedException {
		try {
			semaforo.acquire();
//			Thread.sleep(1000);
			System.out.println("Depósito de " + valorDaTransacao + " efetuado pela conta " + codigoDaConta);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();

		}
	}
}
