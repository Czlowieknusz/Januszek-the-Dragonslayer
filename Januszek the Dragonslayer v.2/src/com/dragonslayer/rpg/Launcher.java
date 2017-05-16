package com.dragonslayer.rpg;


public class Launcher {
	/*
	 * class that defines size of the game window and initiates the Game
	 */
	private static int WIDTH = 1024;
	private static int HEIGHT = WIDTH/16*9;
	
	public static void  main(String[] args){
		Game game = new Game("Januszek the Dragonslayer", WIDTH,HEIGHT);
		game.start();
	}
}
