package unidad9.java2d.knight.ejercicio2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Surface extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private static final double VELOCIDAD_CABALLERO = 1d;	// metros/segundo
	private static final double ANCHO_ESCENARIO = 10d;		// metros
	private static final double ALTURA_CABALLERO = 1.8d;	// metros
	
	private Thread t;
	private boolean paused;
	private final Caballero caballero;
	private BufferedImage fondo;
	
	public Surface(int w, int h) {
		try {
			fondo = ImageIO.read(getClass().getResource("/fondos/fondo1.jpg"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		w = fondo.getWidth();
		h = fondo.getHeight();
		setPreferredSize(new Dimension(fondo.getWidth(), fondo.getHeight()));
		setBackground(Color.BLACK);
		double alturaCaballero = w * ALTURA_CABALLERO / ANCHO_ESCENARIO;
		double velocidad = w * VELOCIDAD_CABALLERO / ANCHO_ESCENARIO;
		caballero = new Caballero(alturaCaballero, 0, h - alturaCaballero, velocidad, 1, this);
	}

	private void run() {
		long t0 = System.nanoTime(), t1;
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this) {
				if (paused) {
					try {
						wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					t0 = System.nanoTime();
				}
			}
			next((t1 = System.nanoTime()) - t0);
			drawFrame();
			t0 = t1;
		}
	}

	public void start() {
		createBufferStrategy(2);
		t = new Thread(this::run);
		t.start();
	}

	public void stop() {
		t.interrupt();
		if (t != Thread.currentThread())
			try {
				t.join();
			} catch (InterruptedException e) {
			}
	}

	public synchronized void pause() {
		paused = true;
	}

	public synchronized void resume() {
		if (paused) {
			paused = false;
			notify();
		}
	}

	public synchronized boolean isPaused() {
		return paused;
	}

	private void next(long lapse) {
		caballero.mover(lapse);
	}

	private void drawFrame() {
		Graphics2D g = null;
		try {
			BufferStrategy bf = getBufferStrategy(); 
			g = (Graphics2D) bf.getDrawGraphics();
			paint(g);
			if (!bf.contentsLost())
				bf.show();
			Toolkit.getDefaultToolkit().sync();
		} finally {
			if (g != null)
				g.dispose();
		}
	}

	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(fondo, 0, 0, this);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		caballero.paint(g2d);
		g2d.setColor(Color.BLACK);
	}
}
