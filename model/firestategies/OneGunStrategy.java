package org.leadfar.raiden.model.firestategies;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.gameobjects.LittleBullet;

public class OneGunStrategy implements FireStrategy {

	@Override
	public void fire(int x, int y, boolean good) {
		
		new LittleBullet(x,y,good,Direction.U);

	}

}
