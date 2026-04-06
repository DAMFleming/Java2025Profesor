package unidad9.java2d.ejemplo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	private void crearMostrarGUI() {
		JFrame frame = new JFrame("Ejemplo Java 2D");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Lienzo(900, 700));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main()::crearMostrarGUI);
	}

}
