package unidad9.java2d.knight.ejercicio2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import unidad9.java2d.knight.Estado;

public class Caballero {

	private Map<Integer, List<BufferedImage>> sprites;
	private int indiceSprite;
	private double x;
	private double y;
	private double velocidad;
	private int direccion;
	private Surface surface;
	private double distAnim;
	private double distAnimAct = 0;
	
	public Caballero(double altura, double x, double y, double velocidad, int direccion, Surface surface) {
		if (direccion != 1 && direccion != -1)
			throw new IllegalArgumentException("el parámetro 'direccion' sólo admite los valores 1 o -1");
		sprites = Estado.WALK.getSpritesModificados(altura);
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.direccion = direccion;
		this.surface = surface;
		distAnim =  sprites.get(1).getFirst().getWidth() * 350d /  Estado.WALK.getSprites().getFirst().getWidth();
	}
	
	private long tiempo = 0;
	private long crono;
	public void mover(long lapso) {
		tiempo += lapso;
		double d = velocidad * lapso / 1000000000d;
		distAnimAct += d;
		indiceSprite = (int) (distAnimAct * 10 / distAnim);
		if (indiceSprite >= sprites.get(1).size()) {
			indiceSprite = 0;
			distAnimAct = 0;
		}
		x += d * direccion;
		int anchoSprite = sprites.get(direccion).get(indiceSprite).getWidth();
		if (x + anchoSprite > surface.getWidth() && direccion == 1) {
			crono = tiempo;
			tiempo = 0;
			direccion *= -1;
		}
		else if (x < 0 && direccion == -1) {
			crono = tiempo;
			tiempo = 0;
			direccion *= -1;
		}
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(sprites.get(direccion).get(indiceSprite), (int) x, (int) y, null);
		g.setColor(Color.WHITE);
		g.drawString(String.format("%.2f", crono / 1000000000d), 100, 100);
	}

	public int getIndiceSprite() {
		return indiceSprite;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public int getDireccion() {
		return direccion;
	}
	
}
