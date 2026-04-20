package ejemplos;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println(aleatorio(1));

	}
	
	static int aleatorio(int n) {
		Random r = new Random(n);
		return r.nextInt();
	}

}
