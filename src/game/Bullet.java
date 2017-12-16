package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.time.Year;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * 子弹类
 * @author wenzi
 *
 */

public class Bullet extends GameObiect {
	
	//定义子弹的方向
	double bulletDirection = Math.random()*Math.PI*2;


	public Bullet() {
		
	}
	
	
	//画子弹
	public void drawBullet(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		bulletMove();
	}
	
	
	//子弹运动
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
	
	
	
	
	//通过构造器给子弹的图形，位置初始化；
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
