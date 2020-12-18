package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.view.GameMain;

public abstract class Bullet extends GameObject {

	public Bullet(int x, int y, int width, int height, boolean good, int life,
			int speed) {
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.x = x - width / 2;
		this.y = y;
		this.good = good;
		this.life = life;
		this.d=Direction.U;

	}
	public Bullet(int x, int y, int width, int height, boolean good, int life,
			int speed,Direction d) {
		this(x,y,width,height,good,life,speed);
		this.d=d;

	}

	@Override
	public void paint(Graphics g) {
		checkBounds();
		move();// 子弹移动

		draw(g);
	}

	private void move() {
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
	}

	protected abstract void draw(Graphics g);

	private void checkBounds() {
		if (x < 0 || x > GameMain.GAME_WIDTH || y < 0
				|| y > GameMain.GAME_HEIGHT) {
			dead = true;
		}
	}

}
