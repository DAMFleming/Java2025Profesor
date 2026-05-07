package ejemplos.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class EscrituraDatosBinarios {

	public static void main(String[] args) {
		Path p = Path.of("datos.bin");
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(p.toFile()))) {
			out.writeInt(65546);
			out.writeUTF("Hola Mundo!");
			out.writeBoolean(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
