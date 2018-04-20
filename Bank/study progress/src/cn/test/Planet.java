package cn.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
/*
 * –––«¿‡ºÃ≥–”⁄∫„–«
 */
public class Planet extends Star{

	int longAxis,shortAxis;
	double speed;
	double degree;
	Star center;	
	
	public Planet(String img_path,int longAxis,int shortAxis,double speed,Star center) {
		// TODO Auto-generated constructor stub
		super(img_path,center.position_x+longAxis,center.position_y);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.center = center;
		this.speed = speed;
		this.degree = 0;
		
	}
	
	public void draw(Graphics g){
		super.draw(g);
		drawTrace(g);
		move();
	}
	
	
	public void move(){
		x = (int) (center.position_x + longAxis*Math.cos(degree) - img.getWidth(null)/2);
		y = (int) (center.position_y + shortAxis*Math.sin(degree) - img.getHeight(null)/2);
		degree += speed;
	}
	
	public void drawTrace(Graphics g){
		Color color = g.getColor();
		g.setColor(Color.BLUE);
		g.drawOval(center.position_x-longAxis, center.position_y-shortAxis, 2*longAxis, 2*shortAxis);
		g.setColor(color);
	}

}
