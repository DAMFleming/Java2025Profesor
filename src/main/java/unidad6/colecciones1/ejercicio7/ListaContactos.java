package unidad6.colecciones1.ejercicio7;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
		Iterator<Contacto> i = contactos.iterator();
		while (i.hasNext()) {
			Contacto c = i.next();
			if (nombre.equalsIgnoreCase(c.getNombre())) {
				i.remove();
				return true;
			}
		}
		return false;
	}
	
	public String getContactos() {
//		StringBuilder s = new StringBuilder();
//		for (Contacto c: contactos) {
//			s.append(c.toString());
//			s.append("\n");
//		}
//		return s.toString();
		return contactos.stream().map(Contacto::toString).collect(Collectors.joining("/n"));
	}
	
	public boolean agregarTelefono(String nombre, String telefono) {
		Contacto c = buscar(nombre);
		if (c != null)
			return c.agregarTelefono(telefono);
		return false;
	}
	
	public boolean eliminarTelefono(String nombre, String telefono) {
		Contacto c = buscar(nombre);
		if (c != null)
			return c.eliminarTelefono(telefono);
		return false;
	}
	
}
