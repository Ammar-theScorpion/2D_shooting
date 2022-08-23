package com.ammar.shoot.creature;

 import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ammar.shoot.game.Game;
import com.ammar.shoot.gfx.Animation;
import com.ammar.shoot.gfx.Assets;
import com.ammar.shoot.gfx.Bullets;

public class Player extends Creature{

	private ArrayList<Bullets> bullets;
	private Animation animation;
	public Player(Game game) {
		super( game, 100, 100, 100, 4);
		bullets = new ArrayList<>();
		animation = new Animation(new BufferedImage[] {Assets.player_stand, Assets.player_move_forward_l1, Assets.player_move_forward_l2,Assets.player_move_forward_l1, Assets.player_stand, Assets.player_move_forward_r1, Assets.player_move_forward_r2, Assets.player_move_forward_r1}, 50000000); 
	}

	@Override
	public void render(Graphics g) {
		double dir = mouse();
		
//		renderDark(g);
		renderBullets(g);
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.rotate( dir, (x+ width/2)-game.getGameCamera().getX(), (y+ height/2) -game.getGameCamera().getY());
		g2.drawImage(animation.getCurrentImage(), (int)(x-game.getGameCamera().getX()), (int)(y-game.getGameCamera().getY()), width, height, null);
	}
	
	private void renderBullets(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
	
	private void tickBullets() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	@Override
	public void tick() {
		input();
		move();
		tickBullets();
	
	 
	}
	private double mouse() {
		int xDr=game.getMouseinput().getX()- (int)((x+ width/2)-game.getGameCamera().getX()) ;
		int yDr=game.getMouseinput().getY()- (int)((y+ height/2)-game.getGameCamera().getY()) ;
		double dir=Math.atan2(yDr, xDr);
		if(game.getMouseinput().isLeftPressed()) {
			bullets.add(new Bullets(game, x, y, dir));
			game.getMouseinput().setLeftPressed();
		}
		dir-=1.5;
		return dir;
	}
 
	private void input() {
		if(game.getKeyinput().up) {
			y-=speed;
			animation.tick();
		}
		if(game.getKeyinput().down) {
			y+=speed;
			animation.tick();
		}
		if(game.getKeyinput().left) {
			x-=speed;
		animation.tick();
		}
		if(game.getKeyinput().right) {
			x+=speed;
			animation.tick();
		}
	}
	public float getX() {return x;}
	public float getY() {return y;}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

}
