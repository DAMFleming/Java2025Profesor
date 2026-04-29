package ejemplos.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EscrituraFicherosTexto {
	public static void main(String[] args) throws IOException {
		Path p = Path.of(System.getProperty("user.home"), "Documents", "prueba.txt");
		Files.writeString(p, "Hola Mundo!");
		IO.println(Files.readString(p) + "\n");
		Files.writeString(p, "abc", StandardOpenOption.WRITE);
		IO.println(Files.readString(p) + "\n");
		Files.writeString(p, "123", StandardOpenOption.APPEND);
		IO.println(Files.readString(p) + "\n");
		Files.write(p, List.of("A", "B", "C"), StandardOpenOption.WRITE);
		IO.println(Files.readString(p) + "\n");
		Files.write(p, List.of("A", "B", "C"), StandardOpenOption.APPEND);
		IO.println(Files.readString(p) + "\n");
	}
	
	/*
	 * Inserta el texto dentro del fichero al comienzo
	 * de la línea especificada en el parámetro 'linea'.
	 * 
	 * Si el número de línea especificado es mayor que
	 * el número de líneas, el texto se inserta al final
	 * del fichero.
	 */
	static void insertar(Path fichero, String texto, int linea) {
		
	}
	
}
