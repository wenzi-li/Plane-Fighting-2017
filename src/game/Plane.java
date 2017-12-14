package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import MyUtil.GameUtil;

/**
 * 飞机类
 * @author wenzi
 *
 */


public class Plane {
	//定义飞机的图形，坐标；
	Image planeImage ;
	double x,y;
	//定义方向
	boolean left,up,right,down;
	//飞机的速度
	double speed = 15 ;
	
	
	//在窗口中画出飞机
	public void draw(Graphics g) {
		g.drawImage(planeImage, (int)x, (int)y, null);
		move();
	}
	
	
	//用键盘控制飞机移动
	public void move() {
		
		if (left) {
			x -= speed;
		}
		if (right) {
			if(x >= 0) {
				x += speed;	
			}else {
				x = 0;
			}
		}
		if (up) {
			if(y >= 0){
				y -= speed;
			}else {
				y =30;
			}
		}
		if (down) {
			if(y <= 800){
				y += speed;
				}else {
					y = 650;
				}
		}
		
	}
	
	//按下方向键，飞机向前飞。
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37: case 65: case 100:
			left = true ;
			break;
		case 39: case 68: case 102:
			right = true ;
			break;
		case 38: case 87: case 104:
			up = true ;
			break;
		case 40: case 83: case 101:
			down = true ;
			break;
		default:
			break;
		}
	}
	
	
	//释放方向键，飞机停下。
	public void stopDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37: case 65: case 100:
			left = false ;
			break;
		case 39: case 68: case 102:
			right = false ;
			break;
		case 38: case 87: case 104:
			up = false ;
			break;
		case 40: case 83: case 101:
			down = false ;
			break;
		default:
			break;
		}
	}
	
	
	
	
	//按下左键，拖动鼠标，控制飞机移动
	public void moveMouse(MouseEvent e) {
		if (x >= 0){
			x = e.getX();
		}else {
			x = 0;
		}
		if (y >= 30 && y <= 800 ) {
			y = e.getY();
		}
		else if (y < 30) {
			y = 30;
		}
		else if (y > 800) {
			y = 650;
		}
		
	}
	
	
	
	
	//通过构造器给飞机的图形，位置初始化；
	public Plane(String planeimagepath, double x, double y) {
		super();
		this.planeImage = GameUtil.getImage(planeimagepath);
		this.x = x;
		this.y = y;
	}
	
	
	
	public Plane() {
		
	}
	

}
