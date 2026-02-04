package ejemplos.mapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Map<Integer, String> mapa = new TreeMap<>();
		mapa.put(1111111, "Elena Fernández");
		mapa.put(11222333, "Carlos González");
		mapa.put(11444555, "Rodrigo Rodríguez");
		mapa.put(11321123, "Elena Fernández");
		mapa.put(11777999, "Pilar Ramos");
		System.out.println(mapa);
		
		System.out.println(mapa.get(11444555));
		
		Collection<String> nombres = mapa.values();
		System.out.println(nombres);
		
		Collection<Entry<Integer, String>> entradas = mapa.entrySet();
		for (Entry<Integer, String> entrada: entradas) {
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue());
		}
		
		Map<String, List<String>> alumnos = new TreeMap<>();
	}

}
