package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.view.GameMain;

public class ChangeFireObject extends GameObject {
	private Color c = Color.RED;

	public ChangeFireObject() {
		Random r = new Random();
		this.width = r.nextInt(50) + 50;
		this.height = r.nextInt(50) + 50;
		this.x = r.nextInt(GameMain.GAME_WIDTH - this.width) + this.width;
		this.y = r.nextInt(GameMain.GAME_HEIGHT - this.height) + this.height;
		this.speed = 10;
		this.d=Direction.U;
	}

	@Override
	public void paint(Graphics g) {
		checkBounds();
		move();
		Color old = g.getColor();

		if (c == Color.RED) {
			c = Color.GREEN;
		} else {
			c = Color.RED;
		}
		g.setColor(c);
		g.fillOval(x, y, width, height);
		g.setColor(old);

	}

	private void move() {
		// 随机取得方向
		Direction[] ds = Direction.values();
		if(new Random().nextInt(40)>30){
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

	}
	
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
