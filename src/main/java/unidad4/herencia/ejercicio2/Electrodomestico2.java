package unidad4.herencia.ejercicio2;

import java.util.Objects;

public abstract class Electrodomestico2 {

	private float precio;
	private Color color = Color.BLANCO;
	private char consumo = 'F';
	private float peso;
	private float precioFinal;
	
	public Electrodomestico2(float precio, float peso) {
		this.peso = peso;
		setPrecio(precio);
	}

	public Electrodomestico2(float precio, Color color, char consumo, float peso) {
		this.color = color;
		this.consumo = consumo;
		this.peso = peso;
		setPrecio(precio);
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
		precioFinal = precio * (
				consumo == 'A' ? 1.3f :
			    consumo == 'B' ? 1.25f :
			    consumo == 'C' ? 1.2f :
			    consumo == 'D' ? 1.15f :
			    consumo == 'E' ? 1.1f : 1.05f);
		precioFinal *= (
				peso <= 19 ? 1.05f :
				peso > 19 && peso <= 49 ? 1.1f :
				peso > 49 && peso <= 79 ? 1.15f : 1.20f
				);
	}
	
	public float getPrecioFinal() {
		return precioFinal;
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
		Electrodomestico2 other = (Electrodomestico2) obj;
		return color == other.color && consumo == other.consumo
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}
	
	
	
}
