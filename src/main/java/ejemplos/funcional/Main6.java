package ejemplos.funcional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main6 {

	public static void main(String[] args) {
//		IntStream.range(1, 10).filter(n -> n % 2 != 0).forEach(System.out::println);
//		IntStream.range(1, 10).filter(n -> n > 0).forEach(System.out::println);
//		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(ClassLoader.getSystemResourceAsStream ("quijote.txt")));
//		int max = in.lines()
//				.filter(linea -> linea.contains("Dulcinea"))
//				.map(String::length)
//				.mapToInt(n -> n)
//				.max()
//				.orElse(-1);
		int max = in.lines()
				.filter(linea -> linea.contains("Dulcinea"))
				.map(String::length)
				.max(Integer::compare)
				.orElse(-1);
		System.out.println(max);
	}

}
