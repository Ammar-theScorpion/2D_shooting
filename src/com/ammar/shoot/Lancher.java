package com.ammar.shoot;
 

 
import java.awt.Dimension;

import com.ammar.shoot.game.Game;


public class Lancher {
	public static void main(String[] args)
	{
		Dimension s = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
 		new Game((int) s.getWidth(), (int)s.getHeight()).start();
	}

}
