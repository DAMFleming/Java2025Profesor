package unidad4.herencia.ejercicio4;

import java.time.LocalDate;

public class Main {
	
	public static void main(String[] args) {
		Empleado a = new Asalariado("Pepe", "Pérez", LocalDate.now(), "0000000001001");
		IO.println(a);
	}
	
}
