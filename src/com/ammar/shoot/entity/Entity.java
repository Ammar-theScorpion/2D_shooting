package com.ammar.shoot.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ammar.shoot.game.Game;

public abstract class Entity {
	
	protected int width = 42, height = 42;
	protected Game game;
	protected float x, y;
	public Entity(Game game, float x, float y) {
		this.game = game;
		this.x=x;
		this.y=y;
	}

	public abstract void render(Graphics g);
	public abstract void tick();

}
