package unidad6.colecciones1.ejercicio7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreteComandos {
	
	public static Pattern p = Pattern.compile("(salir|contactos|(?:(.+):(.+)))");
	
	public static String ejecutarComando(String comando, ListaContactos contactos) {
		Matcher m = p.matcher(comando.trim());
		if (!m.matches())
			return "comando incorrecto";
		else {
			String s = m.group(1);
			switch (s) {
			case "salir":
				return null;
			case "contactos":
				return contactos.getContactos();
			default:
				String s1 = m.group(2);
				String s2 = m.group(3);
				switch (s1) {
				case "buscar":
					Contacto c = contactos.buscar(s2);
					return c == null ? "contacto no encontrado" : c.toString();
				case "eliminar":
					return contactos.eliminar(s2) ? "contacto eliminado" : "contacto no encontrado";
				default:
					return contactos.agregarContacto(s1, s2) ? "contacto agregado" : "el contacto ya existe";
					
				}
			}
		}
	}
	
}
