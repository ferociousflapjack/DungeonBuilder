package com.dungeon;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.KeyEvent;

public class HackInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("a");
		
		while (true) {
			
			String s = scan.next();
		}
	}

}
