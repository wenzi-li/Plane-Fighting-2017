package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import MyUtil.GameUtil;

/**
 * 游戏中出现的物体，如飞机，子弹等；
 * @author wenzi
 *
 */

public class GameObiect {
	
	    //定义图形；
		Image image ;
		//定义坐标；
		double x,y;
		//速度
		double speed ;
		//物体所在矩形的宽度和高度；
		double width,heigth;
		
		
		public GameObiect() {
			
		}
		
		
		//获取物体所在的矩形，以便进行碰撞检测；
		public Rectangle getRectangle () {
			return new Rectangle((int)x, (int)y, (int)width, (int)heigth);
			}
		
		
		//在窗口中画出物体
		public void draw(Graphics g) {
		}
		
		
		//物体移动
		public void objectMove() {
			
		}
		
		
		//通过构造器给物体的图形，位置初始化；
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
