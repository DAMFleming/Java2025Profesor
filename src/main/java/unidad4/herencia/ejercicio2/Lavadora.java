package unidad4.herencia.ejercicio2;

import java.util.Objects;

public class Lavadora extends Electrodomestico {

	private int carga;

	public Lavadora(float precio, Color color, char consumo, float peso, int carga) {
		super(precio, color, consumo, peso);
		this.carga = carga;
	}

	public Lavadora(float precio, float peso) {
		super(precio, peso);
		carga = 5;
	}
	
//	@Override
//	public float getPrecioFinal() {
//		float precioFinal =  super.getPrecioFinal();
//		if (carga > 8)
//			precioFinal *= 1.1;
//		return precioFinal;
//	}
	
//	@Override
//	public float getPrecioFinal() {
//		if (carga > 8)
//			return super.getPrecioFinal() * 1.1f;
//		return super.getPrecioFinal();
//	}
	
	@Override
	public float getPrecioFinal() {
		return super.getPrecioFinal() * (carga > 8 ? 1.1f : 1f);
	}

	public int getCarga() {
		return carga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(carga);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lavadora other = (Lavadora) obj;
		return carga == other.carga;
	}
	
	@Override
	public String toString() {
		return "LAVADORA "+ " " + super.toString() + ", carga=" + carga;
	}
	
}
