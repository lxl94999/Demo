package com.choice.linkup;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class BkgPanel extends JPanel {

	Image im;
	
	public BkgPanel(Image img) {
		this.im = img;
		//内容窗格透明,false为透明
		this.setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//绘制指定图像中已缩放到适合指定矩形内部的图像
		g.drawImage(im,0,0, this.getWidth(), this.getHeight(), this);
	}
	
}