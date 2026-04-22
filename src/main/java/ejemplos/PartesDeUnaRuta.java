package ejemplos;

import java.nio.file.Path;
import java.util.Iterator;

public class PartesDeUnaRuta {
	
	public static void main(String[] args) {
		IO.println(System.getProperty("os.name"));
		IO.println("******************");
		
		Path p = Path.of("src", "main", "java", "ejemplos", "PartesDeLasRutas.java").toAbsolutePath();
		IO.println("\u001b[31m" + p + "\u001B[0m");
		IO.println(p.getRoot());
		IO.println("******************");
		
		for (int i = 0; i < p.getNameCount(); i++)
			IO.print(p.getName(i) + (i == p.getNameCount() - 1 ? "\n" : ", "));
		IO.println("******************");
		
		Iterator<Path> i = p.iterator();
		while (i.hasNext()) {
			Path pp = i.next();
			IO.print(pp + " ");
		}
		IO.println("\n******************");
		
		for (Path pp : p)
			IO.println(pp + ": " + p.startsWith(pp) + " / " + p.endsWith(pp));
		IO.println("******************");
		
		IO.println("finaliza con '.java': " + p.endsWith(".java"));
		IO.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
	}
	
}

