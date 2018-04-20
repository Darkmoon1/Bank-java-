package cn.test;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.text.Position;

public class Star {
	Image img;
	protected int x,y;
	int position_x,position_y;
	public void draw(Graphics g){
		g.drawImage(img, x, y, null);
	}
	
	public Star() {
		// TODO Auto-generated constructor stub
	}
	public Star(String img_path,int position_x,int position_y) {
		// TODO Auto-generated constructor stub
		this.img = GameUtil.getImage(img_path);
		this.position_x = position_x;
		this.position_y = position_y;
		x = position_x - img.getWidth(null)/2;
		y = position_y - img.getHeight(null)/2;
	}

	public Star(Image img,int position_x,int position_y) {
		// TODO Auto-generated constructor stub
		this.img = img;
		this.position_x = position_x;
		this.position_y = position_y;
		x = position_x - img.getWidth(null)/2;
		y = position_y - img.getHeight(null)/2;
	}

}
