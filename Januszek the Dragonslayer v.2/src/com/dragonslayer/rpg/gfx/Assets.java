package com.dragonslayer.rpg.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 268, height = 268;
	public static BufferedImage player, RU, LD, RD;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite.png"));

		player = sheet.crop(0, 0, width, height);
		RU = sheet.crop(width, 0, width, height);
		LD = sheet.crop(0, height, width, height);
		RD = sheet.crop(width, height, width, height);
	}
}
