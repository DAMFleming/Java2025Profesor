package unidad9.java2d.knight;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	private void crearMostrarGUI() {
		JFrame frame = new JFrame("Ejemplo Java 2D");
		Lienzo lienzo = new Lienzo(900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(lienzo);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		lienzo.iniciar();
		lienzo.requestFocus();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main()::crearMostrarGUI);
	}

}
