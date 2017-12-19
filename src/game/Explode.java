package game;

import java.awt.Graphics;
import java.awt.Image;

import MyUtil.GameUtil;

/**
 * 实现爆炸效果；
 * @author wenzi
 *
 */

public class Explode {
	
	//爆炸发生的位置坐标；
	double x,y;
	
//	//是否产生爆炸；
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


	//爆炸图片数组；
	static Image[] images = new Image[8];
	
	static {
		for (int i = 0; i < 8 ;i++) {
			images[i] = GameUtil.getImage("images/explode/big/000.png");
			images[i].getWidth(null);
		}
	}
	
	//计数器，计算图片当前个数；
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
