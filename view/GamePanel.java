package org.leadfar.raiden.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.leadfar.raiden.model.BackGround;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.gameobjects.Hero;

public class GamePanel extends JPanel {
		
	@Override
	public void paint(Graphics g) {
		Game.getInstance().paint(g);
	
	}
	
}
