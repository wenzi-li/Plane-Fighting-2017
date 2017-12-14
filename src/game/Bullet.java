package game;

import java.awt.Graphics;
import java.awt.Image;
import java.time.Year;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * 子弹类
 * @author wenzi
 *
 */

public class Bullet {
	
	//定义子弹的图形，坐标；
	Image bulletImage ;
	double bullet_X, bullet_Y;
	//定义子弹的方向
	double bulletDirection = Math.random()*Math.PI*2;
	//子弹的速度
	double bulletSpeed ;

	
	
	public Bullet() {
		
	}
	
	
	
	
	
	//画子弹
	public void drawBullet(Graphics g) {
		g.drawImage(bulletImage, (int)bullet_X, (int)bullet_Y, null);
		bulletMove();
	}
	
	
	//子弹运动
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
	
	
	
	
	//通过构造器给子弹的图形，位置初始化；
	public Bullet(String bulletImagepath, double bulletSpeed, double bullet_X, double bullet_Y) {
		super();
		this.bulletImage = GameUtil.getImage(bulletImagepath);
		this.bullet_X = bullet_X;
		this.bullet_Y = bullet_Y;
		this.bulletSpeed = bulletSpeed;
		}
		
	
		
	
}
