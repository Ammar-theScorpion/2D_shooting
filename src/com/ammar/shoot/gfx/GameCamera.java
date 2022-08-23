package com.ammar.shoot.gfx;

import com.ammar.shoot.creature.Player;
import com.ammar.shoot.game.Game;

public class GameCamera {
	private double xoffset, yoffset;
	private Game game;
	private int prex=1;
	private int prey=1;
	public GameCamera(Game game) {
		this.game=game;
	}
	public void centerOnPlayer(Player p) {
		xoffset = p.getX() -(game.width/2)+(p.getWidth()/2);
		yoffset = (p.getY() )-(game.height/2)+(p.getHeight()/2);
 		if(xoffset<0)
			xoffset=0;
		if(yoffset<0)
			yoffset=0;
		if(xoffset >2560-game.width)//game.world.width
			xoffset=2560-game.width;
		if(yoffset >2560-game.height)//game.world.width
			yoffset=2560-game.height;
	}
	public double getX() {return xoffset;}
	public double getY() {return yoffset;}
	public void preview() {
		xoffset+=prex;
		yoffset+=prey;
		if(xoffset>=2560-Game.WIDTH || xoffset<=0) {
			prex*=-1;
			prey*=-1;
		}
		
	}
}
