package unidad9.java2d.figuras;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Surface extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private Thread t;
	private boolean paused;
	private List<Figura> figuras = new ArrayList<>();
	private double anguloGiro = -Math.PI / 4;
	
	public Surface(int w, int h) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		figuras.add(Figura.getPoligono(100, 100, 50, 5, Color.RED));
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
		// actualizar angulo de giro del conjunto
		// actualizar angulo de giro de cada figura
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
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.rotate(anguloGiro, getWidth() / 2, getHeight() / 2);
		figuras.forEach(f -> f.paint(g2d));
	}
}