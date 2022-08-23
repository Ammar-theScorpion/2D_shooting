package com.ammar.shoot.game;

 import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.ammar.shoot.Display;
import com.ammar.shoot.gfx.Assets;
import com.ammar.shoot.gfx.GameCamera;
import com.ammar.shoot.input.KeyManager;
import com.ammar.shoot.input.MouseManager;
import com.ammar.shoot.menu.MainMenu;
import com.ammar.shoot.menu.Menu;
import com.ammar.shoot.world.World;

public class Game implements Runnable{
	public static int WIDTH, HEIGHT;
	
	private Display display;
	private Thread thread;
	private BufferStrategy bfs;
	private Graphics g;
	private boolean running;
 
  	public static int xof;
 	public static int yof;
 	private World world;
 	private KeyManager keyManager;
 	public int width, height;
 	public static Menu menu;
 	private MouseManager mouseManager;
 	private GameCamera gameCamera;
	public Game(int width, int height) {
		this.height = height;
		this.width = width;
		WIDTH = width;
		HEIGHT = height;
		Assets.init();
 		display = new Display(width, height);
 		keyManager = new KeyManager();
 		menu = new MainMenu(keyManager);
 		mouseManager = new MouseManager();
 		world = new World(this, "res/world/world.txt");
 		display.getCanvas().addKeyListener(keyManager);
 		display.getFrame().addKeyListener(keyManager);
 		display.getCanvas().addMouseListener(mouseManager);
 		display.getFrame().addMouseListener(mouseManager);
 		display.getCanvas().addMouseMotionListener(mouseManager);
 		display.getFrame().addMouseMotionListener(mouseManager);
 		gameCamera= new GameCamera(this);
 
	}
	@Override
	public void run() {
		int FPS = 60;
		double timePerTick = 1000000000/FPS;
		
		long lastTime = System.nanoTime();
		double delta=0;
		double time=0;
		int  counter = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta +=(now-lastTime)/timePerTick;
			time += now-lastTime;
			lastTime = now;
			if(delta>=1)
			{
				render();
				tick();
				delta--;
				
			}
			if(time>=1000000000) {
				time=0;
				counter++;
				world.generate_enemeies(counter);
				
			}
		}
		stop();
	}
	private void render() {
		bfs = display.getCanvas().getBufferStrategy();
		if(bfs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bfs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		world.render(g);
		if(menu!=null)menu.render(g);
	 
 		bfs.show();
		g.dispose();
	}
	private void tick() {
		keyManager.tick();
		world.tick();
		if(menu!=null) {
			menu.tick();
			gameCamera.preview();
		}
		else 
			gameCamera.centerOnPlayer(world.getPlayer());
 	}
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	  
	}
	public KeyManager getKeyinput() {
		return keyManager;
	}
	private synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	public MouseManager getMouseinput() {
		
		return mouseManager;
	}
	public GameCamera getGameCamera() {	return gameCamera;} 
	public World getWorld() {return world;}
}