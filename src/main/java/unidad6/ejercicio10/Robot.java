package unidad6.ejercicio10;

import java.util.Objects;

public class Robot {

	private String nombre;
	private int tiempoProceso;
	private String producto;
	private int crono;
	
	public Robot(String nombre, int tiempoProceso) {
		super();
		this.nombre = nombre;
		this.tiempoProceso = tiempoProceso;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTiempoProceso() {
		return tiempoProceso;
	}
	
	public String getProducto() {
		return producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tiempoProceso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Robot other = (Robot) obj;
		return Objects.equals(nombre, other.nombre) && tiempoProceso == other.tiempoProceso;
	}

	@Override
	public String toString() {
		return "Robot [" + nombre + ", " + tiempoProceso + "]";
	}
	
	public void recogerProducto(String producto) {
		this.producto = producto;
		crono = 0;
	}
	
	public void procesarDuranteUnSegundo() {
		crono++;
		if (crono == tiempoProceso)
			producto = null;
	}
	
	public boolean estaOcupado() {
		return producto != null;
	}
	
}
