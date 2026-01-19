package unidad4.herencia.ejercicio1;

public class Libro extends Publicación implements Prestable{

	String autor;
	boolean prestado;

	public Libro(int código, String título, int año, String autor) {
		super(código, título, año);
		this.autor = autor;
	}
	
	public Libro(int código, String título, String autor) {
		super(código, título);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}
	
	@Override
	public String toString() {
		return String.format("LIBRO [%d %s %s %d]", getCódigo(), getTítulo(), autor, getAño());
	}

	@Override
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	
	
}
