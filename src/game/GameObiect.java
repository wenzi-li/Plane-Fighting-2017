package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import MyUtil.GameUtil;

/**
 * ��Ϸ�г��ֵ����壬��ɻ����ӵ��ȣ�
 * @author wenzi
 *
 */

public class GameObiect {
	
	    //����ͼ�Σ�
		Image image ;
		//�������ꣻ
		double x,y;
		//�ٶ�
		double speed ;
		//�������ھ��εĿ�Ⱥ͸߶ȣ�
		double width,heigth;
		
		
		public GameObiect() {
			
		}
		
		
		//��ȡ�������ڵľ��Σ��Ա������ײ��⣻
		public Rectangle getRectangle () {
			return new Rectangle((int)x, (int)y, (int)width, (int)heigth);
			}
		
		
		//�ڴ����л�������
		public void draw(Graphics g) {
		}
		
		
		//�����ƶ�
		public void objectMove() {
			
		}
		
		
		//ͨ���������������ͼ�Σ�λ�ó�ʼ����
		public GameObiect(String imagepath, double speed, double x, double y) {
			super();
			this.image = GameUtil.getImage(imagepath);
			this.width = image.getWidth(null);
			this.heigth = image.getHeight(null);
			this.x = x;
			this.y = y;
			this.speed = speed;
			}
		
		
		

}
