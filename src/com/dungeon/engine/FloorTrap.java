package com.dungeon.engine;

public class FloorTrap extends DungeonObject{
	int damage;
	private static final String asciiRep = " , ";
	private static final String imageName = "floortrap.png";
	
	public FloorTrap(int damage) {
		super(imageName);
		this.damage = damage;
	}
	public boolean isPassable() {
		return true;
	}
}
