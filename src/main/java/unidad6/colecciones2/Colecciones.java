package unidad6.colecciones2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
			
		}
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
		
		
	}
}
