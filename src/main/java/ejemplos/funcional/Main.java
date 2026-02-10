package ejemplos.funcional;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		BiConsumer<Integer, String> biConsumer = (n, s) -> {
			for (int i=0; i<n; i++)
				System.out.println(s);
		};
		
		biConsumer.accept(10, "Hola Mundo");
		
		
		m((n, s)  -> {
			for (int i=0; i<n; i++)
				System.out.println(s);
		});
		
		m((n, s) -> System.out.println(s.charAt(n)));
		
		m2(s -> {
			int n = 0;
			for (int i=0; i<s.length(); i++)
				n += s.charAt(i);
			return n;
		});
		
		m2(s -> s.length());
		m2(String::length);
		
	}
	
	static void m(BiConsumer<Integer, String> biConsumer) {
		biConsumer.accept(6,  "hola mundo");
	}
	
	static void m2(Function<String, Integer> f) {
		String s = IO.readln("Introduce una cadena: ");
		System.out.println(f.apply(s));
	}
	
}
