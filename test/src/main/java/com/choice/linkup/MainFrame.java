package com.choice.linkup;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements Runnable {
	
	public String filePath = "img/di.png";
	public String filePath2 = "img/y0.png";
	
	//创建一个容器
	public static Container ct;
	
	public static int lineNum = 10;
	public static int imgHeight = 50;
	
	public static String[] gifPath = new String[]{
		"img/tx1.png",
		"img/tx2.png",
		"img/tx3.png"
	};
	
	public static volatile boolean flag = false;
	
	public static volatile List<Gif> list = new ArrayList<Gif>();
	
	public MainFrame() {
		
		String projectPath = getClass().getResource("/").getPath().toString();
		
		int windowWidth = (lineNum*imgHeight+(lineNum*2-4));
		int windowHeight = (lineNum*imgHeight+20+(lineNum*2-1));
		
        ct=this.getContentPane();
       	this.setLayout(null);
		
		this.setTitle("0.0");
		this.setBounds(0, 0, windowWidth,windowHeight);

		ct.setBounds(0, 0, windowWidth,windowHeight);
		ct.setLayout(null);
		ct.setBackground(null);
		
		for(int i=0;i<lineNum;i++) {
			for(int j=0;j<lineNum;j++) {
				
				PictureBtn pic2 = new PictureBtn(new ImageIcon(projectPath+filePath2));
				pic2.setBounds(i*imgHeight, j*imgHeight, imgHeight, imgHeight);
				pic2.setLayout(null);
				
				ct.add(pic2);
				ct.repaint();
				
			}
		}
		
		for(int i=0;i<lineNum;i++) {
			for(int j=0;j<lineNum;j++) {
				
				PictureBtn pic2 = new PictureBtn(new ImageIcon(projectPath+filePath));
				pic2.setBounds(i*imgHeight, j*imgHeight, imgHeight, imgHeight);
				pic2.setLayout(null);
				
				ct.add(pic2);
				ct.repaint();
				
			}
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}

	public void run(){
		try {
			
			while(true) {
				
				Iterator<Gif> iter = list.iterator();
				
				while(iter.hasNext()) {
					
					Gif gif = iter.next();
					
					int time = gif.getTime();
					
					if(time <= 0) {
						iter.remove();
						continue;
					}
					PictureBtn pic = new PictureBtn(gif.getIcon());
					pic.setBounds(gif.getX(), gif.getY(), imgHeight, imgHeight);
					pic.setLayout(null);
					
					ct.removeAll();
					ct.add(pic);
					
					
					time = time - 20;
					gif.setTime(time);
				}
				
				Thread.sleep(20);
				this.repaint();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
