package game;

import java.awt.Graphics;

import MyUtil.GameUtil;

/**
 * Ѫ��
 * @author wenzi
 *
 */

public class HealthPoint extends GameObiect {
	
	
	//�Ƿ���ʾĳ��Ѫ��ͼƬ
	private boolean show = true;
	
	
	public boolean isShow() {
		return show;
	}



	public void setShow(boolean show) {
		this.show = show;
	}



	public HealthPoint() {
		
	}
	
	
	
	//���ӵ�
	public void drawhealthPoint(Graphics g) {
		if(show) {
			g.drawImage(image, (int)x, (int)y, null);
		}
		
	
	}
	
	//ͨ����������Ѫ����ͼ�Σ�λ�ó�ʼ����
	public HealthPoint(String healthPointImagepath,  double healthPoint_X, double healthPoint_Y) {
		super();
		this.image = GameUtil.getImage(healthPointImagepath);
		this.width = image.getWidth(null);
		this.heigth = image.getHeight(null);
		this.x = healthPoint_X;
		this.y = healthPoint_Y;
			}
	

}
