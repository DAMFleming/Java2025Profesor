package unidad8.ejemplos.serialización;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Libro libro = new Libro("Design Patterns",
//				List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides", "Andrew S. Tanenbaum",
//						"David J. Wetherall"),
//				"Addison-Wesley", 2021, "Software Engineering", 82.22f, "978-3-6359377-18-2");
//		try (ObjectOutputStream out = new ObjectOutputStream(
//				new BufferedOutputStream(new FileOutputStream("libros.bin")))) {
//			out.writeObject(libro);
//		}
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("libros.bin")))) {
			Libro libroRecuperado = (Libro) in.readObject();
			System.out.println(libroRecuperado);
//			System.out.println(libro.equals(libroRecuperado));
		}
	}
}
