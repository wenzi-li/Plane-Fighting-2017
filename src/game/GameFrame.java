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
import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;
import javax.swing.plaf.LabelUI;

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
	Image bg = GameUtil.getImage("images/1.jpg");

	Plane p1 = new Plane("images/plane3_128px.png", 8, 80, 200);

	healthPoint hp1 = new healthPoint("images/HP30%.png", 80, 60);
	healthPoint hp2 = new healthPoint("images/PH50%.png", 80, 60);
	healthPoint hp3 = new healthPoint("images/HP80%.png", 80, 60);
	healthPoint hp4 = new healthPoint("images/PH100%.png", 80, 60);

	
	//����һ���ӵ����������д��棻
	ArrayList bulletList = new ArrayList();          //δ�ӷ��ͣ�


	//����time��¼�ɻ������еĴ�����
	int time = 0;
	//��������
	public void paint(Graphics g) {
		g.drawImage(bg, 0, -280, null);
		p1.drawPlane(g);
		hp1.drawhealthPoint(g);
		hp2.drawhealthPoint(g);
		hp3.drawhealthPoint(g);
		hp4.drawhealthPoint(g);
		
		new Words(g, "100%", 20, 230, 85, Color.black);

		

		//�����ӵ�
		for(int i = 0; i < bulletList.size() ; i ++) {
			Bullet b1 = (Bullet)bulletList.get(i);
			b1.drawBullet(g);


			//����ӵ��ͷɻ�����ײ��
			boolean peng = b1.getRectangle().intersects(p1.getRectangle());


			if(peng) {	
				//������ײ,�ɻ���ʧ��
				p1.setHit(true); 
				
				try {
					
					Thread.sleep(500);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time++;
				p1.pointMove();


			}

		}



		if (p1.isHit()) {
			new Words(g, "GAME OVER!", 40,Constant.GAME_WIDTH/2 - 200, Constant.GAME_HEIGHT/2,Color.black);	
		}



		System.out.println(time);

		switch (time) {
		case 1:
			new Words(g,"75%", 20, 230, 85, Color.black);
			p1.setHit(false);      	
			hp4.setShow(false);
//			try {
//
//				Thread.sleep(200);
//				w.setWrite(false);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

			break;
		case 2:
			new Words(g,"50%", 20, 230, 85, Color.black);
			p1.setHit(false);          
			hp4.setShow(false);
			hp3.setShow(false);
//			try {
//
//				Thread.sleep(200);
//				w.setWrite(false);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			break;
		case 3:
			new Words(g,"25%", 20, 230, 85, Color.black);
			p1.setHit(false);             
			hp4.setShow(false);
			hp3.setShow(false);
			hp2.setShow(false);
//			try {
//
//				Thread.sleep(200);
//				w.setWrite(false);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
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
		for(int i = 0; i < 20; i++) {
			Bullet b1 = new Bullet("images/bill_bullet_supermario_48px.png", Math.random()*4,Math.random()*1300 + 500, Math.random()*800);
			bulletList.add(b1);
		}

	}




	//����һ���ڲ��ࡪ�����̿��ƣ��ڲ���ɷ���ĵ����ⲿ������ԣ�
	class KeyMonitor extends KeyAdapter {


		@Override
		public void keyPressed(KeyEvent e) {

			//���̰���ʱ�ɻ��ƶ���
			//System.out.println("���£�"+e.getKeyCode());
			p1.addDirection(e);

		}

		@Override
		public void keyReleased(KeyEvent e) {

			//�����ͷ�ʱ�ɻ�ֹͣ��
			//System.out.println("�ͷţ�"+e.getKeyCode());
			p1.stopDirection(e);
		}


	}



	//����һ���ڲ��ࡪ�������ƣ�
	class mouseMonitor extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			//������϶����
			//System.out.println("�����"+ e.getButton());
			p1.moveMouse(e);

		}


	}


}
