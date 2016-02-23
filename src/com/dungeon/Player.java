package com.dungeon;

public class Player extends DungeonObject {
	private static final String asciiRep = " Q ";
	private int hp;
	private int atk;
	private int x;
	private int y;
	
	public Player(int hp, int atk, int x, int y) {
		super(asciiRep);
		this.hp = hp;
		this.atk = atk;
		this.x = x;
		this.y = y;
	}
	public int getXCoord() {
		return x;
	}
	public int getYCoord() {
		return y;
	}
	public void moveRight() {
		x++;
	}
	public void moveLeft() {
		x--;
	}
	public void moveUp() {
		y--;
	}
	public void moveDown() {
		y++;
	}
}
