package cn.test;
import cn.test.GameUtil;

import java.awt.Graphics;
import java.awt.Image;

import org.omg.CORBA.MARSHAL;

import cn.test.Constant;
/*
 * Ì«ÑôÏµ
 */
public class SolarFrame extends MyFrame {
	int math = 3;
	Image bg =  GameUtil.getImage(Constant.BG);
	Star sun =  new Star(Constant.SUN, Constant.GAME_WIDTH/2, Constant.GAME_HIGHT/2);
	Planet mercury = new Planet(Constant.MERCURY, 380/math, 214/math, 0.4789, sun);
	Planet venus = new Planet(Constant.VENUS, 720/math, 405/math, 0.3503, sun);
	Planet earth = new Planet(Constant.EARTH, 1000/math, 562/math, 0.3, sun);
	Planet mars = new Planet(Constant.MARS, 1520/math, 855/math, 0.2413, sun);
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		
	}	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
	
	
}
