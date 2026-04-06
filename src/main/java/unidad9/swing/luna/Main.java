package unidad9.swing.luna;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private Visor visor;
	private Selector selector;
	
	public Main() {
		super("Fases de la Luna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		visor = new Visor(this);
		add(visor, BorderLayout.CENTER);
		add(selector = new Selector(this), BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
	
	public Visor getVisor() {
		return visor;
	}



	public Selector getSelector() {
		return selector;
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}
	
}
