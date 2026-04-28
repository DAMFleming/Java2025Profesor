package ejemplos;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class SistemaDeArchivos {

	static class Contador {
		int ficheros;
		int directorios;
		public void reset() {
			ficheros = directorios = 0;
		}
	}
	
	static Contador cpdir(Path origen, Path destino) throws IOException {
		final Contador c = new Contador();
		Path root = origen.getParent();
		Files.walk(origen).forEach(p -> {
			Path ruta = destino.resolve(root.relativize(p));
			IO.println(String.format("%s -> %s", p, ruta));
			try {
				if (Files.isDirectory(p)) {
						Files.createDirectory(ruta);
					c.directorios++;
				}
				else if (Files.isRegularFile(p)) {
					Files.copy(p, ruta);
					c.ficheros++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		return c;
	}
	
	static Contador rmdir(Path dir) throws IOException {
		final Contador c = new Contador();
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				System.out.println(file + ": fichero borrado");
				c.ficheros++;
				return FileVisitResult.CONTINUE;
			}
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
				Files.delete(dir);
				System.out.println(dir + ": directorio borrado");
				c.directorios++;
				return FileVisitResult.CONTINUE;
			}
		});
		return c;
	}
	
	public static void main(String[] args) throws IOException {
		Contador c;
//		c = rmdir(Path.of("c:", "users", "julio.profesor", "desktop", "HibernateDemo"));
//		System.out.println(c.ficheros + " ficheros borrados");
//		System.out.println(c.directorios + " directorios borrados");
//		c.reset();
		Path home = Path.of(System.getProperty("user.home"));
		Path origen = home.resolve(Path.of("git", "Java2025Profesor"));
		Path destino = home.resolve(Path.of("Desktop"));
		c = cpdir(origen, destino);
		
	}
	
}

