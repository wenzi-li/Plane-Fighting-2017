package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.time.Year;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * �ӵ���
 * @author wenzi
 *
 */

public class Bullet extends GameObiect {
	
	//�����ӵ��ķ���
	double bulletDirection = Math.random()*Math.PI*2;


	public Bullet() {
		
	}
	
	
	//���ӵ�
	public void drawBullet(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		bulletMove();
	}
	
	
	//�ӵ��˶�
	public void bulletMove() {
		x += speed*Math.cos(Math.random()*bulletDirection);
		y += speed*Math.sin(Math.random()*bulletDirection);
		
		if(y >= Constant.GAME_HEIGHT - heigth || y <= 30) {
			speed = -speed;
		}
		if(x >= Constant.GAME_WIDTH - heigth || x <= 10) {
			speed = -speed;
		}
	}
	
	
	
	
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
