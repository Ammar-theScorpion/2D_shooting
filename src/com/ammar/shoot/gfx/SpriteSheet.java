package com.ammar.shoot.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage bufferedImage;
	
	public SpriteSheet(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return bufferedImage.getSubimage(x, y, width, height);
	}
}
