package com.dungeon.engine;

public class Door extends DungeonObject {
	boolean unlocked;
	boolean open;
	private static final String imageName = "door.png";
	
	public Door (String asciiRep, boolean unlocked, boolean open) {
		super(imageName);
		this.unlocked = unlocked;
		this.open = open;
	}
	public boolean doorState() {
		return open;
	}
}
