package unidad9.java2d.ejemplo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import unidad9.java2d.knight.Estado;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage original;
	private BufferedImage volteada;
	private BufferedImage reducida;
	private BufferedImage volteadaReducida;
	
	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(new LienzoKeyListener());
		original = Estado.IDLE.getSprites().getFirst();
		
		/*
		 * VOLTEAR HORIZONTALMENTE
		 */
		AffineTransform af = AffineTransform.getScaleInstance(-1, 1);
		af.translate(-original.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(af, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		volteada = op.filter(original, null);
		
		/*
		 * REDIMENSIONAR
		 */
		af = AffineTransform.getScaleInstance(.5, .5);
		op = new AffineTransformOp(af, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		reducida = op.filter(original, null);
		
		/*
		 * REDIMENSIONAR Y VOLTEAR HORIZONTALMENTE
		 */
		af = AffineTransform.getScaleInstance(-.5, .5);
		af.translate(-original.getWidth(null), 0);
		op = new AffineTransformOp(af, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		volteadaReducida = op.filter(original, null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		g2d.drawImage(original, 0, 0, this);
		g2d.drawImage(volteada, original.getWidth(), 0, this);
		g2d.drawImage(reducida, original.getWidth() - reducida.getWidth() / 2, getHeight() - reducida.getHeight(), this);
		g2d.drawImage(volteadaReducida, original.getWidth() * 2 - volteadaReducida.getWidth() / 2, getHeight() - reducida.getHeight(), this);
	}
	
	private class LienzoKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			
			}
		}
	}
	
}
