package com.dungeon.engine;

public class Wall extends DungeonObject {
	private static final String imageName = "wall.png";
	boolean bombable;
	
	public Wall(boolean bombable) {
		super(imageName);
		this.bombable = bombable;
	}
}
