package org.leadfar.raiden.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.view.GameMain;

public class BackGround {
	private Image img = null;
	private int vy;
	public BackGround() {
		try {

			img = ImageIO.read(BackGround.class.getClassLoader()
					.getResourceAsStream("images/bg.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		if(vy>GameMain.GAME_HEIGHT) vy=0;
		g.drawImage(img, 0, vy, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT, null);
		
		g.drawImage(img, 0, -(GameMain.GAME_HEIGHT-vy), GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT, null);
		vy+=5;
	}
}
