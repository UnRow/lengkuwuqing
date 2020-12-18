package org.leadfar.raiden.model.firestategies;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.gameobjects.LaserBullet;

public class DoubleGunStrategy implements FireStrategy {

	@Override
	public void fire(int x, int y, boolean good) {
		
		new LaserBullet(x-30, y,good,Direction.U);
		new LaserBullet(x+30, y,good,Direction.U);

	}

}
