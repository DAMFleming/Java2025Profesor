package unidad8.gestiontrabajadores;

public class NIF {
	
	static public char letra(int numero) {
		return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numero % 23);
	}
	
	static public int validar(String nif) throws Exception {
		if (nif.length() < 2)
			throw new Exception("NIF no válido");
		int i = nif.length() - 1;
		try {
			int numero = Integer.parseInt(nif.substring(0,  i));
			if (nif.toUpperCase().charAt(i) != letra(numero))
				throw new Exception("el nif introducido no es válido");
			return numero;
		} catch (NumberFormatException e) {
			throw new Exception("NIF no válido");
		}
	}
	
}
