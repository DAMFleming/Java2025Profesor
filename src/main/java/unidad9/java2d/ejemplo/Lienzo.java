package unidad9.java2d.ejemplo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 300, 200);
	}
	
}
