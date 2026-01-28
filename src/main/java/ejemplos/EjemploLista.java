package ejemplos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EjemploLista {

	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<>();
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNextInt()) {
				int n = in.nextInt();
				lista.addLast(n);
			}
		}
		int suma = 0;
		for (int n : lista)
			suma += n;
		int media = suma / lista.size();
		System.out.println("Suma: " + suma);
		System.out.println("Media: " + media);
	}

}
