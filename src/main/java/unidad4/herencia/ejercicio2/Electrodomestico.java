package unidad4.herencia.ejercicio2;

import java.util.Objects;

public abstract class Electrodomestico {

	private float precio;
	private Color color = Color.BLANCO;
	private char consumo = 'F';
	private float peso;
	
	public Electrodomestico(float precio, float peso) {
		if (precio < 0)
			throw new IllegalArgumentException("no se admiten precios negativos");
		else if (peso < 0)
			throw new IllegalArgumentException("no se admiten pesos negativos");
		this.precio = precio;
		this.peso = peso;
	}

	public Electrodomestico(float precio, Color color, char consumo, float peso) {
		if (consumo < 'A' || consumo > 'F')
			throw new IllegalArgumentException("consumo incorrecto");
		this(precio, peso);
		this.color = color;
		this.consumo = consumo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float getPrecioFinal() {
		float precio = this.precio * (
				consumo == 'A' ? 1.3f :
			    consumo == 'B' ? 1.25f :
			    consumo == 'C' ? 1.2f :
			    consumo == 'D' ? 1.15f :
			    consumo == 'E' ? 1.1f : 1.05f);
		return precio * (
				peso <= 19 ? 1.05f :
				peso > 19 && peso <= 49 ? 1.1f :
				peso > 49 && peso <= 79 ? 1.15f : 1.20f
				);
	}

	public Color getColor() {
		return color;
	}

	public char getConsumo() {
		return consumo;
	}

	public float getPeso() {
		return peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, consumo, peso, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Electrodomestico other = (Electrodomestico) obj;
		return color == other.color && consumo == other.consumo
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}

	@Override
	public String toString() {
		return "precio=" + precio + ", color=" + color + ", consumo=" + consumo + ", peso=" + peso;
	}
	
}
