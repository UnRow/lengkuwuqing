package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.model.GameStatus;
import org.leadfar.raiden.view.GameMain;

public class Power extends GameObject {

	private GameObject go;
	private int maxLife;

	public Power(GameObject go, int x, int y, int maxLife) {
		this.width = 250;
		this.height = 30;
		this.x = x - this.width;

		this.y = y - this.height;
		this.go = go;
		this.maxLife = maxLife;
	}

	@Override
	public void paint(Graphics g) {
		Color old = g.getColor();

		g.setColor(Color.WHITE);

		g.drawRect(x, y, width, height);

		g.setColor(Color.YELLOW);

		int vWidth = (int) (go.getLife() * 1.0 / maxLife * width);
		g.fillRect(x, y, vWidth, height);

		if (this.go instanceof Hero) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("宋体", Font.ITALIC, 30));
			g.drawString("×" + Game.HERO_MAX_LIFE, x + width, y + 30);
		}
		g.setColor(old);
		if (go.isDead()) {
			this.die();
		}

	}

}
