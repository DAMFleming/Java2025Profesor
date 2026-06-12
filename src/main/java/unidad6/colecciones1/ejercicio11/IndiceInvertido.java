package unidad6.colecciones1.ejercicio11;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndiceInvertido {

	private static final Pattern pattern = Pattern.compile("\\p{L}+");
	private Map<String, Set<String>> indice = new TreeMap<>();
	
//	public void indexar(String documento) {
//		Matcher m = pattern.matcher(documento.toLowerCase());
//		while (m.find()) {
//			String palabra = m.group();
////			if(indice.containsKey(palabra))
////				indice.get(palabra).add(documento);
////			else {
////				Set<String> s = new HashSet<>();
////				s.add(documento);
////				indice.put(palabra, s);
////			}
//			Set<String> s = indice.computeIfAbsent(palabra, k -> new HashSet<>());
//			s.add(documento);
//		}
//	}
	
	public void indexar(String documento) {
		Matcher m = pattern.matcher(documento.toLowerCase());
		while (m.find()) {
			String palabra = m.group();
			Set<String> s = indice.get(palabra);
			if(s == null) {
				s = new HashSet<>();
				indice.put(palabra, s);
			}
			s.add(documento);
		}
	}
	
	public void indexar(Collection<String> documentos) {
		for (String documento: documentos)
			indexar(documento);
	}
	
//	public void retirarDocumento(String documento) {
//		for (Set<String> s: indice.values())
//			s.remove(documento);
//	}
	
//	public void retirarDocumento(String documento) {
//		for (Set<String> s: indice.values())
//			s.remove(documento);
//		for (String palabra: indice.keySet())
//			if (indice.get(palabra).isEmpty())
//				indice.remove(palabra);
//	}
	
	public void retirarDocumento(String documento) {
		for (Entry<String, Set<String>> e: indice.entrySet()) {
			Set<String> s = e.getValue();
			s.remove(documento);
			if (s.isEmpty())
				indice.remove(e.getKey());
		}
	}
	
	public Set<String> getDocumentos(String palabra) {
		return Collections.unmodifiableSet(indice.get(palabra));
	}
	
	public Set<String> getDocumentosContienenTodas(String ...palabras) {
		Set<String> s = new HashSet<>();
		Set<String> aux = indice.get(palabras[0].toLowerCase());
		if (aux == null)
			return null;
		s.addAll(aux);
		for (int i=1; i<palabras.length; i++) {
			aux = indice.get(palabras[i].toLowerCase());
			if (aux == null)
				return null;
			s.retainAll(aux);
		}
		return s;	
	}
	
	public Set<String> getDocumentosContienenTodas(String palabras) {
		return getDocumentosContienenTodas(palabras.split("\\P{L}+"));
	}
	
	public Set<String> getDocumentosContienenCualquiera(String ...palabras) {
		Set<String> s = new HashSet<>();
		for (String palabra: palabras) {
			Set<String> aux = indice.get(palabra.toLowerCase());
			if (aux != null)
				s.addAll(aux);
		}
		return s;
	}
	
	public Set<String> getDocumentosContienenCualquiera(String palabras) {
		return getDocumentosContienenCualquiera(palabras.split("\\P{L}+"));
	}
	
	
	
}
