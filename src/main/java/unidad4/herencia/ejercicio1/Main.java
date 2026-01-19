package unidad4.herencia.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		List<Publicación> p = new LinkedList<>();
//		p.add(new Revista(1, "Marca", 1, 1, 10));
//		p.add(new Libro(2, "El Quijote", "Miguel de Cervantes"));
//		p.forEach(publicación -> System.out.println(publicación));
		
		Publicación p = new Revista(1, "Marca", 1, 1, 10);
		System.out.println(p.toString());
		
	}

}
