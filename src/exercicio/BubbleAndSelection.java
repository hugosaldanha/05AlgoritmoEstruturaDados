package exercicio;

import java.util.Random;

import javax.swing.JOptionPane;

public class BubbleAndSelection {
	// Declara o contador como uma variável da classe
	static long contador = 0;

	public static void main(String[] args) {

		// para gerar o vetor
		// int[] v = gerarVetorOrdenado(0, 1000, 1);

		int[] v = gerarVetorDesordenado(0, 10000, 500000);

		System.out.println("Contando os loops na geração do vetor: " + contador);

		contador = 0;

		// Exemplo do vetor sendo utilizado
		long tempoInicioMilliseconds = System.currentTimeMillis();
		long tempoInicio = System.nanoTime();

		// AQUI !
		// Supondo que esse é o código do algoritmo de busca

		for (int i = 0; i < v.length; i++) {
			contador++;
			System.out.print(v[i] + ", ");
			if ((i + 1) % 100 == 0) {
				System.out.println();
			}
		}
		long tempoFinalMilliseconds = System.currentTimeMillis();
		long tempoFinal = System.nanoTime();
		System.out.println();
		System.out.println();
		System.out.println("Tempo de Execução em nanosegundos: " + (tempoFinal - tempoInicio));
		System.out.println("Tempo de Execução em milesegundos: " + (tempoFinalMilliseconds - tempoInicioMilliseconds));
		System.out.println("Contador: " + contador);
		contador = 0;

		// USANDO ORDENAÇÃO BUBBLE SORT
		/*
		 * ordenacaoBubble(v); System.out.println();
		 * System.out.println("Ordenação Bubble Sort"); System.out.println(); for (int i
		 * = 0; i < v.length; i++) { System.out.println(v[i]); }
		 * 
		 * int num =
		 * Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser buscado")
		 * );
		 * 
		 * int iIndice = busca(v, 0, v.length - 1, num); if (iIndice>=0) {
		 * System.out.println("Busca BUBBLE SORT"); System.out.println("O número " + num
		 * + " esta na posição " + iIndice + " do vetor"); } else {
		 * System.out.println("Busca BUBBLE SORT"); System.out.println("O número " + num
		 * + " não esta no vetor"); }
		 */

		// USANDO ORDENAÇÃO SELECT SORT

		OrdenacaoSelect(v);
		System.out.println();
		System.out.println("Ordenação Select Sort");
		System.out.println();
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}
		int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser buscado"));

		int iIndice = busca(v, 0, v.length - 1, num);
		if (iIndice >= 0) {
			System.out.println("Busca SELECT SORT");
			System.out.println("O número " + num + " esta na posição " + iIndice + " do vetor");
		} else {
			System.out.println("Busca SELECT SORT");
			System.out.println("O número " + num + " não esta no vetor");
		}
	}

	// metodo que gera o vetor ordenado
	static int[] gerarVetorOrdenado(int minimo, int tamanho, int incremento) {

		int[] vet = new int[tamanho];
		int valor = minimo;
		for (int i = minimo; i < tamanho; i++) {
			contador++;
			vet[i] = valor;
			valor += incremento;
		}
		return vet;
	}

	// metodo que gera o vetor desordenado
	static int[] gerarVetorDesordenado(int minimo, int tamanho, int valorMaximo) {
		Random random = new Random();
		int randomico = 0;

		int[] vet = new int[tamanho];
		int valor = minimo;
		for (int i = minimo; i < tamanho; i++) {
			contador++;
			vet[i] = random.nextInt(valorMaximo);
		}
		return vet;
	}

	public static void ordenacaoBubble(int iVet[]) {

		int iA, iB;
		int iT;

		for (iA = 1; iA < iVet.length; iA++) {
			for (iB = iVet.length - 1; iB >= iA; iB--) {
				if (iVet[iB - 1] > iVet[iB]) {
					iT = iVet[iB - 1];
					iVet[iB - 1] = iVet[iB];
					iVet[iB] = iT;
				}
			}
		}
	}

	public static void OrdenacaoSelect(int iVet[]) {
		int iA, iB, iC;
		int iT;

		for (iA = 0; iA < iVet.length - 1; iA++) {
			iC = iA;
			iT = iVet[iA];
			for (iB = iA + 1; iB < iVet.length; iB++) {
				if (iVet[iB] < iT) {
					iC = iB;
					iT = iVet[iB];
				}
			}
			iVet[iC] = iVet[iA];
			iVet[iA] = iT;
		}
	}

	// método de busca binaria recursiva
	public static int busca(int v[], int iB, int iA, int iK) {
		int iM = (iB + iA) / 2;
		if (iB <= iA)
			if (iK < v[iM])
				return busca(v, iB, iM - 1, iK);
			else if (iK > v[iM])
				return busca(v, iM + 1, iA, iK);
			else
				return iM;
		return -1;
	}

}
