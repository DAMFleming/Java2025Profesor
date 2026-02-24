package ejemplos.funcional;

import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

public class Main2 {

	public static void main(String[] args) {

		ToDoubleBiFunction<Float, Long> v;
		v = (a, b) -> a * b;
		System.out.println(v.applyAsDouble(10f, 5l));
		
		v = new MiClase();
		
		v = new ToDoubleBiFunction<Float, Long>() {
			@Override
			public double applyAsDouble(Float t, Long u) {
				return t * u;
			}
		};
		
		OtraClase oc = new OtraClase();
		
		v = oc::m1;
		
		//v = OtraClase::m1;
		
		Function<String, Integer> v2 = String::length;
//		v2 = "hola"::length;
		
		Function<String, String> v3 = String::new;
		
		String s = v3.apply("Hola");
		
		
	}

}

class MiClase implements ToDoubleBiFunction<Float, Long> {
	@Override
	public double applyAsDouble(Float t, Long u) {
		return t / u;
	}
}

class OtraClase {
	
	public double m1(Float f, Long l) {
		return f * l;
	}
	
}