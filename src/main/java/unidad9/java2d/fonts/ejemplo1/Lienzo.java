package unidad9.java2d.fonts.ejemplo1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String TEXTO = "Texto de prueba";
	private static final int Y = 100;
	
	private FontMetrics fm;
	private Font font;

	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/mrsmonster.ttf"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		setFont(font.deriveFont(40f));
		fm = getFontMetrics(getFont());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString(TEXTO, 100, Y);
		g2d.setColor(Color.RED);
		g2d.drawLine(0, Y, getWidth(), Y);
		int descent = fm.getDescent();
		g2d.setColor(Color.GREEN);
		g2d.drawLine(0, Y + descent, getWidth(), Y + descent);
		int ascent = fm.getAscent();
		g2d.setColor(Color.BLUE);
		g2d.drawLine(0, Y - ascent, getWidth(), Y - ascent);
		
	}
	
}
