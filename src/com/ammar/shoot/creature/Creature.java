package com.ammar.shoot.creature;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ammar.shoot.entity.Entity;
import com.ammar.shoot.game.Game;

public abstract class Creature extends Entity{
 	protected int health;
	protected int speed;
	protected int xmove, ymove;
	public Creature( Game game, int x, int y, int health, int speed) {
		super(game, x, y);
		xmove = ymove = 0;
 		this.health = health;
		this.speed = speed;
 	}
	protected void move() {
		
	}
 

}
