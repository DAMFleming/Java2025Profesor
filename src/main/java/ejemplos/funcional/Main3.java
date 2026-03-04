package ejemplos.funcional;

import java.util.function.DoubleBinaryOperator;

public class Main3 {

	public static void main(String[] args) {
		DoubleBinaryOperator op;
		op = (a, b) -> a + b;
		System.out.println(op.applyAsDouble(2, 3));
		op = new DoubleBinaryOperator() {
			@Override
			public double applyAsDouble(double left, double right) {
				return left + right;
			}
		};
		System.out.println(op.applyAsDouble(2, 3));
		
		
		unMetodo((a, b) -> a + b);
	}
	
	static void unMetodo(DoubleBinaryOperator op) {
		double n1 = Double.parseDouble(IO.readln("Dame un número"));
		double n2 = Double.parseDouble(IO.readln("Dame otro número"));
		double resultado = op.applyAsDouble(n1, n2);
		System.out.println(resultado);
	}

}


