package ejemplos.clases.anidadas;

import unidad4.herencia.ejercicio2.Electrodomestico;

public class EjemploClaseAnónima {

	private int v = 4;
	
	 {
		Electrodomestico e = new Electrodomestico(359.99f, 35f) {
			public void unMétodo() {
				System.out.println("Hola Mundo" + v);
			}
		};
	}
	
	private Electrodomestico e;
	
	public void main(String[] args) {
		e = new Electrodomestico(359.99f, 35f) {
			public void unMétodo() {
				System.out.println("Hola Mundo" + v);
			}
		};
		System.out.println(e);
	}
	
}
