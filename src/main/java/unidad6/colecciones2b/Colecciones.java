package unidad6.colecciones2b;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Colecciones {

	public static void eliminarLasDeLongitudPar(Set<String> c) {
		Iterator<String> i = c.iterator();
		while(i.hasNext())
			if (i.next().length() % 2 == 0)
				i.remove();
	}
	
	public static boolean contieneImpares(Set<Integer> c) {
//		for (Integer n: c)
//			if (n % 2 == 1)
//				return true;
//		return false;
		return c.stream().anyMatch(n -> n % 2 == 1);
	}
	
	public static boolean valoresUnicos(Map<String, String> m) {
//		return m.values().size() == new HashSet<String>(m.values()).size();
		return m.values().stream().distinct().count() == m.values().size();
	}
	
//	public static boolean algunaSeRepiteAlMenos3Veces(List<String> lista) {
//		Map<String, Integer> mapa = new HashMap<>();
//		for (String s: lista) {
//			if (mapa.containsKey(s)) {
//				int contador = mapa.get(s);
//				contador++;
//				mapa.put(s, contador);
//			}
//			else
//				mapa.put(s, 1);
//		}
//		for (int n: mapa.values())
//			if (n >= 3)
//				return true;
//		return false;
//	}
	
	public static boolean algunaSeRepiteAlMenos3Veces(List<String> lista) {
		Map<String, Integer> mapa = new HashMap<>();
		for (String s: lista) {
			Integer contador = mapa.putIfAbsent(s, 1);
			if (contador != null)
				if (contador == 2)
					return true;
				mapa.put(s, contador + 1);
		}
		return false;
	}
	
//	public static boolean algunaSeRepiteAlMenos3Veces(List<String> lista) {
//		return lista.stream()
//				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
//				.values()
//				.stream()
//				.anyMatch(n -> n >= 3);
//	}
	
//	public static int valorMenosRepetido(Map<String, Integer> mapa) {
//		Map<Integer, Integer> aux = new HashMap<>();
//		for (int edad: mapa.values()) {
//			Integer contador = aux.putIfAbsent(edad, 1);
//			if (contador != null)
//				aux.put(edad, contador + 1);
//		}
//		int minEdad = Integer.MAX_VALUE;
//		int minRep = Integer.MAX_VALUE;
//		for (Entry<Integer, Integer> datos: aux.entrySet()) {
//			if (datos.getValue() < minRep) {
//				minEdad = datos.getKey();
//				minRep = datos.getValue();
//			}
//			else if (datos.getValue() == minRep && datos.getKey() < minEdad)
//				minEdad = datos.getKey();
//		}
//		return minEdad;
//	}
	
	public static int valorMenosRepetido(Map<String, Integer> mapa) {
		EntryComparator c = new EntryComparator();
		return mapa.entrySet().stream()
				.collect(Collectors.groupingBy(k -> k.getValue(), Collectors.counting()))
				.entrySet().stream()
						.min(c)
						.get()
						.getKey();
	}
	
	static class EntryComparator implements Comparator<Entry<Integer, Long>> {
		@Override
		public int compare(Entry<Integer, Long> o1, Entry<Integer, Long
				> o2) {
			int resultado = Long.compare(o1.getValue(), o2.getValue());
			if (resultado == 0)
				return Integer.compare(o1.getKey(), o2.getKey());
			return resultado;
		}
	}
	
	static Map<String, Integer> cuentaPares(List<String> lista) {
		Map<String, Integer> mapa = new TreeMap<>();
		for (String s: lista) {
			for (int i=0; i<s.length()-1; i++) {
				String par = s.substring(i, i + 2);
				Integer contador = mapa.putIfAbsent(par, 1);
				if (contador != null)
					mapa.put(par, contador + 1);
			}
		}
		return mapa;
	}
	
	public static void main(String[] args) {
//		Set<String> c = new HashSet<>(Set.of("a", "aa", "aaa", "aaaa", "aaaaa"));
//		eliminarLasDeLongitudPar(c);
//		System.out.println(c);
//		Map<String, String> m = Map.of("1", "a", "2", "b", "3", "a");
//		System.out.println(valoresUnicos(m));
//		System.out.println(algunaSeRepiteAlMenos3Veces(List.of("a", "b", "c", "a", "d", "b", "a")));
//		System.out.println(valorMenosRepetido(Map.of("Juan", 33, "Hugo", 29, "Ana", 45, "Luis", 47,
//				"Mario", 33, "Rosa", 29, "Carmen", 33, "Elena", 59, "Benito", 33)));
		System.out.println(cuentaPares(List.of("banana", "pera", "melón", "o", "sandía")));
	}
	
}
