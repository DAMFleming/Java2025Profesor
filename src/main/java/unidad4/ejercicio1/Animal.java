package unidad4.ejercicio1;

import java.time.LocalDate;

public class Animal {

	private String nombre;
	private LocalDate fecha;
	
	public Animal(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public Animal(String nombre) {
		this.nombre = nombre;
		fecha = LocalDate.now();
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " - Edad: " + fecha.until(LocalDate.now()).getYears();
	}
	
}
