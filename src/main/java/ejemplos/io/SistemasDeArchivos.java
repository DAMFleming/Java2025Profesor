package ejemplos.io;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SistemasDeArchivos {

	public static void main(String[] args) throws IOException {
		FileSystem defaultFileSystem = FileSystems.getDefault();
		System.out.println(System.getProperty("os.name"));
		IO.println("*************************************");
		defaultFileSystem.getFileStores().forEach(fs -> {
			try {
			IO.println(String.format(
					"FileStore: %s, tamaño: %d bytes, espacio libre: %d bytes",
					fs,
					fs.getTotalSpace(),
					fs.getUsableSpace()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		IO.println("*************************************");
		defaultFileSystem.getRootDirectories().forEach(IO::println);
		IO.println("*************************************");
		IO.println("Separator: " + defaultFileSystem.getSeparator());
		IO.println("UserPrincipalLookupService: " + defaultFileSystem.getUserPrincipalLookupService());
		IO.println("isOpen: " + defaultFileSystem.isOpen());
		IO.println("isReadOnly: " + defaultFileSystem.isReadOnly());
		IO.println("FileSystemProvider: " + defaultFileSystem.provider());
		IO.println("File Attribute Views: " + defaultFileSystem.supportedFileAttributeViews());
		IO.println("*************************************");
		Path jarFile = Paths.get("C:", "Users", "Julio.profesor", "Documents", "prueba.jar");
		FileSystem jarFileSystem = FileSystems.newFileSystem(jarFile, (ClassLoader) null);
		Path p = jarFileSystem.getPath("META-INF", "MANIFEST.MF");
		Files.lines(p).forEach(System.out::println);
		IO.println("*************************************");
		jarFileSystem.getFileStores().forEach(IO::println);
	}

}
