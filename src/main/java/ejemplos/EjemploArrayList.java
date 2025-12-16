package ejemplos;

import java.util.ArrayList;
import java.util.Iterator;

public class EjemploArrayList {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("a");
		lista.add("z");
		lista.add("l");
		System.out.println(lista);
		System.out.println(lista.get(2));

//		Iterator<String> i = lista.iterator();
//		while (i.hasNext())
//			System.out.println(i.next());

//		for (String s: lista) {
//			System.out.println(s);
//		}

		lista.add(2, "u");

		lista.forEach(s -> System.out.println(s));
	}

}
