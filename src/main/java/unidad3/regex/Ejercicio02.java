package unidad3.regex;

import java.util.regex.Pattern;

public class Ejercicio02 {

	public static void main(String[] args) {
		Pattern e = Pattern.compile("\\d{2}-(\\d{2}|ene|feb|mar|abr|may|jun|jul|ago|sep|oct|nov|dic)-\\d{4}");
		String fecha = IO.readln("fecha: ");

		while (!fecha.equals("fin")) {
			if (e.matcher(fecha).matches()) {
				System.out.println("La fecha es correcta");
			} else {
				System.err.println("El formato de la fecha es incorrecta");
			}
			fecha = IO.readln("fecha: ");
		}
	}

}