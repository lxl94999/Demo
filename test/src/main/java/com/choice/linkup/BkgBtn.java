package com.choice.linkup;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BkgBtn extends JButton {
	
	public BkgBtn(ImageIcon icon) {
		super(icon);
		//设置按钮透明
		this.setContentAreaFilled(false);
	}
	
}
