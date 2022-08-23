package com.ammar.shoot.menu;

import java.awt.Graphics;

import com.ammar.shoot.game.Game;
import com.ammar.shoot.input.KeyManager;

public abstract class Menu {
	protected int center = Game.WIDTH/2;

	protected KeyManager keyManager;
	public Menu(KeyManager keyManager) {this.keyManager = keyManager;}
	public abstract void render(Graphics g);
	public abstract void tick();
}
