package unidad9.java2d.knight;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public enum Estado {
	
	ATTACK(), DEAD(), IDLE(), JUMP(), JUMPATTACK(), RUN(), WALK();
	
	private final List<BufferedImage> sprites = new ArrayList<>();
	
	Estado() {
		for(int i = 1; i < 11; i++) {
			try {
				sprites.add(ImageIO.read(getClass().getResource("/sprites/" + this + i +".png")));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public List<BufferedImage> getSprites() {
		return Collections.unmodifiableList(sprites);
	}
	
	public Map<Integer, List<BufferedImage>> getSpritesModificados(double altura) {
		List<BufferedImage> dcha = new ArrayList<>();
		List<BufferedImage> izda = new ArrayList<>();
		for (BufferedImage i: sprites) {
			/*
			 * REDIMENSIONAR
			 */
			double fe = altura / i.getHeight();
			AffineTransform af = AffineTransform.getScaleInstance(fe, fe);
			AffineTransformOp op = new AffineTransformOp(af, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			dcha.add(op.filter(i, null));
			
			/*
			 * REDIMENSIONAR Y VOLTEAR HORIZONTALMENTE
			 */
			af = AffineTransform.getScaleInstance(-fe, fe);
			af.translate(-i.getWidth(null), 0);
			op = new AffineTransformOp(af, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			izda.add(op.filter(i, null));
		}
		Map<Integer, List<BufferedImage>> m = new HashMap<>();
		m.put(-1, Collections.unmodifiableList(izda));
		m.put(1, Collections.unmodifiableList(dcha));
		return m;
	}
}
