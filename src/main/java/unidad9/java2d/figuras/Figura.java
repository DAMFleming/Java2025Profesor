package unidad9.java2d.figuras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class Figura {
	
	private Shape shape;
	private Color color;
	private double anguloGiro = Math.PI / 4;
	private double x;
	private double y;
	
	private Figura(Shape shape, Color color, double x, double y) {
		this.shape = shape;
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public static Figura getPoligono(double x, double y, double radio, int lados, Color color) {
		Polygon p = new Polygon();
		double angulo = 2 * Math.PI / lados;
		for (int i=0; i<lados; i++) {
			double vx = radio * Math.cos(angulo * i) + x;
			double vy = radio * Math.sin(angulo * i) + y;
			p.addPoint((int) vx, (int) vy);
		}
		return new Figura(p, color, x, y);
	}

	public void paint(Graphics2D g) {
		AffineTransform af = g.getTransform();
		g.setColor(color);
		g.rotate(anguloGiro, x, y);
		g.draw(shape);
		g.setTransform(af);
	}
	
}
