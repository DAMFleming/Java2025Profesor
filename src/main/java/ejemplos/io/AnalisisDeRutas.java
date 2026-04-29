package ejemplos.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class AnalisisDeRutas {
static void mostrar(String item, Object valor) {
		IO.println(item + ": \u001b[31m" + valor + "\u001B[0m");
	}
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("os.name"));
		Path p = Path.of("c:", "Users", "julio.profesor", "Desktop", "eclipse.lnk");
		mostrar("existe", Files.exists(p));
		mostrar("no existe", Files.notExists(p));
		mostrar("es un fichero regular", Files.isRegularFile(p));
		mostrar("es un directorio", Files.isDirectory(p));
		mostrar("es un enlace simbólico", Files.isSymbolicLink(p));
		if (Files.isSymbolicLink(p))
			mostrar("SymbolicLink", Files.readSymbolicLink(p));
		mostrar("oculto", Files.isHidden(p));
		mostrar("tamaño", Files.size(p));
		mostrar("unidad/partición/volumen", Files.getFileStore(p));
		mostrar("fecha y hora de última modificación", Files.getLastModifiedTime(p));
		mostrar("propietario", Files.getOwner(p));
		mostrar("tipo MIME (tipo de contenido)", Files.probeContentType(p));
		mostrar("es ejecutable", Files.isExecutable(p));
		mostrar("se puede leer", Files.isReadable(p));
		mostrar("se puede escribir", Files.isWritable(p));
		IO.println(FileSystems.getDefault().supportedFileAttributeViews());
		if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix"))
			mostrar("PosixFilePermissions", Files.getPosixFilePermissions(p));
	}

}

