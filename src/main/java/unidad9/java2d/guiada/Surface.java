package unidad9.java2d.guiada;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Surface extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private Thread t;
	private boolean paused;
	private Ball ball;
	
	public Surface(int w, int h) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		ball = new Ball(this, (w - 15) / 2d, (h - 15) / 2d, 15, 45d, 300d, Color.WHITE);
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
		ball.move(lapse);
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
		ball.paint(g2d);
	}
}