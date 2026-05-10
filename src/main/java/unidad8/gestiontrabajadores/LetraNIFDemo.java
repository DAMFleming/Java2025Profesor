package unidad8.gestiontrabajadores;

public class LetraNIFDemo {
	
	private static int nif = 22222222;

	public static void main(String[] args) {
		IO.println(String.valueOf(nif) + NIF.letra(nif));
	}

}