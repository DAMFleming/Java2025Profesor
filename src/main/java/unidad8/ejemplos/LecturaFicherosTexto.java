package unidad8.ejemplos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LecturaFicherosTexto {
	public static void main(String[] args) {
		metodo1();
		IO.println("**************************************");
		metodo2();
		IO.println("**************************************");
		metodo3();
	}
	
	static void metodo1() {
		Path p = Path.of("ejemplo.txt");
		try {
			String texto = Files.readString(p, StandardCharsets.ISO_8859_1);
			IO.println(texto);
		} catch (IOException e) {
			IO.println("Error leyendo el fichero: "
					+ e.getLocalizedMessage());
		}
	}
	
	static void metodo2() {
		Path p = Path.of("ejemplo.txt");
		try {
			List<String> lineas = Files.readAllLines(p, StandardCharsets.ISO_8859_1);
			lineas.forEach(IO::println);
		} catch (IOException e) {
			IO.println("Error leyendo el fichero: "
					+ e.getLocalizedMessage());
		}
	}
	
	static void metodo3() {
		Path p = Path.of("ejemplo.txt");
		try {
			Files.lines(p, StandardCharsets.ISO_8859_1).forEach(IO::println);
		} catch (IOException e) {
			IO.println("Error leyendo el fichero: "
					+ e.getLocalizedMessage());
		}
	}

}
