package com.dragonslayer.rpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.dragonslayer.rpg.display.Display;
import com.dragonslayer.rpg.gfx.Assets;
import com.dragonslayer.rpg.gfx.ImageLoader;
import com.dragonslayer.rpg.gfx.SpriteSheet;

public class Game implements Runnable {
	/*
	 * Game.class is initialized in Launche.class it contains the game loop and
	 * methods responsible for rendering things on the screen
	 */
	private Display display;
	private Thread thread;
	private boolean running = false;

	public int width, height;
	public String title;

	private BufferStrategy bs;
	private Graphics g;

	// Game class constructor
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

	}

	private void init() {
		display = new Display(title, width, height);
		Assets.init();
	}

	private void tick() {

	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, width, height);
		// Draw here

		g.drawImage(Assets.player, 0, 0, null);

		// End drawing
		bs.show();
		g.dispose();
	}

	// called by starting thread;
	public void run() {
		init();

		while (running) {
			tick();
			render();
		}
		stop();
	}

	// starting thread
	public synchronized void start() {
		if (!running) {
			thread = new Thread(this);
			thread.start();
			running = true;
		}
	}

	// stopping thread
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
