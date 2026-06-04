package unidad4.herencia.ejercicio4;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SociedadAnonima extends Empresa {
	
	private final Set<String> trabajos = new HashSet<>();

	public SociedadAnonima(String nombre, Collection<String> trabajos) {
		super(nombre);
		this.trabajos.addAll(trabajos);
	}
	
	public SociedadAnonima(String nombre, String ... trabajos) {
		super(nombre);
		for (String trabajo: trabajos)
			this.trabajos.add(trabajo);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(trabajos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SociedadAnonima other = (SociedadAnonima) obj;
		return Objects.equals(trabajos, other.trabajos);
	}

	public boolean agregarTrabajo(String trabajo) {
		return trabajos.add(trabajo);
	}
	
	public boolean eliminarTrabajo(String trabajo) {
		return trabajos.remove(trabajo);
	}

	public Set<String> getTrabajos() {
		return Collections.unmodifiableSet(trabajos);
	}

	@Override
	public String toString() {
		return "SociedadAnonima [trabajos=" + trabajos + "]";
	}	

}
