package unidad9.java2d.ejemplo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

	public static final BufferedImage imagen;
	
	static {
		try {
			imagen = ImageIO.read(Lienzo.class.getResource("/capitales/img/mapamundi.png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(imagen, 0, 0, this);
		g2d.setColor(Color.BLACK);
		g2d.rotate(Math.PI / 4, 250, 200);
		g2d.scale(1.5, 1.5);
		g2d.drawOval(100, 100, 300, 200);
		g2d.drawString("Hola Mundo", 100, 100);
		
	}
	
}
