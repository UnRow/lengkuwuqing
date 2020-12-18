package org.leadfar.raiden.model;

import org.leadfar.raiden.model.gameobjects.BloodUpObject;
import org.leadfar.raiden.model.gameobjects.Boss;
import org.leadfar.raiden.model.gameobjects.ChangeFireObject;
import org.leadfar.raiden.model.gameobjects.EnemyA;
import org.leadfar.raiden.model.gameobjects.EnemyB;
import org.leadfar.raiden.model.gameobjects.EnemyC;

public class GameObjectDispatcherThread extends Thread {
	private int paintCount=0;
	private boolean flag=false;
	
	
	@Override
	public void interrupt() {
		this.flag=true;
	}


	public void run(){
		while(!flag){
			
			paintCount++;
			if(paintCount==1){
				new EnemyA();
				new EnemyA();
				new EnemyA();
			}
			
			if(paintCount==2){
				//hero.switchFireStrategy();
				new ChangeFireObject();
			}
			
			if(paintCount==4){
				new ChangeFireObject();
			}
			
			
			if(paintCount==8){
				new BloodUpObject();
			}
			
			if(paintCount==10){
				new EnemyB();
				new EnemyC();
				new EnemyB();
			}
			
			if(paintCount==12){
				new ChangeFireObject();
			}
			
			if(paintCount==16){
				new BloodUpObject();
			}
			if(paintCount==2){
				new Boss();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
