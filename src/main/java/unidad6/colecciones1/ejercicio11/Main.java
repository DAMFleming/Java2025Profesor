package unidad6.colecciones1.ejercicio11;

public class Main {

	public static void main(String[] args) {
		IndiceInvertido ii = new IndiceInvertido();
		ii.indexar("Artes y Humanidades");
		ii.indexar("Ciencias de la Salud");
		ii.indexar("Ciencias Sociales y Jurídicas");
		ii.indexar("Ingeniería y Arquitectura");
		ii.indexar("Artes y Arquitectura");
		IO.println(ii.getDocumentosContienenTodas("Artes", "y"));
		IO.println(ii.getDocumentosContienenCualquiera("Ciencias", "Arquitectura"));
	}
	
}

