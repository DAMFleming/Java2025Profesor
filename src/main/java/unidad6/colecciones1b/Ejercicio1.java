package unidad6.colecciones1b;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		Set<String> nombres = new LinkedHashSet<>();
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("> ");
			while (in.hasNext()) {
				String nombre = in.next();
				nombres.add(nombre);
				System.out.print("> ");
			}
			nombres.forEach(nombre -> System.out.println(nombre));
		}
	}

}
