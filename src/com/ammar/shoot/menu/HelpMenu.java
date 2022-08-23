package com.ammar.shoot.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.ammar.shoot.game.Game;
import com.ammar.shoot.input.KeyManager;

public class HelpMenu extends Menu {

	public HelpMenu(KeyManager input) {
		super(input);
	}

	int timer = 18;
	String options = "> Back <";
	int selected = 0;

	@Override
	public void tick() {
		if (timer > 0) timer--;

		if (selected == 0 && keyManager.enter && timer==0 ) {
		 
			Game.menu = new MainMenu(keyManager);
		}
	 

	}

	public void render(Graphics g) {
		String[] text = { "Hey what is up guys, my name is Ammar, and welcome to a game.", //
				"The game has quite a simple concept. Use WASD",//
				"keys (if that's how you roll) to move your character. Your aim is to",//
				"stay alive as much as you can, whatever you see", //
				"keep shooting whatever you see,keep shooting whatever you see ", //
				"you may encouter many various tyoes of enemies.", //
				"do not let them to catch you, dont know what to say else keep it real baby and enjoy!",//
				"After generating your fancy text symbols, you can copy and paste the \"fonts\" ",//
				"to most websites and text processors. You could use it to generate a fancy Agario name ",//
				"available for breeding, while red means you've already nailed them. ;)",//
				"Text fonts are legible at small sizes and have simpler designs. Text fonts are made to be",//
				"location.",//
				" ", "readable, and are perfect for books, blogs, and any long-form content",//
				"population ever, evolving your nation to the maximum!" };
		for (int i = 0; i < text.length; i++) {
			renderText(g, text[i], center + 2, 30 + i * 30 + 2, 24, 0, 0);
			renderText(g, text[i], center, 30 + i * 30, 24, 0, 0xffffff);
		}
		renderText(g, options, center + 3, 515 + 3, 50, 1, 0);
		renderText(g, options, center, 515, 50, 1, 0xffffff);
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

}
