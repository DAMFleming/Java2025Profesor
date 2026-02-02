package unidad6.colecciones1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {

	public static void main(String[] args) {
		int s;
		while (true) {
			try {
				s = Integer.parseInt(IO.readln("Número S de secuencias: "));
				break;
			} catch (NumberFormatException e) {
				IO.println("Incorrecto, introdúcelo de nuevo");
			}
		}
		for (int i=0; i<s; i++)
			procesarSecuencia();
	}
	
	static void procesarSecuencia() {
		int n, k;
		while (true) {
			try {
				String [] valores = IO.readln("Introduce N y K: ").split(" ");
				if (valores.length != 2)
					throw new NumberFormatException();
				n = Integer.parseInt(valores[0]);
				k = Integer.parseInt(valores[1]);
				if (k > n)
					throw new IllegalArgumentException();
				break;
			} catch (NumberFormatException e) {
				IO.println("Incorrecto, introdúcelos de nuevo");
			} catch (IllegalArgumentException e) {
				IO.println("K no debe de ser mayor que N, introdúcelos de nuevo");
			}
		}
		List<Integer> secuencia = leerSecuencia(n);
		borrarElementos(secuencia, k);
		System.out.println(secuencia);
	}
	
	static List<Integer> leerSecuencia(int n) {
		List<Integer> secuencia = new ArrayList<>();
		while (true) {
			try {
				String [] valores = IO.readln("Introduce la secuencia: ").split(" ");
				if (valores.length != n)
					throw new NumberFormatException();
				for (int i=0; i<valores.length; i++)
					secuencia.add(Integer.parseInt(valores[i]));
				break;
			} catch (NumberFormatException e) {
				IO.println("Incorrecto, introdúcela de nuevo");
			}
		}
		return secuencia;
	}
	
	static void borrarElementos(List<Integer> secuencia, int k) {
		
	}
	
}
