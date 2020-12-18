package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.view.GameMain;

public class EnemyC extends Enemy {
	private static Image img;
	static{
		try {
			img=ImageIO.read(SilverBullet.class.getClassLoader().getResourceAsStream("images/enemyC.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EnemyC() {
		super(new Random().nextInt(GameMain.GAME_WIDTH-30), new Random().nextInt(300), 35, 35, 100, 10);
	}

	@Override
	protected void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}

	@Override
	protected void fire() {
		if(x>0 && x<260){
			new SilverBullet(x+width/2,y,false,Direction.RD);
		}else if(x>450&& x<GameMain.GAME_WIDTH){
			new SilverBullet(x+width/2,y,false,Direction.LD);
		}else{
			new SilverBullet(x+width/2,y,false,Direction.D);
		}
	}

}
