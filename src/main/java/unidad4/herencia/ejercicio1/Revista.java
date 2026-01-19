package unidad4.herencia.ejercicio1;

public class Revista extends Publicación {

	private int número;
	private int mes;
	private int día;
	
	public Revista(int código, String título, int año, int número, int mes, int día) {
		super(código, título, año);
		this.número = número;
		this.mes = mes;
		this.día = día;
	}
	
	public Revista(int código, String título, int número, int mes, int día) {
		super(código, título);
		this.número = número;
		this.mes = mes;
		this.día = día;
	}

	public int getNúmero() {
		return número;
	}

	public int getMes() {
		return mes;
	}

	public int getDía() {
		return día;
	}

	@Override
	public String toString() {
		return String.format("REVISTA [%d %s %d %d %d %d]", getCódigo(), getTítulo(),
				número, día, mes, getAño());
	}
	
}
