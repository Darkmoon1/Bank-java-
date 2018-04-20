package cn.test;
/*
 * 工具类
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	
	private GameUtil(){};//工具类私有化构造函数
	
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return img;
	}
}
