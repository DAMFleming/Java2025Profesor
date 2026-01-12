package unidad4.ejercicio8;

import java.util.Objects;

public class Pokemon {

	private String nombre;
	private String elemento;
	private int salud;
	
	public Pokemon(String nombre, String elemento, int salud) {
		this.nombre = nombre;
		this.elemento = elemento;
		this.salud = salud;
	}

	public String getNombre() {
		return nombre;
	}

	public String getElemento() {
		return elemento;
	}

	public int getSalud() {
		return salud;
	}
	
	public int restarSalud() {
		salud -= 10;
		return salud;
	}

	@Override
	public String toString() {
		return nombre + " " + elemento + " " + salud;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elemento, nombre, salud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(elemento, other.elemento) && Objects.equals(nombre, other.nombre) && salud == other.salud;
	}
	
	
}
