package com.dungeon;

public class FloorTrap extends DungeonObject{
	int damage;
	private static final String asciiRep = " , ";
	
	public FloorTrap(int damage) {
		super(asciiRep);
		this.damage = damage;
	}
	public boolean isPassable() {
		return true;
	}
}
