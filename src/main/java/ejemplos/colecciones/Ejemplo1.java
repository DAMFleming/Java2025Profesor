package ejemplos.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Ejemplo1 {

	public static void main(String[] args) {
		Collection<String> c;
		
		c = new ArrayList<>();
		c.add("Carmen");
		c.add("Fernando");
		c.add("María");
		c.add("Fernando");
		c.add("Roberto");
		c.add("Fernando");
		c.forEach(nombre -> System.out.println(nombre));
		System.out.println("La lista contiene a Roberto: " + c.contains("Roberto"));
		((ArrayList) c).remove(3);
		System.out.println(c);
		System.out.println("Número de nombres en la lista: " + c.size());
		c.clear();
		
		c = new TreeSet<>();
		c.add("Elisa");
		c.add("Roberto");
		c.add("Roberto");
		System.out.println(c);
		System.out.println("El conjunto contiene a Roberto: " + c.contains("Roberto"));
		c.remove("Roberto");
		System.out.println("Numero de nombres en el conjunto: " + c.size());
		c.clear();

	}

}
