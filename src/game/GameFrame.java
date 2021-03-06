package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

import javax.security.auth.x500.X500Principal;
import javax.swing.plaf.LabelUI;
import javax.xml.crypto.Data;

import org.omg.CORBA.PUBLIC_MEMBER;

import MyUtil.Constant;
import MyUtil.GameUtil;
import MyUtil.MyFrame;


/**
 * 游戏窗口
 * @author wenzi
 *
 */

public class GameFrame extends MyFrame{
	Map m = new Map("images/space.jpg", 0, 0, 30);

	Plane p1 = new Plane("images/Plane1_128px.png", 0, 300, 200);

	HealthPoint hp1 = new HealthPoint("images/HP30%.png", 10, 60);
	HealthPoint hp2 = new HealthPoint("images/PH50%.png", 10, 60);
	HealthPoint hp3 = new HealthPoint("images/HP80%.png", 10, 60);
	HealthPoint hp4 = new HealthPoint("images/PH100%.png", 10, 60);
	
	Bullet b1 = new Bullet("images/bill_bullet_supermario_48px.png", 10,p1.x,p1.y);
	
	
	//定义一个explode对象；
	Explode e1;
	
	//生成一堆子弹放在数组中储存；
	ArrayList asteroidList = new ArrayList();          //未加泛型；

	//定义游戏开始时间；
	Date startTime;
	//定义游戏结束时间；
	Date endTime1;
	Date endTime2;
	
	//定义time记录飞机被击中的次数；
	int time = 0;
	//画出背景
	public void paint(Graphics g) {
		
		m.drawMap(g);
		
		p1.drawPlane(g);
		hp1.drawhealthPoint(g);
		hp2.drawhealthPoint(g);
		hp3.drawhealthPoint(g);
		hp4.drawhealthPoint(g);
		
		b1.drawBullet(g);
		
		

		//画出陨石
		for(int i = 0; i < asteroidList.size() ; i ++) {
			Asteroid b1 = (Asteroid)asteroidList.get(i);
			b1.drawAsteroid(g);


			//检测陨石和飞机的碰撞；
			boolean peng = b1.getRectangle().intersects(p1.getRectangle());
			


			while(peng) {	
				
				e1 = new Explode(p1.x, p1.y);
				e1.draw(g);
				
	
				//发生碰撞,飞机消失；
				//p1.setHit(true); 
				
				//记录飞机被陨石击中的时间；
				endTime1 = new Date();
				
				time++;
				p1.pointMove();
				
				break;
			}
			

		}

		

		if (p1.isHit()) {
			new Words(g, "GAME OVER!", 40,Constant.GAME_WIDTH/2 - 200, Constant.GAME_HEIGHT/2,Color.black,"old evils");	
			//定义存活时间,以秒为单位；
			long timePeriod1 = (endTime1.getTime() - startTime.getTime())/1000;
			new Words(g,timePeriod1+"s", 30, Constant.GAME_WIDTH/2 , Constant.GAME_HEIGHT/2 + 100, Color.black, "宋体");
			
		}
		

		switch (time) {
		
		case 0:
			new Words(g, "100%", 20, 230, 85, Color.black);
			
			break;
		case 1:
			new Words(g,"75%", 20, 230, 85, Color.black);
			
			p1.setHit(false);      	
			hp4.setShow(false);


			break;
		case 2:
			new Words(g,"50%", 20, 230, 85, Color.black);
			
			p1.setHit(false);          
			hp4.setShow(false);
			hp3.setShow(false);

			break;
		case 3:
			new Words(g,"25%", 20, 230, 85, Color.black);
			
			p1.setHit(false);             
			hp4.setShow(false);
			hp3.setShow(false);
			hp2.setShow(false);

			break;
		case 4:     
			
			p1.setHit(true);
			hp4.setShow(false);
			hp3.setShow(false);
			hp2.setShow(false);
			hp1.setShow(false);
			break;

		default:
			break;
		}

		
		
		
		endTime2 = new Date();
		//显示游戏时长,以秒为单位；
		long timePeriod2 = (endTime2.getTime() - startTime.getTime())/1000;
		new Words(g,timePeriod2+"s", 30, 1200, 90, Color.black,"old evils");
		System.out.println(time);
		

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
		for(int i = 0; i < 2; i++) {
			Asteroid b1 = new Asteroid("images/asteroid_128px.png", Math.random()*3,Math.random()*1000 , Math.random()*500);
			asteroidList.add(b1);
		}

		//记录游戏开始时间；
		startTime = new Date();
	}




	//定义一个内部类——键盘控制；内部类可方便的调用外部类的属性；
	class KeyMonitor extends KeyAdapter {


		@Override
		public void keyPressed(KeyEvent e) {

			//键盘按下时飞机移动；
			//System.out.println("按下："+e.getKeyCode());
			p1.addDirection(e);
			m.addDirection(e);
			b1.shoot(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {

			//键盘释放时飞机停止。
			//System.out.println("释放："+e.getKeyCode());
			p1.stopDirection(e);
			m.stopDirection(e);
		}


	}



	//定义一个内部类——鼠标控制；
	class mouseMonitor extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			//点击并拖动鼠标
			//System.out.println("点击？"+ e.getButton());
			p1.moveMouse(e);
			m.mapMove();

		}


	}



}
