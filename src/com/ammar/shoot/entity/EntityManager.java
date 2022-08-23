package com.ammar.shoot.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import com.ammar.shoot.creature.Enemy;
import com.ammar.shoot.creature.Player;
import com.ammar.shoot.game.Game;

public class EntityManager {

	private Game game;
	public Player player;
 ;
	private ArrayList<Entity> entities;
	
	public EntityManager(Game game, Player player) {
		this.game = game;
		this.player = player;
		entities = new ArrayList<>();
	}
	public void render(Graphics g) {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		player.render(g);
	}
	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		player.tick();
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public void gen(int time, int startX, int startY, int endX, int endY) {
		time/=3;
		int x = 0; 
		int y = 0;
		System.err.println(x+" "+endX);
		while(x>=startX&&x<=endX)
			x=(int)(Math.random()*(Game.WIDTH));
		while(y>=startY&&y<=endY)
			 y=(int)(Math.random()*(Game.HEIGHT));
		for (int i = 0; i < time; i++) {
			entities.add(new Enemy(game, x, y));
		}
	}
}
