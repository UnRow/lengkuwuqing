package org.leadfar.raiden.model;

public interface Collider {

	public void collide(GameObject go1,GameObject go2,ColliderChain chain);
}
