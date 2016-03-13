package com.dungeon.engine;

public class Chest extends DungeonObject {
	boolean unlocked;
	boolean open;
	//contents
	private static final String asciiRep = " C ";
	private static final String imageName = "chest.png";
	
	public Chest(boolean unlocked, boolean open) {
		super(imageName);
		this.unlocked = unlocked;
		this.open = open;
	}
	
	public boolean isPassable() {
		return unlocked;
	}
	
	public Event steppedOn() {
		return new ChestOpenEvent();
	}
	//test
}
