package com.dungeon;

public class Wall extends DungeonObject {
	boolean bombable;
	
	public Wall(String asciiRep, boolean bombable) {
		super(asciiRep);
		this.bombable = bombable;
	}
}
