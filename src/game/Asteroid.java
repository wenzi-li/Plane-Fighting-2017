package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.time.Year;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * ��ʯ��
 * @author wenzi
 *
 */

public class Asteroid extends GameObiect {
	
	//������ʯ�ķ���
	double asteroidDirection = Math.random()*Math.PI*2;


	public Asteroid() {
		
	}
	
	
	//����ʯ
	public void drawAsteroid(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		asteroidMove();
	}
	
	
	//��ʯ�˶�
	public void asteroidMove() {
		x += speed*Math.cos(Math.random()*asteroidDirection);
		y += speed*Math.sin(Math.random()*asteroidDirection);
		
		if(y >= Constant.GAME_HEIGHT - heigth || y <= 30) {
			speed = -speed;
		}
		if(x >= Constant.GAME_WIDTH - heigth || x <= 10) {
			speed = -speed;
		}
	}
	
	
	
	
	//ͨ������������ʯ��ͼ�Σ�λ�ó�ʼ����
	public Asteroid(String asteroidImagepath, double asteroidSpeed, double asteroid_X, double asteroid_Y) {
		super();
		this.image = GameUtil.getImage(asteroidImagepath);
		this.width = image.getWidth(null);
		this.heigth = image.getHeight(null);
		this.x = asteroid_X;
		this.y = asteroid_Y;
		this.speed = asteroidSpeed;
		}
		

		
	
}
