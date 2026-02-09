package unidad6.colecciones1.Ejercicio4;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palabras {

	private static Pattern p = Pattern.compile("\\p{L}+");
	private Map<Integer, Set<String>> palabras;
	
	public Palabras() {
		palabras =  new TreeMap<>();
	}
	
	public Palabras(String s) {
		this();
		agregarPalabras(s);
	}
	
	public void agregarPalabras(String s) {
		Matcher m = p.matcher(s);
		while (m.find())
			agregarPalabra(m.group());
	}
	
	public void agregarPalabra(String s) {
		int longitud = s.length();
		Set<String> c = palabras.get(longitud);
		if (c == null) {
			c = new TreeSet<>();
			palabras.put(longitud, c);
		}
		c.add(s);
	}
	
	public boolean contiene(String s) {
		int longitud = s.length();
		Set<String> c = palabras.get(longitud);
		if (c != null)
			return c.contains(s);
		return false;
	}
	
	public Set<String> palabrasDeLongitud(int l) {
		Set<String> c = palabras.get(l);
		return c == null ? c : Collections.unmodifiableSet(c);
	}
	
}
