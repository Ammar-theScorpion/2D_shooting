package com.ammar.shoot.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ammar.shoot.gfx.Assets;

public class Tiles {

	public static final int TILE_WIDTH  = 64,
							TILE_HEIGHT = 64;
	protected BufferedImage image;
	public static Tiles[] tiles=new Tiles[200];
	public static Tiles floor = new Floor(0);
	public static Tiles wall = new Wall(1);

	public Tiles(int id) {
		tiles[id]=this;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(image, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
}
