package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.BackGround;
import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.view.GameMain;

public class Boss extends Enemy {
	private Image img = null;
	private int paintCount = 0;

	public Boss() {
		super(GameMain.GAME_WIDTH / 2 - 150, 10, 300, 177, 1000, 5);
		try {

			img = ImageIO.read(BackGround.class.getClassLoader()
					.getResourceAsStream("images/bossA.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Power(this,255,40,this.life);
	}

	@Override
	public void die() {
		this.dead=true;
		
		Game.getInstance().success();
	}

	@Override
	protected void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		if(this.isDead()){
			
			for(int i=0;i<50;i++){
				new Explode(new Random().nextInt(GameMain.GAME_WIDTH),new Random().nextInt(GameMain.GAME_HEIGHT));
			}
		}

	}

	@Override
	protected void fire() {
		paintCount++;
		if (paintCount == 10) {
			new LaserBullet(x + width / 2 - 10, y, false, Direction.D);
			new LaserBullet(x + width / 2, y, false, Direction.D);
			new LaserBullet(x + width / 2 + 10, y, false, Direction.D);
			paintCount = 0;
		} else {
			new LittleBullet(x + width / 2 - 10, y, false, Direction.D);
			new LittleBullet(x + width / 2 + 10, y, false, Direction.D);
		}

	}

	protected void move() {

		if (x <= 0) {
			this.d = Direction.R;
		}
		if (x + this.width >= GameMain.GAME_WIDTH) {
			this.d = Direction.L;
		}

		switch (d) {
		case L:
			x -= speed;
			break;
		case R:
			x += speed;
			break;
		default:
			d=Direction.L;
		}
		if(new Random().nextInt(40)>30){
			this.fire();
		}
	}

}
