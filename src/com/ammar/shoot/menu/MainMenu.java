package com.ammar.shoot.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.ammar.shoot.game.Game;
import com.ammar.shoot.input.KeyManager;
 
public class MainMenu extends Menu{

	private String[] options = {"play", "help", "about"};
	private int select = 0;
	int timer = 18;
	public MainMenu(KeyManager keyManager) {
		super(keyManager);
		
		 
	}

	@Override
	public void render(Graphics g) {
 		renderText(g, "Last Man", center + 4, 140 + 4, 120, 1, 0);
		renderText(g,"Last Man", center, 140, 120, 1, 0xffffff);
		renderText(g,"A game by Ammar Assi.", center , 188 + 2, 30, 1, 0);
		renderText(g,"A game by Ammar Assi.", center, 188, 30, 1, 0xffffff);
		for (int i = 0; i < options.length; i++) {
			renderText(g,options[i], center + 3, 350 + i * 60 + 3, 50, 1, 0);
			renderText(g,options[i], center, 350 + i * 60, 50, 1, 0xffffff);
		}
	}
	public void renderText(Graphics gg, String text, int x, int y, int size, int style, int color) {
		int r = (color & 0xff0000) >> 16;
		int g = (color & 0xff00) >> 8;
		int b = (color & 0xff);
		Color c = new Color(r, g, b);
		Font f = new Font("Verdana", style, size);
		gg.setColor(c);
		gg.setFont(f);
		gg.drawString(text, x-gg.getFontMetrics().stringWidth(text)/2, y);
	}

	@Override
	public void tick() {
		if(timer>0)timer--;
 		if(keyManager.aDown&& timer == 0) {
 			keyManager.aDown=false;
  			select++;
 			if(select==3)
 				select=0;
 			timer = 10;
 		}
 		else if(keyManager.aUp&& timer == 0) {
 			keyManager.aUp=false;
 			select--;
 		if(select==-1)
				select=2;
 		timer = 10;
 		}
 		if(select==0&&timer==0) {
 			options[0] = "> Play <";
 			if(keyManager.enter)
 				Game.menu = null;
 		 
 			
 		}
		else
			options[0] ="Play";
 		 
 		 if(select==1) {
 			options[1] = "> Help <";
 			if(keyManager.enter)
 				Game.menu = new HelpMenu(keyManager);
 		 }
 		else
			options[1] ="Help";
 		if(select==2)
 			options[2] = "> About <";
 		else
			options[2] ="About";
	}

}
