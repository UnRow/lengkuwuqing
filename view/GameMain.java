package org.leadfar.raiden.view;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.leadfar.raiden.model.Game;

public class GameMain extends JFrame {
	public static final int GAME_WIDTH = 792;
	public static final int GAME_HEIGHT = 547;

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar mnuSystem = null;
	private JMenu mnuOperate = null;

	/**
	 * This method initializes mnuSystem
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getMnuSystem() {
		if (mnuSystem == null) {
			mnuSystem = new JMenuBar();
			mnuSystem.add(getMnuOperate());
		}
		return mnuSystem;
	}

	/**
	 * This method initializes mnuOperate
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnuOperate() {
		if (mnuOperate == null) {
			mnuOperate = new JMenu();
			mnuOperate.setText("系统");
		}
		return mnuOperate;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameMain thisClass = new GameMain();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				center(thisClass);
			}
		});
	}

	public static void center(Container c) {
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();

		c.setLocation((width - c.getWidth()) / 2, (height - c.getHeight()) / 2);
	}

	/**
	 * This is the default constructor
	 */
	public GameMain() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getMnuSystem());
		this.setTitle("雷电一族");
		this.setResizable(false);
		this.setBounds(new Rectangle(0, 0, 800, 600));
		this.addKeyListener(new java.awt.event.KeyAdapter() {   
			public void keyReleased(java.awt.event.KeyEvent e) {    
				Game.getInstance().notifyHeroKeyReleased(e.getKeyCode());
			}
			public void keyPressed(java.awt.event.KeyEvent e) {
				
				//System.out.println(e.getKeyCode());
				Game.getInstance().notifyHeroKeyPressed(e.getKeyCode());

				// repaint();//留出程序可以主动调用paint的机会
				// 对于awt repaint(通知EDT重绘)->update->paint()
				// 对于Swing repaint(通知EDT重绘)->paint();
			}
		});
		Game.getInstance().init();
		new Thread() {
			public void run() {
				while (true) {
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new GamePanel(); // 替换成我们程序可实现干预的自定义的Panel
			jContentPane.setLayout(null);
		}
		return jContentPane;
	}

}
