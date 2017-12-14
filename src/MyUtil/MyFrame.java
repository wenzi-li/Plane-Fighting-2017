package MyUtil;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MyFrame extends Frame {
	
	/**
	 * 加载窗口
	 */
	public  void launchFrame(){

		//设置窗口标题
		setTitle("Plane Fighting 2017");
		//设置窗口长宽；
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		//设置窗口位置，以左上角为原点；
		setLocation(200,100);
		
		//setBounds是setSize和setlocation方法的组合
		//setBounds(x, y, width, height);
		
		//使图形窗口可见，进行加载；
		setVisible(true);
		
		//启动重画PaintThread类
		new PaintThread().start();
	
		//窗口监听(listener)，实现窗口关闭；
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		}
	
	
	/**
	 * 定义一个重画窗口的内部线程类；
	 * @author wenzi
	 *
	 */
	class PaintThread extends Thread {
		public void run () {
			while(true) {
				repaint();
				try {
					Thread.sleep(10);  //1s = 1000ms;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 重载update(Graphics g)函数，消除画面闪动。方法来源：http://blog.csdn.net/helloworld10086/article/details/40679055
	 */
	private Image iBuffer;  
	private Graphics gBuffer; 
	public void update(Graphics g)  
	{  
	    if(iBuffer==null)  
	    {  
	        iBuffer=createImage(this.getSize().width,this.getSize().height);  
	        gBuffer=iBuffer.getGraphics();  
	    }  
	    gBuffer.setColor(getBackground());  
	    gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);  
	    paint(gBuffer);  
	    g.drawImage(iBuffer,0,0,this);  
	}  
	
	
}

