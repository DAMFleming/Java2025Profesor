package examenrec1ev2ev;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Ejercicio4 {

	public static void colapsar(Deque<Integer> pila) {
		Deque<Integer> aux = new LinkedList<>();
		while (!pila.isEmpty()) {
			int n = pila.pop();
			if (!pila.isEmpty())
				n += pila.pop();
			aux.push(n);
		}
		while (!aux.isEmpty())
			pila.push(aux.pop());
	}
	
	public static void main(String[] args) {
		Deque<Integer> pila = new ArrayDeque<>();
		pila.push(5);
		pila.push(11);
		pila.push(-3);
		pila.push(14);
		pila.push(9);
		pila.push(4);
		pila.push(21);
		pila.push(-42);
		pila.push(13);
		pila.push(2);
		IO.println(pila);
		colapsar(pila);
		IO.println(pila);
	}
	
}
