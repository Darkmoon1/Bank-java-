package cn.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.test.GameFrame.PaintThread;

public class MyFrame extends Frame{
	

	
	/*
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH, Constant.GAME_HIGHT);
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
	
	/*
	 * ˫��������update
	 */
	private Image iBuffer;
	private Graphics gBuffer;
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (iBuffer==null) {
			iBuffer = createImage(Constant.GAME_WIDTH, Constant.GAME_HIGHT);
			gBuffer = iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(100, 100, Constant.GAME_WIDTH, Constant.GAME_HIGHT);
		paint(gBuffer);
		g.drawImage(iBuffer, 100, 100, this);
	}
	
	
}
