package buscas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuscaBinaria {

	/**
	 * A busca binária é um algoritmo de busca eficiente que funciona dividindo 
	 * repetidamente a lista pela metade até encontrar o elemento procurado.
	 * 
	 * A lista deve estar ordenada para que a busca binária funcione corretamente.
	 * 
	 * Tempo de execução:
	 * A complexidade de tempo da busca binária é O(log n), onde n é o número de elementos 
	 * na lista. Isso significa que o tempo de execução aumenta logaritmicamente em relação 
	 * ao número de elementos. Por exemplo, para uma lista com 16 elementos, a busca binária 
	 * requer no máximo 4 comparações (porque log₂(16) = 4).
	 */

	public static void main(String[] args) { 
		List<String> nomes = new ArrayList<>();
		nomes.add(0, "Benicio");
		nomes.add(1, "Wallace");
		nomes.add(2, "Thiago");
		nomes.add(3, "Pedro");

		// Ordena a lista antes de realizar a busca binária
		List<String> nomesSortidos = nomes.stream().sorted().collect(Collectors.toList());

		String nomeChave = "Thiago";		
		
		int resultado = buscaBinaria(nomesSortidos, nomeChave);
		
		if(resultado != -1) {
			System.out.println("Nome encontrado = " + nomesSortidos.get(resultado));
		} else {
			System.out.println("Nenhum nome encontrado para: " + nomeChave);
		}
	}

	public static int buscaBinaria(List<String> nomes, String nomeProcurado) {
		int inicio = 0;
		int fim = nomes.size() - 1;

		while (inicio <= fim) {
			int meio = inicio + (fim - inicio) / 2;
			int comparacao = nomes.get(meio).compareTo(nomeProcurado);

			if (comparacao == 0) {
				return meio;
			} else if (comparacao < 0) {
				inicio = meio + 1;
			} else {
				fim = meio - 1;
			}
		}

		return -1; // Retorna -1 se o nome procurado não for encontrado
	}
}
