package game;

import java.awt.Graphics;
import java.awt.Image;
import java.time.Year;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * �ӵ���
 * @author wenzi
 *
 */

public class Bullet {
	
	//�����ӵ���ͼ�Σ����ꣻ
	Image bulletImage ;
	double bullet_X, bullet_Y;
	//�����ӵ��ķ���
	double bulletDirection = Math.random()*Math.PI*2;
	//�ӵ����ٶ�
	double bulletSpeed ;

	
	
	public Bullet() {
		
	}
	
	
	
	
	
	//���ӵ�
	public void drawBullet(Graphics g) {
		g.drawImage(bulletImage, (int)bullet_X, (int)bullet_Y, null);
		bulletMove();
	}
	
	
	//�ӵ��˶�
	public void bulletMove() {
		bullet_X += bulletSpeed*Math.cos(Math.random()*bulletDirection);
		bullet_Y += bulletSpeed*Math.sin(Math.random()*bulletDirection);
		
		if(bullet_Y >= Constant.GAME_HEIGHT || bullet_Y <= 30) {
			bulletSpeed = -bulletSpeed;
		}
		if(bullet_X >= Constant.GAME_WIDTH || bullet_X <= 0) {
			bulletSpeed = -bulletSpeed;
		}
	}
	
	
	
	
	//ͨ�����������ӵ���ͼ�Σ�λ�ó�ʼ����
	public Bullet(String bulletImagepath, double bulletSpeed, double bullet_X, double bullet_Y) {
		super();
		this.bulletImage = GameUtil.getImage(bulletImagepath);
		this.bullet_X = bullet_X;
		this.bullet_Y = bullet_Y;
		this.bulletSpeed = bulletSpeed;
		}
		
	
		
	
}
