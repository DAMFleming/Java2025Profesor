package ejemplos.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main4<T> {

	private T [] array;
	
	@SuppressWarnings("unchecked")
	private Main4(T ...elementos) {
		array = Arrays.copyOf(elementos, elementos.length);
	}
	
	public static Main4<? extends Object> of(Object ... elementos) {
		return new Main4<>(elementos);
	}
	
	public void forEach(Consumer<T> c) {
		for (T o: array) {
			c.accept(o);
		}
	}
	
	public static void main(String[] args) {
//		Main4<String> l = Main4.of("a", "bb", "ccc");
//		l.forEach(pepe -> System.out.println(pepe.length()));
	}
	
}
