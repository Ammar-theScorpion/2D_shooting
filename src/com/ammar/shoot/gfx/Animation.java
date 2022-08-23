package com.ammar.shoot.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	int FPS = 60;
	double timePerTick=1000000000/5;
	long lastTime = System.nanoTime();
	double delta = 0;
	private int counter = 0;
	double time;
	private BufferedImage[] bufferedImages;
	private int until;
	public Animation(BufferedImage[] bufferedImages, int until) {
		this.bufferedImages = bufferedImages;
		this.until = until;
	}
	public void tick() {
		long now = System.nanoTime();
		delta += (now-lastTime)/timePerTick;
		time += now-lastTime;
		lastTime = now;
		if(delta>=1) {
			delta--;
		
		}
		if(time>=until)
		{
			counter++;
			if(counter==bufferedImages.length)counter=0;
			time = 0;
		}
	}
	public BufferedImage getCurrentImage() {
		return bufferedImages[counter];
	}
}
