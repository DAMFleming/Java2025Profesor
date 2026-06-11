package unidad6.colecciones1.ejercicio11;

public class Main {

	public static void main(String[] args) {
		IndiceInvertido ii = new IndiceInvertido();
		ii.indexar("hola Mundo");
		ii.indexar("adios Mundo cruel");
		ii.indexar("el adios es muy cruel");
		ii.indexar("adios Pepe");
		IO.println(ii.getDocumentosDeTodas("adios", "cruel"));
	}
	
}

