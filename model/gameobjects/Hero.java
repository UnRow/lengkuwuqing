package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.BackGround;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.model.firestategies.OneGunStrategy;
import org.leadfar.raiden.utils.FireStrategyConfiguration;
import org.leadfar.raiden.view.GameMain;

public class Hero extends GameObject {
	private Image img = null;
	private int hitCount=3;
	private int fireStep=0;
	private FireStrategy fireStrategy;
	public Hero() {
		this.width = 40;
		this.height = 36;
		this.speed = 10;
		this.life=200;
		x = (GameMain.GAME_WIDTH - width) / 2;
		y = GameMain.GAME_HEIGHT - height - 20;
		try {

			img = ImageIO.read(BackGround.class.getClassLoader()
					.getResourceAsStream("images/this.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Power(this,GameMain.GAME_WIDTH-50,GameMain.GAME_HEIGHT-20,this.life);
		
		switchFireStrategy();
	}
	
	
	
	
	
	public void left() {

		x -= speed;
	}

	public void right() {
		x += speed;
	}

	public void forward() {

		y -= speed;
	}

	public void back() {
		y += speed;

	}
	public void addLife(int life){
		this.life+=life;
		if(this.life>=5000){
			this.life=5000;
		}
	}
	
	@Override
	public void die() {
		
		this.dead=true;
		Game.getInstance().reborn();
	}





	public void switchFireStrategy(){
		this.fireStep+=1;
		FireStrategy f=FireStrategyConfiguration.getStrategyInstance("F"+fireStep);
		if(f!=null){
			this.fireStrategy=f;
		}
	}

	public void hit() {
		
		if(hitCount--==0){
			fireStrategy.fire(x+width/2, y, true);
			hitCount=3;
		}
	}

	public void paint(Graphics g) {
		checkBounds();
//		Color old = g.getColor();
//		g.setColor(Color.GRAY);
//
//		g.fill3DRect(x, y, width, height, true);
//
//		g.setColor(old);
		g.drawImage(img, x, y, width,height, null);
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
