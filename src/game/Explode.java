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
	//��ըͼƬ���飻
	static Image[] images = new Image[10];
	static {
		for (int i = 0; i < 10 ;i++) {
			images[i] = GameUtil.getImage("images/e"+(i+1+".jpg"));
			images[i].getWidth(null);
		}
	}
	//������������ͼƬ��ǰ������
	int count;
	
	
	public void draw(Graphics g) {
		if(count <= 10) {
			g.drawImage(images[count], (int)x, (int)y, null);
			count++;	
		}
		
	}
	
	
	public Explode(double x,double y) {
		this.x = x;
		this.y = y;
		
	}
	

}
