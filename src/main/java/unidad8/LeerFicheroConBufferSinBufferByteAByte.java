package unidad8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerFicheroConBufferSinBufferByteAByte {

	static void leer(InputStream in, long n, String mensaje) throws IOException {
		long c = 0;
		IO.println(mensaje);
		long t = System.currentTimeMillis();
		while (in.read() != -1) {
			c++;
			IO.print(String.format("%.2f%% - %d / %d\033[0G", c * 100d / n, c, n));
		}
		IO.println();
		IO.println(String.format("\033[1B\033[0G%.2f segundos", (System.currentTimeMillis() - t) / 1000d));
	}
	
	public static void main(String[] args) {
		Path p = Path.of(System.getProperty("user.home"), "Desktop", "Debian 12.11 (LAMP).7Z");
		try {
			long n = Files.size(p);
			try (FileInputStream in = new FileInputStream(p.toFile())) {
				leer(in, n, "Leyendo sin buffer");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(p.toFile()))) {
				leer(in, n, "Leyendo con buffer");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
