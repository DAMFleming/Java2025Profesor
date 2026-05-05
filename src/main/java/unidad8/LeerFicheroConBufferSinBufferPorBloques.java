package unidad8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerFicheroConBufferSinBufferPorBloques {

	public static void main(String[] args) {
		byte[] array = new byte[1000000];
		Path p = Path.of(System.getProperty("user.home"), "Desktop", "Debian 12.11 (LAMP).7Z");
		try (FileInputStream in = new FileInputStream(p.toFile())) {
			IO.println("Leyendo sin buffer...");
			long t = System.currentTimeMillis();
			while (in.read(array) != -1);
			IO.println(System.currentTimeMillis() - t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(p.toFile()))) {
			IO.println("Leyendo con buffer...");
			long t = System.currentTimeMillis();
			while (in.read(array) != -1);
			IO.println(System.currentTimeMillis() - t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
