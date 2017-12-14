package MyUtil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * 游戏开发中常见的工具类（如：图片加载等）。
 * @author wenzi
 *
 */
public class GameUtil {
	
	//工具类通常将构造方法私有；
	private GameUtil(){}
	
	
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	
	}

}
