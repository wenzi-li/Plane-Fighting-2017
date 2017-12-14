package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import MyUtil.GameUtil;

/**
 * �ɻ���
 * @author wenzi
 *
 */


public class Plane {
	//����ɻ���ͼ�Σ����ꣻ
	Image planeImage ;
	double x,y;
	//���巽��
	boolean left,up,right,down;
	//�ɻ����ٶ�
	double speed = 15 ;
	
	
	//�ڴ����л����ɻ�
	public void draw(Graphics g) {
		g.drawImage(planeImage, (int)x, (int)y, null);
		move();
	}
	
	
	//�ü��̿��Ʒɻ��ƶ�
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
	
	//���·�������ɻ���ǰ�ɡ�
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
	
	
	//�ͷŷ�������ɻ�ͣ�¡�
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
	
	
	
	
	//����������϶���꣬���Ʒɻ��ƶ�
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
	
	
	
	
	//ͨ�����������ɻ���ͼ�Σ�λ�ó�ʼ����
	public Plane(String planeimagepath, double x, double y) {
		super();
		this.planeImage = GameUtil.getImage(planeimagepath);
		this.x = x;
		this.y = y;
	}
	
	
	
	public Plane() {
		
	}
	

}
