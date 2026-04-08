package unidad9.java2d.knight;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
