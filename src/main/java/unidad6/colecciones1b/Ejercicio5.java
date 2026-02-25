package unidad6.colecciones1b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Ejercicio5 {

	public static void main(String[] args) {
		int S = leerNumeroDeSecuencias();
		int N;
		int K;
		for (int i=0; i<S; i++) {
			do {
				List<Integer> lista = leerVariosNumeros(2, "Introduce el valor de N y K: ");
				if ((N = lista.get(0)) < (K = lista.get(1)))
						System.out.println("K no puede ser mayor que N");
			} while (N < K);
			List<Integer> secuencia = leerVariosNumeros(N, "Números de la secuencia: ");
			procesarSecuencia(secuencia, K);
			System.out.println(secuencia);
		}
	}
	
	static int leerNumeroDeSecuencias() {
		int n = 0;
		while (n <= 0)
			try {
				n = Integer.parseInt(IO.readln("Número de secuencias: "));
				if (n <= 0)
					System.out.println("Error, debe ser mayor que cero");
			} catch (NumberFormatException e) {
				System.out.println("Error, inténtalo de nuevo");
			}
		return n;
	}
	
	static List<Integer> leerVariosNumeros(int n, String mensaje) {
		String [] valores;
		while (true)
			try  {
				valores = IO.readln(mensaje).trim().split("\\s+");
				if (valores.length != n)
					System.out.println("Error, inténtalo de nuevo");
				else
					return Arrays.stream(valores).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
			} catch (NumberFormatException e) {
				System.out.println("Error, inténtalo de nuevo");
			}
	}
	
//	static void procesarSecuencia(List<Integer> secuencia, int K) {
//		for (int i=0; i<K; i++) {
//			ListIterator<Integer> it = secuencia.listIterator();
//			while (it.hasNext()) {
//				int n = it.next();
//				if (it.hasNext()) {
//					int sgte = it.next();
//					if (n < sgte) {
//						it.previous();
//						it.previous();
//						it.remove();
//						break;
//					}
//					it.previous();
//				}
//				else
//					it.remove();
//			}
//		}
//	}
	
	static void procesarSecuencia(List<Integer> secuencia, int K) {
		for (int i=0; i<K; i++) {
			ListIterator<Integer> it = secuencia.listIterator();
			while (it.hasNext()) {
				int n = it.next();
				if (it.hasNext()) {
					if (n < secuencia.get(it.nextIndex())) {
						it.remove();
						break;
					}
				}
				else
					it.remove();
			}
		}
	}

}
