package com.ammar.shoot.world;

 import java.awt.Graphics;

import com.ammar.shoot.creature.Player;
import com.ammar.shoot.entity.EntityManager;
import com.ammar.shoot.entity.statics.Rock;
import com.ammar.shoot.game.Game;
import com.ammar.shoot.gfx.Utils;
import com.ammar.shoot.tiles.Tiles;
 
public class World {
	private Game game;
	private int width, height;
	private int[][] tiles;
	private int startX, startY, endX, endY;
	private EntityManager entityManager; 
	public World(Game game, String string) {
		this.game = game;
		entityManager = new EntityManager(game, new Player(game));
		entityManager.addEntity(new Rock(game, 200, 100));
		loadWorld(string);
	}
	
	public void render(Graphics g) {
		startX=Math.max(0, (int)(game.getGameCamera().getX())/Tiles.TILE_WIDTH);
		startY=Math.max(0, (int)(game.getGameCamera().getY())/Tiles.TILE_HEIGHT);

		endX=Math.min(width, (int)(game.getGameCamera().getX()+game.width )/Tiles.TILE_WIDTH+1);
		endY=Math.min(height, (int)(game.getGameCamera().getY()+game.height)/Tiles.TILE_HEIGHT+1);

 		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
 				Tiles.tiles[tiles[i][j]].render(g, (int)(i*Tiles.TILE_WIDTH-game.getGameCamera().getX()), (int)(j*Tiles.TILE_HEIGHT-game.getGameCamera().getY()));				
			}
		}
		entityManager.render(g);
// 		g.setColor(Color.BLACK);
 		 
// 		g.fillRect(startX, startY,  200, endY*Tiles.TILE_HEIGHT);
// 		g.fillRect(startX, startY,  endX*Tiles.TILE_WIDTH, 200);
// 		g.fillRect(endX*Tiles.TILE_WIDTH-200, startY,  200, endY*Tiles.TILE_HEIGHT);
// 		g.fillRect(startX, endY*Tiles.TILE_HEIGHT-200, endX*Tiles.TILE_WIDTH, 200);
	}
	public void loadWorld(String string) {
		String[] stringWorld = Utils.loadFromaFile(string).split("\\s+");
		width  = Integer.parseInt(stringWorld[0]);
		
		height = Integer.parseInt(stringWorld[1]);
		
		tiles  = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
	                tiles[i][j] =Integer.parseInt(stringWorld[i + j * width+2]);
	            }
	    }
	}
	
	public void tick() {
		entityManager.tick();
	}

	public Player getPlayer() {
		return entityManager.player;
	}
	public void generate_enemeies(int time) {
		entityManager.gen(time, startX, startY, endX, endY);
	}
}
