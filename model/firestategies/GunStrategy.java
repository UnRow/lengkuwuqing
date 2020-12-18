package org.leadfar.raiden.model.firestategies;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.gameobjects.LaserBullet;
import org.leadfar.raiden.model.gameobjects.SilverBullet;

public class GunStrategy implements FireStrategy {

	@Override
	public void fire(int x, int y, boolean good) {
		new SilverBullet(x , y,good,Direction.LU);
		new LaserBullet(x , y,good,Direction.U);
		new SilverBullet(x, y,good,Direction.RU);
		

	}

}
