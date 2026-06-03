package unidad3.arrays;

public class Ejercicio09 {
	public static Integer centro(int [] vector) {
		for(int c = 0; c< vector.length; c++) {
			int izq =  0;
			for(int i = 0; i < c; i++) {
				int resultado = ( c- i) * vector[i];
				izq += resultado;
			}
			int drch = 0; 
			for( int j = c+ 1; j < vector.length; j ++) {
				int resultado = ( j - c) * vector[j];
				drch += resultado;
			}
			if(izq == drch) {
				return c;
			}
		}
		return null;
	}

	public static void main(String[] args) {
//		int [] vector = {6, 2, 3, 0, 1};
		int [] vector = {1, 2, 1, 1};
		System.out.println(centro(vector));
	}

}
