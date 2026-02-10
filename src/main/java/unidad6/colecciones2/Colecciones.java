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
	

	public static void main(String[] args) {
		Set<String> c1 = new HashSet<>(Set.of("a", "aa", "aaa", "aaaa", "aaaaa"));
		IO.println(c1);
		eliminarLasDeLongitudPar(c1);
		IO.println(c1);
		
		// ----------------------------------------------------------------------------------
		
		Set<Integer> c2 = Set.of(20, 32, 25, 11, 48, 2, 1);
		System.out.println(contieneImpares(c2));
		c2 = Set.of(2, 4, 6, 8);
		System.out.println(contieneImpares(c2));
		
		// ----------------------------------------------------------------------------------
		
		Map<String, String> m1 = Map.of("c1", "aa", "c2", "bb", "c3", "cc");
		System.out.println(valoresUnicos(m1));
		m1 = Map.of("c1", "aa", "c2", "bb", "c3", "aa");
		System.out.println(valoresUnicos(m1));
		
		// ----------------------------------------------------------------------------------
		
		List<Integer> l1 = new ArrayList<>(List.of(2, 7, 1, 7, 3, 9, 1, 5, 4, 1, 3, 2, 1, 7, 3, 7, 9, 7)); 
		System.out.println(moda(l1));
	}
}
