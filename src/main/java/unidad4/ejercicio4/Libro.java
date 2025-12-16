package unidad4.ejercicio4;

import java.util.Collections;
import java.util.List;

import unidad4.ejercicio3.Autor;

public class Libro {

	private String titulo;
	private List<Autor> autores;
	private float precio;
	private int stock;
	
	public Libro(String titulo, List<Autor> autores, float precio, int stock) {
		this.titulo = titulo;
		this.autores = autores;
		this.precio = precio;
		this.stock = stock;
	}

	public Libro(String titulo, List<Autor> autores, float precio) {
		this.titulo = titulo;
		this.autores = autores;
		this.precio = precio;
		stock = 1;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<Autor> getAutores() {
		return Collections.unmodifiableList(autores);
	}
	
	public static void main(String[] args) {
		Libro libro = new Libro("a", List.of(new Autor("b"), new Autor("c")), 10);
	}
	
}
