package unidad6.colecciones1;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio06 {
	
	public static void main(String[] args) {
		int n, k, x;
		Queue<Integer> cola = new LinkedList<>();
		
		n = leerNumero("Cantidad de números: ");
		k = leerNumero("Cuántos se van a borrar: ");
		x = leerNumero("Número que se va a buscar: ");;
		
		for (int i=0; i<n; i++)
			cola.offer(leerNumero("Número: "));
		for (int i = 0; i < k; i++)
			cola.poll();
		
		int min = Integer.MAX_VALUE;
		int valor;
		boolean contieneX = false;
		for (int i = 0; i<cola.size(); i++) {
			cola.offer(valor = cola.poll());
			if (!contieneX && valor == x)
				contieneX = true;
			if (valor < min)
				min = valor;
		}
		if (contieneX)
			System.out.println(true);
		else if (!cola.isEmpty())
			System.out.println(min);
		else
			System.out.println(0);
	}
	
	static int leerNumero(String mensaje) {
		while (true) {
			try {
				return Integer.parseInt(IO.readln(mensaje));
			} catch (NumberFormatException e) {
				IO.println("Dato incorrecto, introdúcelo de nuevo");
			}
		}
	}

}
