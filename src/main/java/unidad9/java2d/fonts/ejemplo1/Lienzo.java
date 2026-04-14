package unidad9.java2d.fonts.ejemplo1;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 1L;

	public Lienzo(int ancho, int alto) {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
	}
	
}
