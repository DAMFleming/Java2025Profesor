package examenrec1ev2ev;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Automovil implements Comparable<Automovil> {

	public static enum TipoMotor {GASOLINA, DIESEL, HIBRIDO, ELECTRICO}
	
	private String marca;
	private String modelo;
	private String matricula;
	private int año;
	private TipoMotor motor;
	private int potencia;
	
	public Automovil(String marca, String modelo, String matricula, int año, TipoMotor motor, int potencia) throws Exception {
		if (año < 0 || año > LocalDate.now().getYear())
			throw new Exception("no se admiten años negativos o posteriores al año actual");
		if (potencia <= 0)
			throw new Exception("no se admiten potencias menores o iguales a cero");
		if (!matricula.matches("\\d{4}\\p{L}{3}"))
			throw new Exception("formato de matrícula incorrecto");
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.año = año;
		this.motor = motor;
		this.potencia = potencia;
	}

	public Automovil(String marca, String modelo, String matricula, int año, int potencia) throws Exception {
		this(marca, modelo, matricula, año, TipoMotor.GASOLINA, potencia);
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getAño() {
		return año;
	}

	public TipoMotor getMotor() {
		return motor;
	}

	public int getPotencia() {
		return potencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(año, marca, matricula, modelo, motor, potencia);
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
		return año == other.año && Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(modelo, other.modelo) && motor == other.motor && potencia == other.potencia;
	}

	@Override
	public String toString() {
		return "Automovil [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", año=" + año
				+ ", motor=" + motor + ", potencia=" + potencia + "]";
	}

	@Override
	public int compareTo(Automovil o) {
		int resultado = marca.compareTo(o.marca);
		if (resultado == 0) {
			resultado = modelo.compareTo(o.modelo);
			if (resultado == 0) {
				resultado = año - o.año;
				if (resultado == 0) {
					resultado = matricula.compareTo(o.matricula);
					if (resultado == 0) {
						resultado = motor.compareTo(o.motor);
						if (resultado == 0)
							resultado = potencia - o.potencia;
					}
				}
			}
		}
		return resultado;
	}
	
	
	public static void main(String[] args) throws Exception {
		Set<Automovil> automoviles = new TreeSet<>(Set.of(
			new Automovil("Seat", "Ibiza", "0003ABC", 2015, 120),
			new Automovil("Seat", "Ibiza", "0000ABC", 2015, 120),
			new Automovil("Opel", "Corsa", "0001ABC", 2020, 100)
		));
		automoviles.forEach(IO::println);
	}
	
	
}
