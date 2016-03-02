package com.dungeon.engine;

public class DungeonObject {
	String asciiRep;
	boolean passable = false;
	String imageName = "craft.png";
	
	
	public DungeonObject(String imageName) {
		imageName = this.imageName;
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public String getCharacter() {
		return asciiRep;
	}
	
	public boolean isPassable() {
		return passable;
	}
}