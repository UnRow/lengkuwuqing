package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Direction;

public class SilverBullet extends Bullet {

	private static Image img;
	static{
		try {
			img=ImageIO.read(SilverBullet.class.getClassLoader().getResourceAsStream("images/ballSilver.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SilverBullet(int x,int y,boolean good,Direction d){
		super(x,y,10,10,good,50,30,d);
	}
		
	@Override
	public void draw(Graphics g) {
		
		g.drawImage(img, x, y, width, height, null);
	}
	
	
}
