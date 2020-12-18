package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.view.GameMain;

public class LaserBullet extends Bullet {
	private static Image img;
	static{
		try {
			img=ImageIO.read(SilverBullet.class.getClassLoader().getResourceAsStream("images/beam3.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public LaserBullet(int x,int y,boolean good,Direction d){
		super(x,y,5,50,good,20,30,d);
	}
		
	@Override
	public void draw(Graphics g) {
		
		g.drawImage(img, x, y, width, height, null);
	}
	
	
}
