package com.dragonslayer.rpg.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	/*
	 * class taking in constructor a BufferedImage and then returning it's subimage
	 * of the given x and y coordinates and width and height from that point.
	 */
	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet){
		this.sheet=sheet;
	}

	public BufferedImage crop(int x, int y, int width,int height){
		return sheet.getSubimage(x, y, width, height);
	}
}
