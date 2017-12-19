package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.time.Year;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * 陨石类
 * @author wenzi
 *
 */

public class Asteroid extends GameObiect {
	
	//定义陨石的方向
	double asteroidDirection = Math.random()*Math.PI*2;


	public Asteroid() {
		
	}
	
	
	//画陨石
	public void drawAsteroid(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		asteroidMove();
	}
	
	
	//陨石运动
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
	
	
	
	
	//通过构造器给陨石的图形，位置初始化；
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
