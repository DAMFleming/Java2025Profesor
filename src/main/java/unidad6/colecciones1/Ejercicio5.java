package unidad6.colecciones1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {

	public static void main(String[] args) {
		int s;
		while (true) {
			try {
				s = Integer.parseInt(IO.readln("Número de secuencias: "));
				break;
			} catch (NumberFormatException e) {
				IO.println("Dato incorrecto, introdúcelo de nuevo");
			}
		}
		for (int i=1; i<=s; i++)
			procesarSecuencia(i);
	}
	
	static void procesarSecuencia(int i) {
		int n, k;
		
		IO.println(String.format("Leyendo datos de la secuencia %d", i));
		while (true) {
			try {
				String [] valores = IO.readln("Introduce longitud y cantidad de números a borrar: ").split(" ");
				if (valores.length != 2)
					throw new RuntimeException();
				n = Integer.parseInt(valores[0]);
				k = Integer.parseInt(valores[1]);
				if (k > n)
					throw new IllegalArgumentException();
				break;
			} catch (NumberFormatException e) {
				IO.println("Datos incorrectos, introdúcelos de nuevo");
			} catch (IllegalArgumentException e) {
				IO.println("K no debe de ser mayor que N, introdúcelos de nuevo");
			} catch (RuntimeException e) {
				IO.println("Cantidad incorrecta de valores, introdúcelos de nuevo");
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
					throw new RuntimeException();
				for (int i=0; i<valores.length; i++)
					secuencia.add(Integer.parseInt(valores[i]));
				break;
			} catch (NumberFormatException e) {
				IO.println("Datos incorrectos, introdúcela de nuevo");
			} catch (RuntimeException e) {
				IO.println("Cantidad incorrecta de valores, introdúcela de nuevo");
			}
		}
		return secuencia;
	}
	
	static void borrarElementos(List<Integer> secuencia, int k) {
		
	}
	
}
