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
 * ��Ϸ����
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
	
	
	//����һ��explode����
	Explode e1;
	
	//����һ���ӵ����������д��棻
	ArrayList asteroidList = new ArrayList();          //δ�ӷ��ͣ�

	//������Ϸ��ʼʱ�䣻
	Date startTime;
	//������Ϸ����ʱ�䣻
	Date endTime1;
	Date endTime2;
	
	//����time��¼�ɻ������еĴ�����
	int time = 0;
	//��������
	public void paint(Graphics g) {
		
		m.drawMap(g);
		
		p1.drawPlane(g);
		hp1.drawhealthPoint(g);
		hp2.drawhealthPoint(g);
		hp3.drawhealthPoint(g);
		hp4.drawhealthPoint(g);
		
		b1.drawBullet(g);
		
		

		//������ʯ
		for(int i = 0; i < asteroidList.size() ; i ++) {
			Asteroid b1 = (Asteroid)asteroidList.get(i);
			b1.drawAsteroid(g);


			//�����ʯ�ͷɻ�����ײ��
			boolean peng = b1.getRectangle().intersects(p1.getRectangle());
			


			while(peng) {	
				
				e1 = new Explode(p1.x, p1.y);
				e1.draw(g);
				
	
				//������ײ,�ɻ���ʧ��
				//p1.setHit(true); 
				
				//��¼�ɻ�����ʯ���е�ʱ�䣻
				endTime1 = new Date();
				
				time++;
				p1.pointMove();
				
				break;
			}
			

		}

		

		if (p1.isHit()) {
			new Words(g, "GAME OVER!", 40,Constant.GAME_WIDTH/2 - 200, Constant.GAME_HEIGHT/2,Color.black,"old evils");	
			//������ʱ��,����Ϊ��λ��
			long timePeriod1 = (endTime1.getTime() - startTime.getTime())/1000;
			new Words(g,timePeriod1+"s", 30, Constant.GAME_WIDTH/2 , Constant.GAME_HEIGHT/2 + 100, Color.black, "����");
			
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
		//��ʾ��Ϸʱ��,����Ϊ��λ��
		long timePeriod2 = (endTime2.getTime() - startTime.getTime())/1000;
		new Words(g,timePeriod2+"s", 30, 1200, 90, Color.black,"old evils");
		System.out.println(time);
		

	}



	public static void main(String[] args) {
		new GameFrame().launchFrame();
	}


	public  void launchFrame(){
		super.launchFrame();

		//���Ӽ��̵ļ�����
		addKeyListener(new KeyMonitor());
		//������������
		addMouseListener(new mouseMonitor());
		addMouseMotionListener(new mouseMonitor());


		
		
		//�����ӵ���
		for(int i = 0; i < 2; i++) {
			Asteroid b1 = new Asteroid("images/asteroid_128px.png", Math.random()*3,Math.random()*1000 , Math.random()*500);
			asteroidList.add(b1);
		}

		//��¼��Ϸ��ʼʱ�䣻
		startTime = new Date();
	}




	//����һ���ڲ��ࡪ�����̿��ƣ��ڲ���ɷ���ĵ����ⲿ������ԣ�
	class KeyMonitor extends KeyAdapter {


		@Override
		public void keyPressed(KeyEvent e) {

			//���̰���ʱ�ɻ��ƶ���
			//System.out.println("���£�"+e.getKeyCode());
			p1.addDirection(e);
			m.addDirection(e);
			b1.shoot(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {

			//�����ͷ�ʱ�ɻ�ֹͣ��
			//System.out.println("�ͷţ�"+e.getKeyCode());
			p1.stopDirection(e);
			m.stopDirection(e);
		}


	}



	//����һ���ڲ��ࡪ�������ƣ�
	class mouseMonitor extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			//������϶����
			//System.out.println("�����"+ e.getButton());
			p1.moveMouse(e);
			m.mapMove();

		}


	}



}
