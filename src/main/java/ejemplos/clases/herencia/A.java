package ejemplos.clases.herencia;

public abstract class A {
	
	private int n;
	
	public void m() {
		System.out.println("m en A");
	}
	
	public abstract void m2(int n);
	
	public static void main(String[] args) {
		C c = new C();
		c.m();
	}

}

class C extends A {
	
	@Override
	public void m() {
		System.out.println("m en C");
		super.m();
	}
	
	@Override
	public void m2(int n) {
		
	}
	
}
