package com.dungeon.engine;

public class Door extends DungeonObject {
	boolean unlocked;
	boolean open;
	
	public Door (String asciiRep, boolean unlocked, boolean open) {
		super(asciiRep);
		this.unlocked = unlocked;
		this.open = open;
	}
	public boolean doorState() {
		return open;
	}
}
