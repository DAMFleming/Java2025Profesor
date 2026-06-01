package unidad4.ejercicio9;

import java.util.Random;

public class Mascota {
	
	private static Random r = new Random();
	
	private String nombre;
	private int energia = 20;
	private boolean enferma;
	private boolean viva = true;
	
	public Mascota(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEnergia() {
		return energia;
	}
	
	public boolean estaEnferma() {
		return enferma;
	}
	
	public boolean estaViva() {
		return viva;
	}
	
	public String comer() {
		if (!viva)
			throw new RuntimeException("no se puede interactuar con una mascota muerta");
		if (enferma) {
			if (energia > 50)
				energia++;
			else
				energia--;
		}
		else {
			energia += 5;
			if (energia > 50 )
				enferma = true;
			else {
				enferma = r.nextInt(10) < 3;
				if (enferma)
					energia = 10;
			}
		}
		return estadoDeAnimo();
	}
	
	public String dormir() {
		if (!viva)
			throw new RuntimeException("no se puede interactuar con una mascota muerta");
		if (enferma) {
			if (energia > 50)
				energia++;
			else
				energia--;
		}
		else {
			energia += 2;
			if (energia > 50)
				enferma = true;
		}
		return estadoDeAnimo();
	}
	
	public String actividaFisica() {
		if (!viva)
			throw new RuntimeException("no se puede interactuar con una mascota muerta");
		energia -= 3;
		if (enferma)
			energia--;
		return estadoDeAnimo();
	}
	
	private String estadoDeAnimo() {
		if (energia < 0 || energia > 55) {
			viva = false;
			return "he muerto";
		}
		else if (!enferma && (energia >= 8 || energia < 47))
			return "estoy alegre";
		else if (!enferma && (energia < 8 || energia >= 48))
			return "estoy apática";
		else
			return "no me encuentro bien";
	}

}
