package game;

import java.awt.Graphics;
import java.awt.Image;

import MyUtil.GameUtil;

/**
 * ʵ�ֱ�ըЧ����
 * @author wenzi
 *
 */

public class Explode {
	
	//��ը������λ�����ꣻ
	double x,y;
	
//	//�Ƿ������ը��
//	private boolean boom = false;
//	
//	public boolean isBoom() {
//		return boom;
//	}
//
//
//	public void setBoom(boolean boom) {
//		this.boom = boom;
//	}


	//��ըͼƬ���飻
	static Image[] images = new Image[8];
	
	static {
		for (int i = 0; i < 8 ;i++) {
			images[i] = GameUtil.getImage("images/explode/big/000.png");
			images[i].getWidth(null);
		}
	}
	
	//������������ͼƬ��ǰ������
	int count;
	
	public void draw(Graphics g) {
		if(count < 8) {
			
			g.drawImage(images[count], (int)x, (int)y, null);
			count++;	
			
		}
		
	}
	
	
	public Explode(double x,double y) {
		this.x = x;
		this.y = y;
		
	}
	

}
