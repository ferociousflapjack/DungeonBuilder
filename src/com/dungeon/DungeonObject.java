package com.dungeon;

public class DungeonObject {
	String asciiRep;
	boolean passable = false;
	
	public DungeonObject(String asciiRep) {
		this.asciiRep = asciiRep;
	}
	public String getCharacter() {
		return asciiRep;
	}
	public boolean isPassable() {
		return passable;
	}
}