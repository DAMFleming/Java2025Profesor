package unidad8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerFicheroConBufferSinBufferByteAByte {

	public static void main(String[] args) {
		Path p = Path.of(System.getProperty("user.home"), "Desktop", "Debian 12.11 (LAMP).7Z");
		try {
			long n = Files.size(p);
			long c = 0;
			double porcentaje = c * 100d / n;
			try (FileInputStream in = new FileInputStream(p.toFile())) {
				IO.println("Leyendo sin buffer...");
				long t = System.currentTimeMillis();
				while (in.read() != -1) {
					c++;
					IO.print(String.format("%.2f%% - %d / %d\033[0G",porcentaje, c, n));
				}
				IO.println(System.currentTimeMillis() - t);
			} catch (IOException e) {
				e.printStackTrace();
			}
			IO.println();
			try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(p.toFile()))) {
				IO.println("Leyendo con buffer...");
				long t = System.currentTimeMillis();
				while (in.read() != -1)
					;
				IO.println(System.currentTimeMillis() - t);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
