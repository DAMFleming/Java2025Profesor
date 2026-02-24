package ejemplos.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						ClassLoader.getSystemResourceAsStream("La Divina Comedia.txt")));
		System.out.println(br.lines().filter(s -> s.length() % 2 == 0).count());
	}

}
