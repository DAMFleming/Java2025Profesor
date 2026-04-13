package unidad9.java2d.knight.ejercicio1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import unidad9.java2d.knight.Estado;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 1L;
	private int índiceFotograma = 0;
	private Estado estadoActual = Estado.IDLE;
	private final Timer t = new Timer(100, Lienzo.this::actualizarFotograma);
	
	private void actualizarFotograma(ActionEvent e) {
		if (++índiceFotograma == estadoActual.getSprites().size()) {
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
		g2d.drawImage(estadoActual.getSprites().get(índiceFotograma), 0, 0, this);
	}
	
	public void cambiarEstado(Estado estado, int delay) {
		t.stop();
		t.setDelay(delay);
		estadoActual = estado;
		índiceFotograma = 0;
		t.start();
	}
	
	private class LienzoKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				cambiarEstado(Estado.ATTACK, 100);
				break;
			case KeyEvent.VK_D:
				cambiarEstado(Estado.DEAD, 200);
				break;
			case KeyEvent.VK_I:
				cambiarEstado(Estado.IDLE, 150);
				break;
			case KeyEvent.VK_J:
				cambiarEstado(Estado.JUMP, 100);
				break;
			case KeyEvent.VK_X:
				cambiarEstado(Estado.JUMPATTACK, 100);
				break;
			case KeyEvent.VK_R:
				cambiarEstado(Estado.RUN, 50);
				break;
			case KeyEvent.VK_W:
				cambiarEstado(Estado.WALK, 100);
				break;
			}
		}
	}
	
}
