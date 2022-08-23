package com.ammar.shoot.creature;

 import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
 
import com.ammar.shoot.game.Game;
import com.ammar.shoot.gfx.Animation;
import com.ammar.shoot.gfx.Assets;
  
public class Enemy extends Creature{

 	private Animation animation;
 	private Animation animation_t;
 	private Animation animation_eat;
 	public Enemy(Game game, int x, int y) {
		super( game, x, y, 100, 4);
 		animation = new Animation(new BufferedImage[] {Assets.enemy_stand, Assets.enemy_move_forward_l1, Assets.enemy_move_forward_l2,  Assets.enemy_move_forward_l1, Assets.enemy_stand,Assets.enemy_move_forward_r1, Assets.enemy_move_forward_r2,Assets.enemy_move_forward_r1}, 80000000);
 		animation_eat = new Animation(new BufferedImage[] {Assets.enemy_eat_1, Assets.enemy_eat_2, Assets.enemy_eat_3}, 200000000);
 		animation_t = animation;
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		double d = mouse();
		g2.rotate( d, (x+ width/2)-game.getGameCamera().getX(), (y+ height/2) -game.getGameCamera().getY());
		g2.drawImage(animation.getCurrentImage(), (int)(x-game.getGameCamera().getX()), (int)(y-game.getGameCamera().getY()), width, height, null);
	 
	}
	
	private double mouse() {
		double xDr=game.getWorld().getPlayer().getX() - (int)((x+ width/2)-game.getGameCamera().getX()) ;
		double yDr=game.getWorld().getPlayer().getY()- (int)((y+ height/2)-game.getGameCamera().getY()) ;
		double dir=Math.atan2(yDr*2, xDr*2);
		 
		dir-=1.5;
		return dir;
	}
	 
	@Override
	public void tick() {
		
		double distance = Math.sqrt(Math.pow(game.getWorld().getPlayer().getX()-x,2) +
									Math.pow(game.getWorld().getPlayer().getY()-y,2));
		double distanceX = game.getWorld().getPlayer().getX()-x;
		double distanceY = game.getWorld().getPlayer().getY()-y;
		
		if(distance<15) {
			animation_eat.tick();
 		}else {
			x+=(distanceX/distance)*2;
			y+=(distanceY/distance)*2;
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
