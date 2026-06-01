package unidad4.ejercicio9;

import java.util.Objects;
import java.util.Random;

public class Mascota implements Comparable<Mascota> {
	
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
	
	public String actividadFisica() {
		if (!viva)
			throw new RuntimeException("no se puede interactuar con una mascota muerta");
		energia -= 3;
		if (enferma)
			energia--;
		else if (energia < 5)
			enferma = true;
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

	

	@Override
	public int hashCode() {
		return Objects.hash(energia, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return energia == other.energia && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Mascota o) {
		int resultado = nombre.compareTo(o.nombre);
		if (resultado == 0)
			resultado =  energia - o.energia;
		return resultado;
	}

	
	

}
