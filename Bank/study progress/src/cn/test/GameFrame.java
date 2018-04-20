package cn.test;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//������
public class GameFrame extends Frame{//GUI AWT,SWINGS ������
	Image img = GameUtil.getImage("images/FEIJI.png");
		
	/*
	 * ���ش���
	 */
	
	public void launchFrame(){
		setSize(500, 500);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();//�����ػ�
		
		addWindowListener(new WindowAdapter() {					
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		
	}
	
	private int x=100,y=100;
	
	
	@Override
	public void paint(Graphics g) {
		//g.setColor(new Color(0, 255, 255));
		//font set font
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		g.drawString("yhy", 200, 200);
		g.drawImage(img, x, y, null);
		
		x+=3;
	}
	
	
	/*
	 * �����ػ����ڵ��߳��ڲ���
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
		
	}
}
