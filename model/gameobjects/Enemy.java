package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.util.Random;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.view.GameMain;

public abstract class Enemy extends GameObject {

	public Enemy(int x, int y, int width, int height, int life,
			int speed) {
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.x = x - width / 2;
		this.y = y;
		this.life = life;
		this.d=Direction.U;
	}
	@Override
	public void paint(Graphics g) {
		checkBounds();
		move();// 敌机移动

		draw(g);
		if(this.isDead()){
			new Explode(x,y);
		}

	}
	
	protected void move() {
		Direction[] ds = Direction.values();
		if(new Random().nextInt(40)>36){
			this.d = ds[new Random().nextInt(ds.length)];
		}
		switch (d) {
		case L:
			x -= speed;
			break;
		case R:
			x += speed;
			break;
		case U:
			y -= speed;
			break;
		case D:
			y += speed;
			break;
		case LU:
			x -= speed;
			y -= speed;
			break;
		case LD:
			x -= speed;
			y += speed;
			break;
		case RU:
			x += speed;
			y -= speed;
			break;
		case RD:
			x += speed;
			y += speed;
			break;

		}
		if(new Random().nextInt(40)>35){
			this.fire();
		}
	}

	protected abstract void fire();
	protected abstract void draw(Graphics g);

	private void checkBounds() {
		if (x < 0)
			x = 0;

		if (y < 0)
			y = 0;

		if (x + width > GameMain.GAME_WIDTH) {
			x = GameMain.GAME_WIDTH - width;
		}
		if (y + height > GameMain.GAME_HEIGHT) {
			y = GameMain.GAME_HEIGHT - height;
		}
	}

}
