package com.ammar.shoot.entity.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ammar.shoot.game.Game;
import com.ammar.shoot.gfx.Assets;
import com.ammar.shoot.tiles.Tiles;

public class Tree extends StaticEntity{
	
	public Tree(Game game, float x, float y) {
		super(game, x, y);
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree_1, (int)(x-game.getGameCamera().getX()), (int)(y-game.getGameCamera().getY()), 96, 96, null);
	}

	@Override
	public void tick() {
 		
	}//Tree Rock that has no updates///
	


}
