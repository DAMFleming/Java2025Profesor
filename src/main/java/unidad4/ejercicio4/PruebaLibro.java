package unidad4.ejercicio4;

import java.util.List;

import unidad4.ejercicio3.Autor;

public class PruebaLibro {

	public static void main(String[] args) {
		Libro libro = new Libro("a", List.of(new Autor("b"), new Autor("c")), 10);
		System.out.println(libro);
	}
	
}
