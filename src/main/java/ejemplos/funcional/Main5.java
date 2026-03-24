package ejemplos.funcional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main5 {
	
	public static void main(String[] args) {
		Function<String, String> f3;

		f3 = String::new;
		
		String s;
		s = f3.apply("hola");
		s = new String("hola");
		
		Function<Integer, String> f;
		
		f = n -> String.valueOf(n);
		
		
		f = Main5::unMetodo;
		
		String s1 = f.apply(55);
		
		Main5 o = new Main5();
		f = o::otroMetodo;
		
		f.apply(100);
		
		BiFunction<Main5, Integer, String> f2;
		f2 = Main5::otroMetodo;
		
		I f4 = Main5::otroMetodo;
		
		
//		f2 = o::otroMetodo;
	}

	static String unMetodo(Integer n) {
		return String.valueOf(n);
	}
	
	String otroMetodo(Integer n) {
		return String.valueOf(n);
	}
	
	@FunctionalInterface
	interface I {
		String metodoAbstracto(Main5 p1, Integer p2);
	}
}
