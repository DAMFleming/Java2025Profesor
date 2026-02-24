package unidad6.colecciones1b;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio2 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> lista = new LinkedList<>();
		for (int i=0; i<100; i++)
			lista.add(r.nextInt(500) + 1);
		
		Iterator<Integer> i = lista.iterator();
		while(i.hasNext())
			System.out.print(i.next() + " ");
		
		System.out.println();
		
		Set<Integer> conjunto1 = new HashSet<>(lista);
		for (int n: conjunto1)
			System.out.print(n + " ");
		
		System.out.println();
		
		Set<Integer> conjunto2 = new TreeSet<>(conjunto1);
		conjunto2.forEach(n -> System.out.print(n + " "));
		
		System.out.println(" \n" + (lista.size() - conjunto1.size()));
	}
}
