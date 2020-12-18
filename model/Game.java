package org.leadfar.raiden.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import org.leadfar.raiden.model.gameobjects.Hero;

public class Game {

	private BackGround bg = new BackGround();
	private static final Game game = new Game();
	private boolean up, down, left, right, hit;
	private List<GameObject> gameObjects = new LinkedList<GameObject>();
	private Hero hero;// =new Hero();
	private GameStatus status = GameStatus.WAITTING;// 游戏状态
	public  static int HERO_MAX_LIFE=3; 
	private GameObjectDispatcherThread gdt=new GameObjectDispatcherThread();
	private Game() {
		// gameObjects.add(hero);
	}

	public void init() {
		hero = new Hero();
		
	}

	public void addGameObject(GameObject go) {
		gameObjects.add(go);
	}

	public static Game getInstance() {
		return game;
	}

	public void paint(Graphics g) {

		bg.paint(g);
		move();
		// hero.paint(g);
		System.out.println("游戏物体数量:" + gameObjects.size());
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject go = gameObjects.get(i);
			go.paint(g);
			for (int j = 0; j < gameObjects.size(); j++) {
				GameObject go2 = gameObjects.get(j);
				ColliderChain.getInstance().doCollide(go, go2);
			}

			if (go.isDead()) {
				gameObjects.remove(go);
			}
		}
		
		print(g);
	}

	private void move() {
		if (status == GameStatus.RUNNING) {
			if (up)
				hero.forward();
			if (down)
				hero.back();
			if (left)
				hero.left();
			if (right)
				hero.right();
			if (hit)
				hero.hit();
		}

	}

	// 记录下哪些键被按下了
	public void notifyHeroKeyPressed(int keyCode) {

		switch (keyCode) {
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_CONTROL:
			hit = true;
			break;
		case KeyEvent.VK_ENTER:
			start();break;
		}
	}

	public void notifyHeroKeyReleased(int keyCode) {

		switch (keyCode) {
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_CONTROL:
			hit = false;
			break;
		}
	}

	public void start() {
		if(status==GameStatus.WAITTING){
			status = GameStatus.RUNNING;
			//启动游戏物体派发线程
			//new GameObjectDispatcherThread().start();
			gdt.start();
		}
		if(status==GameStatus.SUCCESS){
			status = GameStatus.RUNNING;
			//启动游戏物体派发线程
			gdt.interrupt();
			gdt=new GameObjectDispatcherThread();
			gdt.start();
		}
	}

	public void fail() {
		status = GameStatus.FAIL;
		
	}

	public void success() {
		status = GameStatus.SUCCESS;
	}
	//向界面输出信息
	private void print(Graphics g){
		Color old=g.getColor();
		g.setColor(Color.WHITE);
		if(status==GameStatus.WAITTING){
			g.setFont(new Font("宋体",Font.ITALIC,30));
			g.drawString("请按下Enter键开始游戏", 200, 300);
		}
		if(status==GameStatus.FAIL){
			g.setFont(new Font("宋体",Font.ITALIC,30));
			g.drawString("Game Over!", 200, 300);
		}
		if(status==GameStatus.SUCCESS){
			g.setFont(new Font("宋体",Font.ITALIC,30));
			g.drawString("您已过关,请按下Enter键继续下一关", 200, 300);
		}
		g.setColor(old);
	}

	public void reborn() {
		HERO_MAX_LIFE--;
		if(HERO_MAX_LIFE==0){
			fail();
		}else{
			hero=new Hero();
		}
	
	}
}
