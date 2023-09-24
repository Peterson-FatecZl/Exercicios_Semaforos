package view;

import controller.AuxiliarCarro;
import controller.ThreadCorrida;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        ThreadCorrida[] corrida = new ThreadCorrida[14];

        for (int ctd = 0; ctd < 14; ctd++) {
            corrida[ctd] = new ThreadCorrida(ctd);
            corrida[ctd].start();
        }

        for (int ctd = 0; ctd < 14; ctd++) {
            corrida[ctd].join();
        }

        // Agora que todas as threads terminaram, podemos ordenar os carros
        AuxiliarCarro[] ordemDeChegada = carrosOrdenados(corrida);

        for (int ctd = 0; ctd < 14; ctd++) {
            System.out.printf("O %d" + "° colocado foi o carro de número %d" +" com o melhor tempo de volta de %.3fs \n",(ctd + 1), ordemDeChegada[ctd].numeroCarro, + ordemDeChegada[ctd].melhorVolta)  ;
        }
    
	}

	
	
//Ordenação dos carros pelas ordens de Chegada	
	private static AuxiliarCarro[] carrosOrdenados(ThreadCorrida[] corrida) {
		AuxiliarCarro[] carro = new AuxiliarCarro[14];

		for (int i = 0; i < 14; i++) {
			carro[i] = new AuxiliarCarro(0, 0.0);// Inicializa cada elemento do array
			carro[i].numeroCarro = corrida[i].pegaNumero();
			carro[i].melhorVolta = corrida[i].pegaMelhorTempo();
		}
		for (int i = 0; i < 14 - 1; i++) {
			for (int j = 0; j < 14 - i - 1; j++) {
				if (carro[j].melhorVolta > carro[j + 1].melhorVolta) {
					AuxiliarCarro temp = carro[j];
					carro[j] = carro[j + 1];
					carro[j + 1] = temp;

				}
			}
		}
		return carro;
	}

}
