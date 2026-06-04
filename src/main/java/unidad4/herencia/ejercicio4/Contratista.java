package unidad4.herencia.ejercicio4;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contratista extends Empleado {
	
	private final Set<SociedadAnonima> empresas = new HashSet<>();

	public Contratista(String nombre, String apellidos, LocalDate fechaContratacion, String numeroCuenta,
			Collection<SociedadAnonima> empresas) {
		super(nombre, apellidos, fechaContratacion, numeroCuenta);
		this.empresas.addAll(empresas);
	}
	
	public Contratista(String nombre, String apellidos, LocalDate fechaContratacion, String numeroCuenta,
			SociedadAnonima ... empresas) {
		super(nombre, apellidos, fechaContratacion, numeroCuenta);
		for (SociedadAnonima sa: empresas)
			this.empresas.add(sa);
	}
	
	public boolean añadirSociedaAnonima(SociedadAnonima sa) {
		return empresas.add(sa);
	}
	
	public boolean eliminarSociedadAnonima(SociedadAnonima sa) {
		return empresas.remove(sa);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(empresas);
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
		Contratista other = (Contratista) obj;
		return Objects.equals(empresas, other.empresas);
	}

	@Override
	public String toString() {
		return "Contratista [empresas=" + empresas + "]";
	}
	
	
}
