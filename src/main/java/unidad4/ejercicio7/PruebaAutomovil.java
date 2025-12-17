package unidad4.ejercicio7;

public class PruebaAutomovil {

	public static void main(String[] args) {
		int n = Integer.parseInt(IO.readln("Número de automóviles: "));
		Automovil [] automoviles = new Automovil[n];
		leerAutomoviles(automoviles);
		realizarDesplazamientos(automoviles);
	}
	
	private static void leerAutomoviles(Automovil [] automoviles) {
		int contador = 0;
		while (contador < automoviles.length) {
			String linea = IO.readln("Automóvil: ");
			String [] datos = linea.split("\\s+");
			if (!contieneModelo(automoviles, datos[0])) {
				automoviles[contador] = new Automovil(
						datos[0],
						Float.parseFloat(datos[1]),
						Float.parseFloat(datos[2]),
						Float.parseFloat(datos[3]));
				contador++;
			}	
		}
	}

	private static boolean contieneModelo(Automovil [] automoviles, String modelo) {
		int i = 0;
		while (i < automoviles.length
				&& automoviles[i] != null
				&& !automoviles[i].getModelo().equals(modelo))
			i++;
		return i < automoviles.length && automoviles[i] != null;
	}
	
	private static void realizarDesplazamientos(Automovil [] automoviles) {
		
	}
	
}
