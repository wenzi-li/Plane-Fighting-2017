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
	//爆炸图片数组；
	static Image[] images = new Image[10];
	static {
		for (int i = 0; i < 10 ;i++) {
			images[i] = GameUtil.getImage("images/e"+(i+1+".jpg"));
			images[i].getWidth(null);
		}
	}
	//计数器，计算图片当前个数；
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
