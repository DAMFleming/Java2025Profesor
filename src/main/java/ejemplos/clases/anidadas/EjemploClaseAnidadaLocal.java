package ejemplos.clases.anidadas;

public class EjemploClaseAnidadaLocal {

	private int v = 10;
	
	public void unMetodo() {
		class A {
			int n;

			public A(int n) {
				System.out.println(v);
				this.n = n;
			}

			public int getN() {
				return n;
			}
			
		}
		A a = new A(5);
		System.out.println(a.getN());
	}
	
	public static void main(String[] args) {
		class A {
			int n;

			public A(int n) {
				
				this.n = n;
			}

			public int getN() {
				return n;
			}
			
		}
		A a = new A(5);
		System.out.println(a.getN());
	}
	
}
