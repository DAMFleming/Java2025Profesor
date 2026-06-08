package unidad6.ejemplos;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IterarEnMapas {

	public static void main(String[] args) {
		Map<Integer, String> m = Map.of(5, "w", 11, "f", 9, "h", 3, "y");
		
		Set<Integer> claves = m.keySet();
		for(Integer i: claves)
			System.out.println(m.get(i));
		
		Collection<String> valores = m.values();
		for(String valor: valores)
			System.out.println(valor);
		
		Set<Entry<Integer, String>> entries = m.entrySet();
		for (Entry<Integer, String> e: entries)
			System.out.println(e.getKey() + ":" + e.getValue());
	}
	
}
