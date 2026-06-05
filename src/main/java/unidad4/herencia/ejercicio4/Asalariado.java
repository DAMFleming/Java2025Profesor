package unidad4.herencia.ejercicio4;

import java.time.LocalDate;

public class Asalariado extends Empleado {

	public Asalariado(String nombre, String apellidos, LocalDate fechaContratacion, String numeroCuenta) {
		super(nombre, apellidos, fechaContratacion, numeroCuenta);
	}

	
	@Override
	public String toString() {
		return "Asalariado [" + super.toString() + "]";
	}

	
}
