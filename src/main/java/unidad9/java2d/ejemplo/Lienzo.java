package unidad9.java2d.ejemplo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Lienzo extends JPanel {

	private static final ArrayList<BufferedImage> fotogramas = new ArrayList<>();
	private int índiceFotograma = 0;
	private final Timer t = new Timer(100, Lienzo.this::actualizarFotograma);
	
	static {
		try {
			for(int i = 1; i < 11; i++) {
				fotogramas.add(ImageIO.read(Lienzo.class.getResource("/sprites/RUN" + i +".png")));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void actualizarFotograma(ActionEvent e) {
		índiceFotograma++;
		if (índiceFotograma == fotogramas.size()) {
			índiceFotograma = 0;
		}
		repaint();
	}
	
	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
	}
	
	public void iniciar() {
		t.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		g2d.drawImage(fotogramas.get(índiceFotograma), 0, 0, this);
	}
	
}
