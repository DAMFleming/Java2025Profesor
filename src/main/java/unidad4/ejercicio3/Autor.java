package unidad4.ejercicio3;

public class Autor {

	private String nombre;
	private String email;
	private Integer año;

	public Autor(String nombre) {
		this.nombre = nombre;
	}

	public Autor(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Autor(String nombre, String email, Integer año) {
		this.nombre = nombre;
		this.email = email;
		this.año = año;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getAño() {
		return año;
	}

	@Override
	public String toString() {
		if (año != null && email != null)
			return nombre + " (" + año + ") " + email;
		if (email != null && año == null)
			return nombre + " " + email;
		if (email == null && año != null)
			return nombre + " (" + año + ") ";

		return nombre;
	}

//	@Override
//	public String toString() {
//		StringBuilder nombre= new StringBuilder(this.nombre);
//		if(año!=null)
//			nombre.append(String.format(" (%d)", año));
//		if(email!=null)
//			nombre.append(String.format(" %s", email));
//		return nombre.toString();
//	}

//	@Override
//	public String toString() {
//		String nombre= this.nombre;
//		if(año!=null)
//			nombre += String.format(" (%d)", año);
//		if(email!=null)
//			nombre += String.format(" %s", email);
//		return nombre;
//	}

//	@Override
//	public String toString() {
//		return 	nombre +
//				(año != null ? String.format(" (%d)", año) : "") +
//				(email != null ? String.format(" %s", email) : "");
//	}

	public static void main(String[] args) {
		Autor pepe = new Autor("Pepe");
		System.out.println(pepe);
	}

}
