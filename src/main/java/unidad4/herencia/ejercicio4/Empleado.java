package unidad4.herencia.ejercicio4;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Empleado implements Remunerable {

	private String nombre;
	private String apellidos;
	private LocalDate fechaContratacion;
	private String numeroCuenta;
	
	public Empleado(String nombre, String apellidos, LocalDate fechaContratacion, String numeroCuenta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaContratacion = fechaContratacion;
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaContratacion, nombre, numeroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaContratacion, other.fechaContratacion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numeroCuenta, other.numeroCuenta);
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaContratacion=" + fechaContratacion
				+ ", numeroCuenta=" + numeroCuenta + "]";
	}
	
	@Override
	public void pagar(float importe, String numeroCuenta) {
		System.out.println("Pago realizado a " + nombre + "en concepto de salario por importe de " + importe);
	}
	
}
