package com.ammar.shoot.gfx;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Loader {	
	public static BufferedImage imageLoader(String path) {
		try {
			return ImageIO.read(Loader.class.getResource(path));
		}catch(Exception e) {
		}
		return null;
	}
}
