package unidad9.java2d.ejemplo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Lienzo extends JPanel {

	private enum Movimiento {
		ATTACK, DEAD, IDLE, JUMP, JUMPATTACK, RUN, WALK
	}
	
	private static final long serialVersionUID = 1L;
	private static final EnumMap<Movimiento, List<BufferedImage>> fotogramas = new EnumMap<>(Movimiento.class);
	private int índiceFotograma = 0;
	private Movimiento movimientoActual = Movimiento.IDLE;
	private final Timer t = new Timer(100, Lienzo.this::actualizarFotograma);
	
	static {
		try {
			for (Movimiento m: Movimiento.values()) {
				List<BufferedImage> list = new ArrayList<>();
				fotogramas.put(m, list);
				for(int i = 1; i < 11; i++) {
					list.add(ImageIO.read(Lienzo.class.getResource("/sprites/" + m + i +".png")));
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void actualizarFotograma(ActionEvent e) {
		if (++índiceFotograma == fotogramas.get(movimientoActual).size()) {
			índiceFotograma = 0;
		}
		repaint();
	}
	
	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(new LienzoKeyListener());
	}
	
	public void iniciar() {
		t.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		g2d.drawImage(fotogramas.get(movimientoActual).get(índiceFotograma), 0, 0, this);
	}
	
	public void cambiarMovimiento(Movimiento movimiento) {
		t.stop();
		movimientoActual = movimiento;
		índiceFotograma = 0;
		t.start();
	}
	
	private class LienzoKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				cambiarMovimiento(Movimiento.ATTACK);
				break;
			case KeyEvent.VK_D:
				cambiarMovimiento(Movimiento.DEAD);
				break;
			case KeyEvent.VK_I:
				cambiarMovimiento(Movimiento.IDLE);
				break;
			case KeyEvent.VK_J:
				cambiarMovimiento(Movimiento.JUMP);
				break;
			case KeyEvent.VK_X:
				cambiarMovimiento(Movimiento.JUMPATTACK);
				break;
			case KeyEvent.VK_R:
				cambiarMovimiento(Movimiento.RUN);
				break;
			case KeyEvent.VK_W:
				cambiarMovimiento(Movimiento.WALK);
				break;
			}
		}
	}
	
}
