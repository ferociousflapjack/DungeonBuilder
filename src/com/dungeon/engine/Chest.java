package com.dungeon.engine;

public class Chest extends DungeonObject {
	boolean unlocked;
	boolean open;
	//contents
	private static final String asciiRep = " C ";
	
	public Chest(boolean unlocked, boolean open) {
		super(asciiRep);
		this.unlocked = unlocked;
		this.open = open;
	}
}
