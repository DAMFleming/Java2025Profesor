package unidad6.colecciones1.ejercicio7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contacto implements Comparable<Contacto> {

	private String nombre;
	private Set<String> telefonos = new HashSet<String>();
	
	public Contacto(String nombre, String ... telefonos) {
		this.nombre = nombre;
		for (String telefono: telefonos)
			this.telefonos.add(telefono);
	}

	public String getNombre() {
		return nombre;
	}
	
	public Set<String> getTelefonos() {
		return Collections.unmodifiableSet(telefonos);
	}
	
	public boolean agregarTelefono(String telefono) {
		return telefonos.add(telefono);
	}
	
	public boolean eliminarTelefono(String telefono) {
		return telefonos.remove(telefono);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Contacto o) {
		return nombre.compareTo(o.nombre);
	}
	
	
}
