package unidad6.colecciones1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Ejercicio6b {
	
	public static void main(String[] args) {
		int n, k, x;
		Queue<Integer> cola = new LinkedList<>();
		
		n = leerNumero("Cantidad de números: ");
		k = leerNumero("Cuántos se van a borrar: ");
		x = leerNumero("Número que se va a buscar: ");;
		
		for (int i=0; i<n; i++)
			cola.offer(leerNumero("Número: "));
		
		cola = cola.stream().skip(k).collect(Collectors.toCollection(LinkedList::new));
		int min = cola.stream().max(Integer::compare).orElse(0);
		
		if (cola.stream().anyMatch(e -> e == x))
			System.out.println(true);
		else
			System.out.println(min);
		
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
