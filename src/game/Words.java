package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 游戏场景中出现的文字提示
 * @author wenzi
 *
 */

public class Words extends GameObiect {
	
	
	String str;
	
	//是否显示提示文字；
	private boolean write = false;
	
	
	public boolean isWrite() {
		return write;
	}


	public void setWrite(boolean write) {
		this.write = write;
	}




	//写提示文字；
	public void drawWords(Graphics g) {
		if(isWrite()) {
			
			Color c = g.getColor();
			g.setColor(Color.black);
			Font f = new Font("Goudy Stout", Font.PLAIN, 40);
			g.setFont(f);
			g.drawString("465465", 500, 500);
			g.setColor(c);
			
			
		}
			
		
	}
	
	
	
	
	public Words(Graphics g,String str ,int size,int x,int y, Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("Goudy Stout", Font.PLAIN, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	
	
	public Words(String str ,int size,int x,int y, Color color) {
		this();
	}
	
	
	
	public Words() {
		
	}
	

}
