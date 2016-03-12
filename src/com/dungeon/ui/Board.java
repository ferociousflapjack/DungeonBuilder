package com.dungeon.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;

import com.dungeon.engine.DungeonAssembler;
import com.dungeon.engine.DungeonRoom;
import com.dungeon.engine.GameState;
import com.dungeon.engine.Player;
import com.dungeon.engine.DungeonObject;

public class Board extends JPanel implements ActionListener {

	private Timer timer;
	private GameState gameState;
	private final int DELAY = 3;
	private int cellWidth = 60;
	private int cellLength = 60;
		
	public Board() {
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		
		DungeonAssembler assembler = new DungeonAssembler();
		DungeonRoom dungeon1 = assembler.setupDungeonRoom();
		Player player1 = new Player(5, 10, 1, 1);
		gameState = new GameState(dungeon1, player1);
				
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void pullImage(Graphics2D g2d, DungeonObject obj, int x, int y) {
		ImageIcon ii;

		if (obj == null) {
			ii = new ImageIcon("floor.png");
		} else {
			ii = new ImageIcon(obj.getImageName());
		}
		g2d.drawImage(ii.getImage(), x * cellWidth, y * cellLength, this);
	}
	
	private void doDrawing(Graphics g) {
		DungeonRoom dungeon = gameState.getDungeon();
		
		Graphics2D g2d = (Graphics2D) g;
		for (int y = 0; y < dungeon.getRoomLength(); y++) {
			for (int x = 0; x < dungeon.getRoomWidth(); x++) {
				DungeonObject currentTile = dungeon.getDungeonTile(x, y);
				pullImage(g2d, currentTile, x, y);
			}
		}
		
		Player playerSpot = gameState.getPlayer();
		pullImage(g2d, playerSpot, playerSpot.getXCoord(), playerSpot.getYCoord());
	}
	
	public void actionPerformed(ActionEvent e) {
		
		repaint();
	}
	
	private class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			String keyPress = "";
			
			if (key == KeyEvent.VK_A) {
				keyPress = "a";
			}
			
			if (key == KeyEvent.VK_D) {
				keyPress = "d";
			}
			
			if (key == KeyEvent.VK_W) {
				keyPress = "w";
			}
			
			if (key == KeyEvent.VK_S) {
				keyPress = "s";
			}
			
			gameState.parseInput(keyPress);
		}
		
		public void keyReleased(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_LEFT) {
				
			}
			
			if (key == KeyEvent.VK_RIGHT) {
				
			}
			
			if (key == KeyEvent.VK_UP) {
				
			}
			
			if (key == KeyEvent.VK_DOWN) {
				
			}
		}
	}
}

