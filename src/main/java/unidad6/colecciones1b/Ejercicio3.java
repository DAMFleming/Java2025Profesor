package unidad6.colecciones1b;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio3 {

	public static void main(String[] args) {
		String [] palabras = IO.readln("texto: ").split("\\P{L}+");
		
		Set<String> noSeRepiten = new HashSet<>();
		Set<String> seRepiten = new HashSet<>();
//		for (String p: palabras) {
//			if (!noSeRepiten.contains(p)) {
//				if (!seRepiten.contains(p))
//					noSeRepiten.add(p);
//			} 
//			else {
//				seRepiten.add(p);
//				noSeRepiten.remove(p);
//			}
//		}
		
		for (String p: palabras) {
			if (seRepiten.add(p)) {
				if (noSeRepiten.contains(p))
					noSeRepiten.remove(p);
				else {
					seRepiten.remove(p);
					noSeRepiten.add(p);
				}
					
			} 
		}
		
		System.out.println("Se repiten: " + seRepiten);
		System.out.println("No se repiten: " + noSeRepiten);
	}

}
