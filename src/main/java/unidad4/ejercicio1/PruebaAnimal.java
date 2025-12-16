package unidad4.ejercicio1;

import java.time.LocalDate;

public class PruebaAnimal {

	public static void main(String[] args) {
		Animal animal1 = new Animal("Pepe", LocalDate.of(2000, 5, 20));
		Animal animal2 = new Animal("Pepín");
		System.out.println(animal1.getNombre());
		System.out.println(animal2.getFecha());
		System.out.println(animal1);
		System.out.println(animal2);
	}
	
}
