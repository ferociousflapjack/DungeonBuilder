package com.dungeon.ui;

import java.awt.EventQueue;
import javax.swing.JFrame;

//TODO attack image display
public class DisplayDriver extends JFrame {

	public DisplayDriver() {
		add(new Board());
		
		setSize(1000, 750);
		setResizable(false);
		
		setTitle("Test");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				DisplayDriver driver = new DisplayDriver();
				driver.setVisible(true);
			}
		});
	}
}
