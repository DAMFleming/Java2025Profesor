package unidad4.ejercicio5;

import java.util.Objects;

public class Naipe {

	private Palo palo;
	private String rango;
	private int valor;
	
	public Naipe(Palo palo, String rango, int valor) {
		this.palo = palo;
		this.rango = rango;
		this.valor = valor;
	}

	public Palo getPalo() {
		return palo;
	}

	public String getRango() {
		return rango;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(palo, rango, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Naipe other = (Naipe) obj;
		return palo == other.palo && Objects.equals(rango, other.rango) && valor == other.valor;
	}

	@Override
	public String toString() {
		return rango + palo.getSimbolo();
	}
	
	
}
