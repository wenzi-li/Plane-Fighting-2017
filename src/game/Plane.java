package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import MyUtil.GameUtil;

/**
 * �ɻ���
 * @author wenzi
 *
 */


public class Plane  extends GameObiect {

	//���巽��
	private boolean left,up,right,down;
	//�Ƿ񱻻���
	private boolean hit = false;
	

	public Plane() {
		
	}
	
	
	//�ڴ����л����ɻ�
	public void drawPlane(Graphics g) {
		
		if(!hit) {
			g.drawImage(image, (int)x, (int)y, null);
			planeMove();
			
		}
		
	}
	
	
	//�ü��̿��Ʒɻ��ƶ�
	public void planeMove() {
		
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
			if(speed < 15){
				speed += 0.5;
			}
			break;
		case 39: case 68: case 102:
			right = true ;
			if(speed < 15){
				speed += 0.5;
				}
			break;
		case 38: case 87: case 104:
			up = true ;
			if(speed < 15){
				speed += 0.5;
				}
			break;
		case 40: case 83: case 101:
			down = true ;
			if(speed < 15){
				speed += 0.5;
				}
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
			speed = 8;
			break;
		case 39: case 68: case 102:
			right = false ;
			speed = 8;
			break;
		case 38: case 87: case 104:
			up = false ;
			speed = 8;
			break;
		case 40: case 83: case 101:
			down = false ;
			speed = 8;
			break;
		default:
			break;
		}
	}
	
	
	
	
	//�������������϶���꣬���Ʒɻ��ƶ�
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
	
	
	//�ƶ��ɻ��ĵ���ʶλ�ã�
	public void pointMove(  ) {
	/*	while((int)x != x0) {
			if((int)x > x0) {
				for(int i = (int)x; i > x0; i--) {
					x-=1000;
				}
			}
			else {
				for(int i = (int)x; i < x0; i++) {
					
				}
			}
		}
		while((int)y != y0) {
			if((int)y > y0) {
				for(int i = (int)y; i != y0; i--) {
					y = i;
				}
			}
			else {
				for(int i = (int)y; i != y0; i++) {
					y = i;
				}
			}
		}
		*/
		x = 80;
		y = 100;
		
	}
	
	
	
	public boolean isHit() {
		return hit;
	}


	public void setHit(boolean hit) {
		this.hit = hit;
	}


	//ͨ�����������ɻ���ͼ�Σ�λ�ó�ʼ����
	public Plane(String planeImagepath, double planeSpeed, double plane_X, double plane_Y) {
		super();
		this.image = GameUtil.getImage(planeImagepath);
		this.speed = planeSpeed;
		this.width = image.getWidth(null);
		this.heigth = image.getHeight(null);
		this.x = plane_X;
		this.y = plane_Y;
	}
	
	

}
