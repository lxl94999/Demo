package com.choice.linkup;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PictureBtn extends JButton implements ActionListener {
	
//	Image im;
	
	public PictureBtn(ImageIcon icon) {
		super(icon);
		//内容窗格透明,false为透明
//		this.setOpaque(false);
		//设置按钮透明
		this.setContentAreaFilled(false);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String projectPath = getClass().getResource("/").getPath().toString();
		
		PictureBtn btn = (PictureBtn) event.getSource();
		
		System.out.println("x,y:"+btn.getX()+","+btn.getY());
		btn.setVisible(false);
		
		Gif gif = new Gif();
		gif.setIcon(new ImageIcon(projectPath+"img/tx1.png"));
		gif.setTime(2000);
		gif.setX(btn.getX());
		gif.setY(btn.getY());
		
		MainFrame.list.add(gif);
		
	}

//	@Override
//	public void paintComponents(Graphics g) {
//		super.paintComponent(g);
//		//绘制指定图像中已缩放到适合指定矩形内部的图像
//		g.drawImage(im,0,0, this.getWidth(), this.getHeight(), this);
//	}

}
