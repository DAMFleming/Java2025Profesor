package unidad6.colecciones1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce una linea de texto: ");
		String linea = scanner.nextLine();

		String[] palabras = linea.split("\\P{L}+");
		Set<String> repite = new TreeSet<>();
		Set<String> norepite = new TreeSet<>();

		for (String palabra : palabras) {
			if (norepite.contains(palabra)) {
				norepite.remove(palabra);
				repite.add(palabra);

			} else if (!repite.contains(palabra)) {
				norepite.add(palabra);
			}

		}
		System.out.println("palabras que no se repiten " + norepite);
		System.out.println("palabras que se repiten  " + repite);
	}
}
