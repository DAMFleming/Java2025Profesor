package unidad8.ejemplos.csv.lib;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import unidad8.ejemplos.csv.Libro;

public class LecturaSinCabeceras {

	public static void main(String[] args) throws IOException {
		try (Reader in = new InputStreamReader(
				LecturaSinCabeceras.class.getResourceAsStream("/csv/libros3.csv")
				)) {
			for (CSVRecord r: CSVFormat.DEFAULT.parse(in)) {
				Libro l = new Libro(
						r.get(0),
						Arrays.asList(r.get(1).split(",\\s*")),
						r.get(2),
						Integer.parseInt(r.get(3)),
						r.get(4)
				);
				System.out.println(l);
			}
				
		}

	}

}
