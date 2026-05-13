package unidad8.ejemplos.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("src\\main\\resources\\La Divina Comedia.txt"), StandardCharsets.ISO_8859_1)
				)
		) {
			String linea;
			while ((linea = in.readLine()) != null) {
				IO.println(linea);
			}
		}
	}

}
