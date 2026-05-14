package unidad8.csv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Ejercicio {

	public static void main(String[] args) throws IOException {
		//O'Reilly Media
		String editorial;
		editorial = IO.readln("Editorial: ");
		CSVFormat format = CSVFormat.DEFAULT
				.builder()
				.setHeader()
				.get();
//		try (Reader in = new FileReader("src/main/resources/csv/libros1.csv"))) {
		try (Reader in = new InputStreamReader(Ejercicio.class.getResourceAsStream("/csv/libros1.csv"));
				DataOutputStream out = new DataOutputStream(new FileOutputStream("libros.bin"))) {
			for (CSVRecord r: format.parse(in)) {
				if (r.get("editorial").equalsIgnoreCase(editorial)) {
					out.writeUTF(r.get("titulo"));
					out.writeUTF(r.get("autor"));
					out.writeUTF(r.get("editorial"));
					out.writeInt(Integer.parseInt(r.get("año")));
					out.writeUTF(r.get("categoria"));
				}
			}
		}
		try (DataInputStream in = new DataInputStream(new FileInputStream("libros.bin"))) {
			do {
				IO.print(in.readUTF());
				IO.print(", ");
				IO.print(in.readUTF());
				IO.print(", ");
				IO.print(in.readUTF());
				IO.print(", ");
				IO.print(in.readInt());
				IO.print(", ");
				IO.print(in.readUTF());
				IO.println();
			} while (true);
		} catch (EOFException e) {
		}
	}

}
