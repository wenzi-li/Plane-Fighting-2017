package game;

import java.awt.Graphics;

import MyUtil.GameUtil;

/**
 * 血条
 * @author wenzi
 *
 */

public class HealthPoint extends GameObiect {
	
	
	//是否显示某个血量图片
	private boolean show = true;
	
	
	public boolean isShow() {
		return show;
	}



	public void setShow(boolean show) {
		this.show = show;
	}



	public HealthPoint() {
		
	}
	
	
	
	//画子弹
	public void drawhealthPoint(Graphics g) {
		if(show) {
			g.drawImage(image, (int)x, (int)y, null);
		}
		
	
	}
	
	//通过构造器给血条的图形，位置初始化；
	public HealthPoint(String healthPointImagepath,  double healthPoint_X, double healthPoint_Y) {
		super();
		this.image = GameUtil.getImage(healthPointImagepath);
		this.width = image.getWidth(null);
		this.heigth = image.getHeight(null);
		this.x = healthPoint_X;
		this.y = healthPoint_Y;
			}
	

}
