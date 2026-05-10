package unidad8.ejemplos;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Rutas {
	static void info(Path p) {
		IO.println("\u001b[31m" + p + "\u001B[0m");
		if (Files.exists(p)) {
			IO.println("Tipo de ruta: " + (p.isAbsolute() ? "absoluta" : "relativa"));
			IO.println("Tipo de elemento: " + (Files.isRegularFile(p) ? "fichero" : Files.isDirectory(p) ? "directorio" : "otro"));
			IO.println("Nombre de fichero o directorio: " + p.getFileName());
			IO.println("Ruta del directorio padre: " + p.getParent());
			IO.println("Raíz: " + p.getRoot());
		}
		else
			IO.println("no existe");
		IO.println("******************");
	}
	public static void main(String[] args) {
		IO.println("\u001b[31m" + System.getProperty("os.name") + "\n\u001B[0m******************");
		Path p;
		info(p = Paths.get("c:", "users", "julio.profesor", "downloads"));
		info(Path.of(FileSystems.getDefault().getSeparator(), "dev", "console"));
		Path ruta = Paths.get("src", "main", "java", "ejemplos", "Rutas.java");
		info(ruta);
		Path rutaAbsoluta = ruta.toAbsolutePath();
		info(rutaAbsoluta);
		info(rutaAbsoluta.getParent());
		try {
			info(p.toRealPath());
		} catch (IOException e) {
			System.out.println(e);
		}
		URI uri = ruta.toUri();
		System.out.println("URI: \u001b[31m" + uri + "\n\u001B[0m******************");
		Path rutaURI = Paths.get(uri);
		info(rutaURI);
	}
}

