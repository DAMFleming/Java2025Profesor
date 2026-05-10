package unidad8.ejemplos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerFicheroConBufferSinBufferByteAByte {
	
	static void mostrarProgreso(long t0, long n, long c) {
		long t1 = System.currentTimeMillis() - t0;
		long s = (long) ((n - c) * t1 / c / 1000d);
		long h = s / 3600;
		s = s % 3600;
		long m = s / 60;
		s = s % 60;
		IO.print(String.format("Leidos %d bytes de %d (%.2f%%) - Tiempo restante: %02d:%02d:%02d\033[0G", c, n, c * 100d / n, h, m, s));
	}

	static void leer(InputStream in, long n, String mensaje) throws IOException {
		IO.println(mensaje);
		long c = 0, t0 = System.currentTimeMillis(), t1, h, m, s;
		long crono = t0;
		while (in.read() != -1) {
			c++;
			if (System.currentTimeMillis() - crono > 1000 ) {
				mostrarProgreso(t0, n, c);
				crono = 0;
			}
		}
		IO.println();
		IO.println(String.format("%.2f segundos", (System.currentTimeMillis() - t0) / 1000d));
		IO.println();
	}

	public static void main(String[] args) {
		Path p = Path.of("/home", "julio", "vmware", "Windows 11 x64", "Windows 11 x64-s001.vmdk");
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
