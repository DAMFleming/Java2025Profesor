package unidad8.ejemplos.csv.nolib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import unidad8.ejemplos.csv.Libro;

public class Lectura2 {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(
				new FileReader("src\\main\\resources\\csv\\libros1.csv"))
		) {
			String linea;
			List<Libro> libros = new ArrayList<>();
			while ((linea = in.readLine()) != null) {
				String [] valores = linea.split(",");
				libros.add(new Libro(
						valores[0],
						Arrays.asList(valores[1].split(",\\s*")),
						valores[2],
						Integer.parseInt(valores[3]),
						valores[4]));
			}
			libros.forEach(IO::println);
		}
	}

}
