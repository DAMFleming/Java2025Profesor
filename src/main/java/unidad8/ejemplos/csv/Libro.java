package unidad8.ejemplos.csv;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Libro {

	private String titulo;
	private List<String> autores;
	private String editorial;
	private int año;
	private String categoria;
	
	public Libro(String titulo, List<String> autores, String editorial, int año, String categoria) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.año = año;
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public List<String> getAutores() {
		return Collections.unmodifiableList(autores);
	}
	public String getEditorial() {
		return editorial;
	}
	public int getAño() {
		return año;
	}
	public String getCategoria() {
		return categoria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(autores, año, categoria, editorial, titulo);
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
		return Objects.equals(autores, other.autores) && año == other.año && Objects.equals(categoria, other.categoria)
				&& Objects.equals(editorial, other.editorial) && Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autores=" + autores + ", editorial=" + editorial + ", año=" + año
				+ ", categoria=" + categoria + "]";
	}
	
}
