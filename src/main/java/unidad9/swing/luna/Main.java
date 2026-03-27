package unidad9.swing.luna;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Main() {
		super("Fases de la Luna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		Visor visor = new Visor();
		add(visor, BorderLayout.CENTER);
		add(new Selector(visor), BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}
	
}
