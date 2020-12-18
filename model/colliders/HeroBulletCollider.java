package org.leadfar.raiden.model.colliders;

import org.leadfar.raiden.model.Collider;
import org.leadfar.raiden.model.ColliderChain;
import org.leadfar.raiden.model.GameObject;
import org.leadfar.raiden.model.gameobjects.BloodUpObject;
import org.leadfar.raiden.model.gameobjects.Bullet;
import org.leadfar.raiden.model.gameobjects.Hero;

public class HeroBulletCollider implements Collider {

	@Override
	public void collide(GameObject go1, GameObject go2,ColliderChain chain) {
		
		if(go1 instanceof Hero && go2 instanceof Bullet && !go1.isDead() && !go2.isDead() && !go2.isGood()){
			
			if(!go1.getBounds().intersection(go2.getBounds()).isEmpty()){
				Hero h=(Hero)go1;
				h.subLife(go2.getLife());
				go2.die();
			}
			chain.doCollide(go1, go2);
		}else if(go2 instanceof Hero && go1 instanceof Bullet){
			
			collide(go2,go1,chain);
		}else{
			chain.doCollide(go1, go2);
		}

	}

}
