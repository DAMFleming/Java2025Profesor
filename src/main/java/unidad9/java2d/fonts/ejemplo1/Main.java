package unidad9.java2d.fonts.ejemplo1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;


	public Main() {
		super("Ejemplo de manejo de tipografías");
		setContentPane(new Lienzo(1000, 700));
		pack();
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}

}
