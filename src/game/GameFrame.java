package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.plaf.LabelUI;

import MyUtil.GameUtil;
import MyUtil.MyFrame;

/**
 * 游戏窗口
 * @author wenzi
 *
 */

public class GameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/1.jpg");
	
	Plane p1 = new Plane("images/plane3_128px.png", 80, 300);
	//生成子弹；
	ArrayList bulletList = new ArrayList();          //未加泛型；
	
	
	//画出背景
	public void paint(Graphics g) {
		g.drawImage(bg, 0, -280, null);
		p1.draw(g);
		
		
		
		//画出子弹
		for(int i = 0; i < bulletList.size() ; i ++) {
			Bullet b1 = (Bullet)bulletList.get(i);
			b1.drawBullet(g);
			
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		new GameFrame().launchFrame();
	}
	
	
	public  void launchFrame(){
		super.launchFrame();
		
		//增加键盘的监听；
		addKeyListener(new KeyMonitor());
		//增加鼠标监听；
		addMouseListener(new mouseMonitor());
		addMouseMotionListener(new mouseMonitor());
		
		
		//生成子弹；
		for(int i = 0; i < 20; i++) {
			Bullet b1 = new Bullet("images/bill_bullet_supermario_48px.png", Math.random()*7,Math.random()*1300, Math.random()*800);
			bulletList.add(b1);
		}
		
	}
	
	
	
	
	//定义一个内部类——键盘控制；内部类可方便的调用外部类的属性；
	class KeyMonitor extends KeyAdapter {

		
		@Override
		public void keyPressed(KeyEvent e) {
			
			//键盘按下时飞机移动；
			System.out.println("按下："+e.getKeyCode());
			p1.addDirection(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			//键盘释放时飞机停止。
			System.out.println("释放："+e.getKeyCode());
			p1.stopDirection(e);
		}
		
			
	}
	
	
	
	//定义一个内部类——鼠标控制；
	class mouseMonitor extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			//点击并拖动鼠标
			System.out.println("点击？"+ e.getButton());
			p1.moveMouse(e);
			
		}
		

	}
		
	
}
