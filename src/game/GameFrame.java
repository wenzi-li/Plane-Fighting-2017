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
 * ��Ϸ����
 * @author wenzi
 *
 */

public class GameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/1.jpg");
	
	Plane p1 = new Plane("images/plane3_128px.png", 80, 300);
	//�����ӵ���
	ArrayList bulletList = new ArrayList();          //δ�ӷ��ͣ�
	
	
	//��������
	public void paint(Graphics g) {
		g.drawImage(bg, 0, -280, null);
		p1.draw(g);
		
		
		
		//�����ӵ�
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
		
		//���Ӽ��̵ļ�����
		addKeyListener(new KeyMonitor());
		//������������
		addMouseListener(new mouseMonitor());
		addMouseMotionListener(new mouseMonitor());
		
		
		//�����ӵ���
		for(int i = 0; i < 20; i++) {
			Bullet b1 = new Bullet("images/bill_bullet_supermario_48px.png", Math.random()*7,Math.random()*1300, Math.random()*800);
			bulletList.add(b1);
		}
		
	}
	
	
	
	
	//����һ���ڲ��ࡪ�����̿��ƣ��ڲ���ɷ���ĵ����ⲿ������ԣ�
	class KeyMonitor extends KeyAdapter {

		
		@Override
		public void keyPressed(KeyEvent e) {
			
			//���̰���ʱ�ɻ��ƶ���
			System.out.println("���£�"+e.getKeyCode());
			p1.addDirection(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			//�����ͷ�ʱ�ɻ�ֹͣ��
			System.out.println("�ͷţ�"+e.getKeyCode());
			p1.stopDirection(e);
		}
		
			
	}
	
	
	
	//����һ���ڲ��ࡪ�������ƣ�
	class mouseMonitor extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			//������϶����
			System.out.println("�����"+ e.getButton());
			p1.moveMouse(e);
			
		}
		

	}
		
	
}
