package ejemplos.clases;

import java.awt.Color;
import java.util.Random;

public class Coche {

	public static int contador = 0;
	private Color color;
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		color = color;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public int getPuertas() {
		return puertas;
	}
	
	public void acelerar(double acelelación, double tiempo) {
		
	}

	private int puertas = 2;
	private String combustible;
	
	public Coche(int puertas) {
		this.puertas = puertas;
	}
	
	public Coche() {
		puertas = 4;
	}
	
	public static void main(String[] args) {
		Coche coche1 = new Coche(4);
		Coche coche2 = new Coche(6);
		Coche coche3 = new Coche();
		coche1.setColor(Color.RED);
	}
	
	
	
}

