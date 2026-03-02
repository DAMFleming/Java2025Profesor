package unidad6.colecciones2b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	
//	public static boolean algunaSeRepiteAlMenos3Veces(List<String> lista) {
//		Map<String, Integer> mapa = new HashMap<>();
//		for (String s: lista) {
//			Integer contador = mapa.putIfAbsent(s, 1);
//			if (contador != null)
//				mapa.put(s, contador + 1);
//		}
//		System.out.println(mapa);
//		for (int n: mapa.values())
//			if (n >= 3)
//				return true;
//		return false;
//	}
	
	public static boolean algunaSeRepiteAlMenos3Veces(List<String> lista) {
		return lista.stream()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.values()
				.stream()
				.anyMatch(n -> n >= 3);
	}
	
	public static int valorMenosRepetido(Map<String, Integer> mapa) {
		
	}
	
	public static void main(String[] args) {
//		Set<String> c = new HashSet<>(Set.of("a", "aa", "aaa", "aaaa", "aaaaa"));
//		eliminarLasDeLongitudPar(c);
//		System.out.println(c);
//		Map<String, String> m = Map.of("1", "a", "2", "b", "3", "a");
//		System.out.println(valoresUnicos(m));
		System.out.println(algunaSeRepiteAlMenos3Veces(List.of("a", "b", "c", "a", "d", "b", "a")));
	}
	
}
