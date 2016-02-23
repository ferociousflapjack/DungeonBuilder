package com.dungeon;

import java.util.Scanner;

public class GameState {
	private DungeonRoom dungeon;
	private Player player;
	
	public GameState(DungeonRoom dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
	}
	
	public void printState() {//Displays room.
		for (int y = 0; y < dungeon.getRoomLength(); y++) {
			for (int x = 0; x < dungeon.getRoomWidth(); x++) {
				String coordinateChar;
				if (dungeon.getDungeonTile(x, y) == null) {
					coordinateChar = " . ";
				}
				else {
					coordinateChar = dungeon.getDungeonTile(x, y).getCharacter();
				}
				if (x == player.getXCoord() && y == player.getYCoord()) {
					coordinateChar = player.getCharacter();
				}
				System.out.print(coordinateChar);
			}
			System.out.println();
		}
		}
	private boolean checkPassable(int changeX, int changeY) {
		int x = player.getXCoord() + changeX;
		int y = player.getYCoord() + changeY;
		DungeonObject object = dungeon.getDungeonTile(x, y);
		if (object != null) {
			return object.isPassable();
		} else {
			return true;
		}
	}
	
	public boolean parseInput(String input) {
		if (input.equals("d")) {
			if (checkPassable(1, 0)) {
				player.moveRight(); 
			}
			return true;
		} else if (input.equals("a")) {
			if (checkPassable(-1, 0)) {
				player.moveLeft();
			}
			return true;
		} else if (input.equals("s")) {
			if (checkPassable(0, 1)) {
				player.moveDown();
			}
			return true;
		} else if (input.equals("w")) {
			if (checkPassable(0, -1)) {
				player.moveUp();
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DungeonAssembler assembler = new DungeonAssembler();
		DungeonRoom dungeon1 = assembler.setupDungeonRoom();
		Player player1 = new Player(5, 10, 1, 1);
		GameState gameState = new GameState(dungeon1, player1);
		
		boolean keepGoing = true;
		gameState.printState();
		while (keepGoing) {
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			keepGoing = gameState.parseInput(s);
			gameState.printState();
			
		}

	}

}
