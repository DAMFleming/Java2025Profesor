package ejemplos.io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class EscrituraBytesAleatorios {

	private static Random r = new Random();
	
	static void escribirDatos(FileOutputStream out) throws IOException {
		for (int i=0; i<0x400; i++)
			out.write(r.nextInt(256));
	}
	
	static void mostrarLongitud(Path p) {
		if (Files.exists(p))
			try {
				IO.println(Files.size(p));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		
		Path p = Path.of("aleatorios");
		try (FileOutputStream out = new FileOutputStream(p.toFile())) {
			escribirDatos(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mostrarLongitud(p);
		try (FileOutputStream out = new FileOutputStream(p.toFile(), true)) {
			escribirDatos(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mostrarLongitud(p);
	}
	
}
