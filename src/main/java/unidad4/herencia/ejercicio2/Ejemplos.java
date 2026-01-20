package unidad4.herencia.ejercicio2;

public class Ejemplos {

	private int x = 5;
	
	public static class A {
		int n;
		public A(int n) {
			this.n = n;
		}
		@Override
		public String toString() {
			return String.valueOf(n) + " " + String.valueOf(x);
		}
	}
	
	public static void main(String[] args) {
		A a = new A(10);
	}
	
}

class B {
	public static void main(String[] args) {
		Ejemplos.A a = new Ejemplos.A(10);
	}
}