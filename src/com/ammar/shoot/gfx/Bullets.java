package com.ammar.shoot.gfx;

import java.awt.Graphics;

import com.ammar.shoot.game.Game;

public class Bullets {
	private final int B_WIDTH = 8, B_HTIGHT = 8;
	
	private double x;
	private double y;
	private double xdir;
	private double ydir;
	private Game game;
 	
	public Bullets(Game game, float x, float y, double dir) {
		this.xdir=Math.cos(dir)*8;
		this.ydir=Math.sin(dir)*8;
		this.x=x;
		this.y=y;
		this.game=game;
	 
	}
	public void tick() {
		x+=xdir;
		y+=ydir;
 	}
	public void render(Graphics g) {
		System.err.println(x);
		g.drawImage(Assets.bullets, (int)(x-game.getGameCamera().getX()), (int)(y-game.getGameCamera().getY()), B_WIDTH, B_HTIGHT, null);
	}
}
