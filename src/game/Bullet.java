package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * �ӵ���
 * @author wenzi
 *
 */

public class Bullet extends GameObiect {
	
	
	
	
	//�Ƿ����
	private boolean shoot = false;


	public Bullet() {
		
	}
	
	
	public boolean isShoot() {
		return shoot;
	}


	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	

	//���ӵ�
	public void drawBullet(Graphics g) {
		if(isShoot()){
			g.drawImage(image, (int)x, (int)y, null);
			bulletMove();
		}
		
	}
	
	
	
	
	//�ӵ��˶�
	public void bulletMove() {
		x += speed;
		
	}
	
	
	
	//�ɻ����
	public void shoot(KeyEvent e) {
			//�����ּ��̵�9�����������
		if(e.getKeyCode() == 105) {
			shoot = true;
		}else {
			shoot = false;
		}
	}
	

//    //�ͷŰ����ӵ�������
//	public void fire(KeyEvent e) {
//		
//		if(e.getKeyCode() == 105) {
//			shoot = true;
//		}
//	}
	
	
	
	//ͨ�����������ӵ���ͼ�Σ�λ�ó�ʼ����
	public Bullet(String bulletImagepath, double bulletSpeed, double bullet_X, double bullet_Y) {
		super();
		this.image = GameUtil.getImage(bulletImagepath);
		this.width = image.getWidth(null);
		this.heigth = image.getHeight(null);
		this.x = bullet_X;
		this.y = bullet_Y;
		this.speed = bulletSpeed;
		}
		

		
	
}
