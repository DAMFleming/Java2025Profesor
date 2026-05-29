package examenrec1ev2ev;

import java.util.Arrays;

public class Ejercicio1 {

	public static void main(String[] args) {
		int nCadenas;
		nCadenas = Integer.parseInt(IO.readln("Numero de cadenas: "));
		String[] cadenas = new String[nCadenas];
		for (int i = 0; i < nCadenas; i++) {
			cadenas[i] = IO.readln("Introduce la cadena número " + (i + 1) + " : ");
		}
		Arrays.sort(cadenas);
		float[] cifCadenas = new float[nCadenas];
		for (int i = 0; i < nCadenas; i++) {
			cifCadenas[i] = cifrar(cadenas[i]);
		}
		for (int i = 0; i < nCadenas; i++) {
			IO.println(cadenas[i] + " " + cifCadenas[i]);
		}
		
	}
	
	static float cifrar(String s) {
		float resultado = 0;
		int l = s.length();
		s = s.toUpperCase();
		for (int i = 0; i < l; i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				if ("AEIOUÁÉÍÓÚüÜ".indexOf(c) >= 0) {
//				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Á' || c == 'É'
//					 || c == 'Í' || c == 'Ó' || c == 'Ú' || c == 'ü' || c == 'Ü') {
					resultado += (c * l);
				}
				else {
					resultado += (c / l);
				}
			}
		}
		return resultado;
	}
}
