package unidad4.ejercicio7;

import java.util.Objects;

public class Automovil {

	private String modelo;
	private float capacidadDeposito;
	private float combustible;
	private float consumo;
	private float totalKm;
	
	public Automovil(String modelo, float capacidadDeposito, float combustible, float consumo) {
		this.modelo = modelo;
		this.capacidadDeposito = capacidadDeposito;
		this.combustible = combustible;
		this.consumo = consumo;
	}

	public Automovil(String modelo, float capacidadDeposito, float consumo) {
		this.modelo = modelo;
		this.capacidadDeposito = combustible = capacidadDeposito;
		this.consumo = consumo;
	}

	public String getModelo() {
		return modelo;
	}

	public float getCapacidadDeposito() {
		return capacidadDeposito;
	}

	public float getCombustible() {
		return combustible;
	}

	public float getConsumo() {
		return consumo;
	}

	public float getTotalKm() {
		return totalKm;
	}
	
	public void llenarDeposito() {
		combustible = capacidadDeposito;
	}
	
	public float llenarDeposito(float litros) {
		combustible += litros;
		if (combustible > capacidadDeposito) {
			float resto = combustible - capacidadDeposito;
			combustible = capacidadDeposito;
			return resto;
		}
		return 0;
	}
	
	public Float desplazar(float km) {
		float combustibleNecesario = km * consumo;
		if (combustibleNecesario > combustible)
			return null;
		combustible -= combustibleNecesario;
		totalKm += km;
		return combustibleNecesario;
	}

	@Override
	public String toString() {
		return modelo + ", totalKm=" + totalKm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacidadDeposito, combustible, consumo, modelo, totalKm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovil other = (Automovil) obj;
		return Float.floatToIntBits(capacidadDeposito) == Float.floatToIntBits(other.capacidadDeposito)
				&& Float.floatToIntBits(combustible) == Float.floatToIntBits(other.combustible)
				&& Float.floatToIntBits(consumo) == Float.floatToIntBits(other.consumo)
				&& Objects.equals(modelo, other.modelo)
				&& Float.floatToIntBits(totalKm) == Float.floatToIntBits(other.totalKm);
	}
	
}
