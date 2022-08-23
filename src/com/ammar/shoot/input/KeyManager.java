package com.ammar.shoot.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean keys[];
	public boolean up, down, left, right;
	public boolean aUp, aDown, aLeft, aRight;
	public boolean arrowUp, arrowDown;
	public boolean enter;
	public KeyManager()
	{
		keys = new boolean[256];
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_A];
		enter = keys[KeyEvent.VK_ENTER];
		
		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aRight = keys[KeyEvent.VK_RIGHT];
		aLeft = keys[KeyEvent.VK_LEFT];
		arrowUp = keys[KeyEvent.VK_LEFT];
		arrowDown = keys[KeyEvent.VK_RIGHT];
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] =  true;
		 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
		
	}

	
}
