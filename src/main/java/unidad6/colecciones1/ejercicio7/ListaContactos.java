package unidad6.colecciones1.ejercicio7;

import java.util.Set;
import java.util.TreeSet;

public class ListaContactos {

	private Set<Contacto> contactos = new TreeSet<>();
	
	public boolean agregarContacto(String nombre, String ...telefonos) {
		Contacto c = new Contacto (nombre, telefonos);		
		return contactos.add(c);
	}
	
	public Contacto buscar(String nombre) {
		for (Contacto c: contactos) {
			if (c.getNombre().equalsIgnoreCase(nombre))
				return c;
		}
		return null;
	}
	
	public boolean eliminar(String nombre) {
		
	}
	
	public Set<Contacto> getContactos() {
		
	}
	
	public boolean agregarTelefono(String nombre, String telefono) {
		
	}
	
	public boolean eliminarTelefono(String nombre, String telefono) {
		
	}
	
}
