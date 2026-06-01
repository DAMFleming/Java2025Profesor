package unidad4.ejercicio9;

public class Main {

	public static void main(String[] args) {
		Mascota m = crearMascota(0);
		for (int i=0; i<1000; i++) {
			m.comer();
			if (!m.estaViva()) 
				m = crearMascota(i);
			
		}
	}

	private static Mascota crearMascota(int n) {
		Mascota m = new Mascota("pepe" + n);
		IO.println(m.getNombre());
		return m;
	}
	
}
