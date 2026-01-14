package unidad4.herencia.ejercicio1;

import java.time.LocalDate;

public abstract class Publicación {

	private int código;
	private String título;
	private int año;
	
	public Publicación(int código, String título, int año) {
		this.código = código;
		this.título = título;
		this.año = año;
	}

	public Publicación(int código, String título) {
		this.código = código;
		this.título = título;
		año = LocalDate.now().getYear();
	}

	public int getCódigo() {
		return código;
	}

	public String getTítulo() {
		return título;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return String.format("[%d, %s, %d]", código, título, año);
	}
	
	
}
