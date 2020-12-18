package org.leadfar.raiden.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import org.leadfar.raiden.model.gameobjects.Hero;
import org.leadfar.raiden.model.gameobjects.Power;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected int speed;
	protected int width;
	protected int height;
	protected boolean dead;
	protected boolean good;
	public boolean isGood() {
		return good;
	}
	protected int life;
	protected Direction d;
	public GameObject(){
		//所有游戏物体产生都需要经过此处 
		//如果不是Hero做此操作
		//if(!(this instanceof Hero)  ){
			Game.getInstance().addGameObject(this);
		//}
	}
	public boolean isDead() {
		return dead;
	}
	public void die(){
		this.dead=true;
	}
	public abstract void paint(Graphics g) ;
	
	public Rectangle getBounds(){
		
		return new Rectangle(x,y,width,height);
		
	}
	
	public int getLife(){
		return life;
	}
	public void addLife(int life){
		this.life+=life;
	}
	public void subLife(int life){
		this.life-=life;
		if(this.life<=0){
			this.die();
		}
	}
}
