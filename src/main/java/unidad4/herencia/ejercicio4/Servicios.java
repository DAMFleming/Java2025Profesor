package unidad4.herencia.ejercicio4;

import java.util.Objects;

public class Servicios extends Empresa implements Remunerable {

	private String tipo;
	private String numeroCuenta;
	
	public Servicios(String nombre, String tipo, String numeroCuenta) {
		super(nombre);
		this.tipo = tipo;
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroCuenta, tipo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicios other = (Servicios) obj;
		return Objects.equals(numeroCuenta, other.numeroCuenta) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Servicios [tipo=" + tipo + ", numeroCuenta=" + numeroCuenta + "]";
	}
	
	@Override
	public void pagar(float importe, String numeroCuenta) {
		System.out.println("Pago realizado a " + getNombre() + "en concepto de salario por importe de " + importe);
	}

}
