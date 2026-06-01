package unidad4.ejercicio9;

import java.util.LinkedList;
import java.util.List;

public class Main {

	private static List<Mascota> mascotas = new LinkedList<>();
	
	public static void main(String[] args) {
		String comando;
		while (!(comando = IO.readln("> ").trim()).equalsIgnoreCase("salir")) {
			String[] v = comando.split("\\s+");
			switch (v[0]) {
			case "crear":
				crear(v[1]);
				break;
			case "comer":
				comer(v[1]);
				break;
			case "entrenar":
				entrenar(v[1]);
				break;
			case "dormir":
				dormir(v[1]);
				break;
			case "curar":
				
				break;
			default:
				IO.println("comando incorrecto");
			}
		}
	}
	
	private static boolean existeMascotaConNombre(String nombre) {
		for(Mascota m: mascotas)
			if (m.getNombre().equals(nombre))
				return true;
		return false;
	}
	
	private static Mascota buscar(String nombre) {
		for(Mascota m: mascotas)
			if (m.getNombre().equals(nombre))
				return m;
		return null;
	}
	
	private static void crear(String nombre) {
		if (existeMascotaConNombre(nombre))
			IO.println("ya existe una mascota con ese nombre");
		else
			mascotas.add(new Mascota(nombre));
	}
	
	private static void comer(String nombre) {
		Mascota m = buscar(nombre);
		if (m == null)
			IO.println("no existe una mascota con ese nombre");
		else
			IO.println(m.comer());
	}
	
	private static void entrenar(String nombre) {
		Mascota m = buscar(nombre);
		if (m == null)
			IO.println("no existe una mascota con ese nombre");
		else
			IO.println(m.actividaFisica());
	}
	
	private static void dormir(String nombre) {
		Mascota m = buscar(nombre);
		if (m == null)
			IO.println("no existe una mascota con ese nombre");
		else
			IO.println(m.dormir());
	}
}
