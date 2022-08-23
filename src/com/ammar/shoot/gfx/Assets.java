package com.ammar.shoot.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage floor;
	public static BufferedImage rock_1;
	public static BufferedImage rock_2;
	public static BufferedImage bullets;

	public static BufferedImage player_stand;
	public static BufferedImage player_move_forward_r1;
	public static BufferedImage player_move_forward_r2;
	public static BufferedImage player_move_forward_l1;
	public static BufferedImage player_move_forward_l2;


	public static BufferedImage enemy_stand;
	public static BufferedImage enemy_move_forward_r1;
	public static BufferedImage enemy_move_forward_r2;
	public static BufferedImage enemy_move_forward_l1;
	public static BufferedImage enemy_move_forward_l2;
	

	public static BufferedImage enemy_hit;
	public static BufferedImage enemy_eat_1;
	public static BufferedImage enemy_eat_2;
	public static BufferedImage enemy_eat_3;
	public static BufferedImage enemy_hit_0;

	public static BufferedImage tree_0;
	public static BufferedImage tree_1;
	public static BufferedImage tree_2;
	public static BufferedImage tree_3;
	public static BufferedImage tree_4;
	
	public static BufferedImage wall;

	public static void init() {
		SpriteSheet spriteSheet = new SpriteSheet(Loader.imageLoader("/texture/floorshhet.jpg"));
		floor = spriteSheet.crop(0, 988, 310, 310);
		
		SpriteSheet spriteSheet2 = new SpriteSheet(Loader.imageLoader("/texture/shootsprite.png"));
		player_stand           = spriteSheet2.crop(6, 0, 40, 40);
		player_move_forward_r1 = spriteSheet2.crop(50, 0, 40, 40);
		player_move_forward_r2 = spriteSheet2.crop(100, 0, 40, 40);
		player_move_forward_l1 = spriteSheet2.crop(50, 50, 40, 40);
		player_move_forward_l2 = spriteSheet2.crop(100, 50, 40, 40);
		
		enemy_stand           = spriteSheet2.crop(0, 150, 50, 30);
		enemy_move_forward_r1 = spriteSheet2.crop(50, 150, 50, 40);
		enemy_move_forward_r2 = spriteSheet2.crop(100, 150, 50, 40);
		enemy_move_forward_l1 = spriteSheet2.crop(50, 195, 50, 50);
		enemy_move_forward_l2 = spriteSheet2.crop(100, 195, 50, 40);
		
		enemy_eat_1 = spriteSheet2.crop(0, 250, 45, 40);
		enemy_eat_2 = spriteSheet2.crop(45, 250, 45, 30);
		enemy_eat_3 = spriteSheet2.crop(92, 250, 45, 30);
		SpriteSheet spriteSheet4 = new SpriteSheet(Loader.imageLoader("/texture/tree.png"));

		tree_0 = spriteSheet4.crop(500, 595, 55, 65);
		tree_1 = spriteSheet4.crop(70, 100, 39, 62);
		tree_2 = spriteSheet4.crop(136, 350, 60, 60);
		wall = spriteSheet.crop(329, 658, 309, 308);

		bullets                = spriteSheet2.crop(8, 96, 9, 20);
		
		SpriteSheet spriteSheet3 = new SpriteSheet(Loader.imageLoader("/texture/stons.png"));
		rock_1 = spriteSheet3.crop(0, 117, 117, 120);
		rock_2 = spriteSheet3.crop(240, 412, 120, 70);
	}
}
