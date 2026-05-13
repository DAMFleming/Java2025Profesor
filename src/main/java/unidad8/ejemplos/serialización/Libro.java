package unidad8.ejemplos.serialización;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Libro implements Serializable {
	
	private static final long serialVersionUID = 2L;
	private String titulo;
	private List<String> autores;
	private String editorial;
	private int año;
	private String categoría;
	private float precio;
	private String isbn;
	public Libro(String titulo, List<String> autores, String editorial, int año, String categoría, float precio,
			String isbn) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.año = año;
		this.categoría = categoría;
		this.precio = precio;
		this.isbn = isbn;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTitulo() {
		return titulo;
	}
	public List<String> getAutores() {
		return autores;
	}
	public String getEditorial() {
		return editorial;
	}
	public int getAño() {
		return año;
	}
	public String getCategoría() {
		return categoría;
	}
	public float getPrecio() {
		return precio;
	}
	public String getIsbn() {
		return isbn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(autores, año, categoría, editorial, isbn, precio, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autores, other.autores) && año == other.año && Objects.equals(categoría, other.categoría)
				&& Objects.equals(editorial, other.editorial) && Objects.equals(isbn, other.isbn)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
				&& Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autores=" + autores + ", editorial=" + editorial + ", año=" + año
				+ ", categoría=" + categoría + ", precio=" + precio + ", isbn=" + isbn + "]";
	}
	
	
	
}
