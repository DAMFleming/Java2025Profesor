package unidad6.colecciones2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Colecciones {
	
	public static void eliminarLasDeLongitudPar(Set<String> s) {
		Iterator<String> iterador = s.iterator();
		while(iterador.hasNext()) {
			if(iterador.next().length() % 2 == 0)
				iterador.remove();
		}
	}
	
	public static boolean contieneImpares(Set<Integer> s) {
		for (int n: s)
			if (n % 2 != 0)
				return true;
		return false;
		
//		return s.stream().anyMatch(n -> n % 2 != 0);
	}
	
	public static boolean valoresUnicos(Map<String, String> m) {
//		return new HashSet<>(m.values()).size() == m.values().size();
		return m.values().stream().distinct().count() == m.values().size();
	}
	
	public static boolean algunaSeRepiteAlMenos3Veces(List<String> l) {
		Map<String, Integer> m = new HashMap<>();
		for (String s: l) {
			if(!(m.putIfAbsent(s, 1) == null)) {
				m.replace(s, m.get(s)+1);
			}
		}
		Iterator<Integer> iterador = m.values().iterator();
		while(iterador.hasNext()) {
			if (iterador.next() >= 3) {
				return true;
			}
		}
		return false;
	}
	
	public static void negativosAbajoPositivosArriba(Deque<Integer> pila) {
		Queue<Integer> cola = new ArrayDeque<>();
		while (!pila.isEmpty())
			cola.offer(pila.pop());
		for (int i=0; i<cola.size(); i++)
			if (cola.peek() < 0)
				pila.push(cola.poll());
			else
				cola.offer(cola.poll());
		while (!cola.isEmpty())
			pila.push(cola.poll());
	}
	
	public static Integer moda(List<Integer> lista) {
		Entry<Integer, Integer> e = lista.stream()
				.collect(Collectors.toMap(n -> n, n -> 1, (v1, v2) -> v1 + v2))
				.entrySet()
				.stream()
				.max(Comparator.comparing(Entry::getValue, Integer::compare))
				.orElse(null);
		return e == null ? null : e.getKey();
	}
	
	public static Map<String, Integer> interseccion(Map<String, Integer> m1, Map<String, Integer> m2) {
		Set<Entry<String, Integer>> c1 = m1.entrySet();
		Set<Entry<String, Integer>> c2 = m2.entrySet();
		TreeMap<String, Integer> m3 = new TreeMap<>();
		c1.retainAll(c2);
		for (Entry<String, Integer> e: c1) {
			m3.put(e.getKey(), e.getValue());
		}
		return m3;
	}
	
//	public static Integer valorMenosRepetido(Map<String, Integer> m) {
//		Map<Integer, Integer> aux = new TreeMap<>();
//		for (int edad: m.values()) {
//			if (!aux.containsKey(edad))
//				aux.put(edad, 1);
//			else {
//				int n = aux.get(edad);
//				aux.put(edad, n + 1);
//			}
//		}
//		Entry<Integer, Integer> min;
//		Iterator<Entry<Integer, Integer>> i = aux.entrySet().iterator();
//		if (i.hasNext()) {
//			min = i.next();
//			while (i.hasNext()) {
//				Entry<Integer, Integer> e = i.next();
//				if (min.getValue() > e.getValue() || (min.getValue() == e.getValue() && min.getKey() > e.getKey()))
//					min = e;
//			}
//			return min.getKey();
//		}
//		return null;
//	}
	
	public static Integer valorMenosRepetido(Map<String, Integer> m) {
		Map<Integer, Integer> aux = new TreeMap<>();
		for (int edad: m.values()) {
			if (!aux.containsKey(edad))
				aux.put(edad, 1);
			else {
				int n = aux.get(edad);
				aux.put(edad, n + 1);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int rep: aux.values())
			if (min > rep)
				min = rep;
		for (Entry<Integer, Integer> e: aux.entrySet())
			if (e.getValue() == min)
				return e.getKey();
		return null;
	}

	public static void main(String[] args) {
//		Set<String> c1 = new HashSet<>(Set.of("a", "aa", "aaa", "aaaa", "aaaaa"));
//		IO.println(c1);
//		eliminarLasDeLongitudPar(c1);
//		IO.println(c1);
//		
//		// ----------------------------------------------------------------------------------
//		
//		Set<Integer> c2 = Set.of(20, 32, 25, 11, 48, 2, 1);
//		System.out.println(contieneImpares(c2));
//		c2 = Set.of(2, 4, 6, 8);
//		System.out.println(contieneImpares(c2));
//		
//		// ----------------------------------------------------------------------------------
//		
//		Map<String, String> m1 = Map.of("c1", "aa", "c2", "bb", "c3", "cc");
//		System.out.println(valoresUnicos(m1));
//		m1 = Map.of("c1", "aa", "c2", "bb", "c3", "aa");
//		System.out.println(valoresUnicos(m1));
//		
//		// ----------------------------------------------------------------------------------
//		
//		List<Integer> l1 = new ArrayList<>(List.of(2, 7, 1, 7, 3, 9, 1, 5, 4, 1, 3, 2, 1, 7, 3, 7, 9, 7)); 
//		System.out.println(moda(l1));
		
		Map<String, Integer> m = Map.of("Juan", 33, "Hugo", 29, "Ana", 45, "Luis", 47, "Mario", 33,
				"Rosa", 29, "Carmen", 33, "Elena", 59, "Benito", 33);
		IO.println(valorMenosRepetido(m));
	}
}
