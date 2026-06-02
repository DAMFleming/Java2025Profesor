package unidad4.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class TiposDeClases {

	private int v = 3;
	
	private List<String> l1 = new ArrayList<>() {
		 @Override
		public int size() {
			return super.size() * v;
		}
	};
	
	private static List<String> l2 = new ArrayList<>() {
//		 @Override
//		public int size() {
//			return super.size() * v;
//		}
	};
	
	static class Clase1 {
		int v = 5;
//		int unMetodo(int n) {
//			return n * TiposDeClases.this.v;
//		}
		@Override
		public String toString() {
			return String.valueOf(v);
		}
	}
	
	class Clase2 {
		int v = 11;
		int unMetodo(int n) {
			return n * TiposDeClases.this.v;
		}
		@Override
		public String toString() {
			return String.valueOf(v);
		}
	}
	
	
	void m1(String s) {
		class Clase3 {
			String s;
			Clase3(String s) {
				this.s = s;
			}
			@Override
			public String toString() {
				return s + String.valueOf(v);
			}
		}
		Clase3 c = new Clase3("Hola Mundo");
		IO.println(c);
	}
	
	static void m2(String s) {
		class Clase3 {
			String s;
			Clase3(String s) {
				this.s = s;
			}
//			@Override
//			public String toString() {
//				return s + String.valueOf(v);
//			}
		}
		Clase3 c = new Clase3("Hola Mundo");
		IO.println(c);
	}
	
	void m3(String s) {
		List<String> l = new ArrayList<>() {
			 @Override
			public int size() {
				return super.size() * v;
			}
		};
		l.add(s);
		IO.println(l.size());
	}
	
	static void m4(String s) {
		List<String> l = new ArrayList<>() {
//			 @Override
//			public int size() {
//				return super.size() * v;
//			}
		};
		l.add(s);
		IO.println(l.size());
	}
	
	
	public static void main(String[] args) {
		Clase1 c = new Clase1();
		IO.println(c);
		TiposDeClases t = new TiposDeClases();
		Clase2 c2 = t.new Clase2();
		IO.println(c2.unMetodo(10));
		t.m3("hola");
	}

}
