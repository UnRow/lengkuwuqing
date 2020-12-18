package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.GameObject;

public class Explode extends GameObject {
	private static Image[] imgs=new Image[16];

	private int paintCount=0;
	static{
		
		for(int i=0;i<16;i++){
			try {
				imgs[i]=ImageIO.read(Explode.class.getClassLoader().getResourceAsStream("images/burst"+i+".gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Explode(int x,int y){
		this.x=x;
		this.y=y;
		this.width=32;
		this.height=32;
	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(imgs[paintCount++],x,y,width,height,null);
		if(paintCount>=imgs.length){
			this.die();
		}
		

	}

}
