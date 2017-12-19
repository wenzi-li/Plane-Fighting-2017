package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import MyUtil.Constant;
import MyUtil.GameUtil;

/**
 * 子弹类
 * @author wenzi
 *
 */

public class Bullet extends GameObiect {
	
	
	
	
	//是否射击
	private boolean shoot = false;


	public Bullet() {
		
	}
	
	
	public boolean isShoot() {
		return shoot;
	}


	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	

	//画子弹
	public void drawBullet(Graphics g) {
		if(isShoot()){
			g.drawImage(image, (int)x, (int)y, null);
			bulletMove();
		}
		
	}
	
	
	
	
	//子弹运动
	public void bulletMove() {
		x += speed;
		
	}
	
	
	
	//飞机射击
	public void shoot(KeyEvent e) {
			//按数字键盘的9键进行射击；
		if(e.getKeyCode() == 105) {
			shoot = true;
		}else {
			shoot = false;
		}
	}
	

//    //释放按键子弹发出；
//	public void fire(KeyEvent e) {
//		
//		if(e.getKeyCode() == 105) {
//			shoot = true;
//		}
//	}
	
	
	
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
