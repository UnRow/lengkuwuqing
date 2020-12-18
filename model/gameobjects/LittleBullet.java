package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import org.leadfar.raiden.model.Direction;

public class LittleBullet extends Bullet {

	public LittleBullet(int x,int y,boolean good,Direction d){
		super(x,y,10,10,good,40,50,d);
	}
		
	@Override
	public void draw(Graphics g) {
		
		Color old=g.getColor();
		g.setColor(Color.RED);
		
		g.fillOval(x, y, width, height);
		
		g.setColor(old);
	}
	
	
}
