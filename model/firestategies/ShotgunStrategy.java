package org.leadfar.raiden.model.firestategies;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.gameobjects.SilverBullet;

public class ShotgunStrategy implements FireStrategy {

	@Override
	public void fire(int x, int y, boolean good) {
		new SilverBullet(x , y,good,Direction.LU);
		new SilverBullet(x , y,good,Direction.U);
		new SilverBullet(x, y,good,Direction.RU);
		

	}

}
