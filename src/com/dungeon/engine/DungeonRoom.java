package com.dungeon.engine;

import java.util.concurrent.ThreadLocalRandom;

public class DungeonRoom {//Class procedurally generate a room in a dungeon.
	private int roomLength;
	private int roomWidth;
	private DungeonObject[][] dungeonRoom;
	
	public DungeonRoom(int roomWidth, int roomLength) {//Constructor for DungeonRoom
		this.roomLength = roomLength;
		this.roomWidth = roomWidth;
		dungeonRoom = new DungeonObject[roomWidth][roomLength];
	}
	
	public int getRoomLength() {
		return roomLength;
	}
	
	public int getRoomWidth() {
		return roomWidth;
	}	
	
	public int setObjXCoord() {//Randomly sets the x coordinate for a DungeonObject
		int objX = ThreadLocalRandom.current().nextInt(1, getRoomWidth() - 1);
		return objX;
	}
	
	public int setObjYCoord() {//Randomly sets the y coordinate for a DungeonObject
		int objY = ThreadLocalRandom.current().nextInt(1, getRoomLength() - 1);
		return objY;
	}
	
	public int pickDoorSpot() {//Randomly determines the a spot on the perimeter to place a door
		int doorSpot = ThreadLocalRandom.current().nextInt(1, ((getRoomWidth() * 2) + ((getRoomLength() - 1) * 2)));
		return doorSpot;
	}
	
	public void addDungeonObject(int x, int y, DungeonObject obj) {
		dungeonRoom[x][y] = obj;
	}
	
	public DungeonObject getDungeonTile(int x, int y) {//Returns the x and y coordinates for a DungeonObject
		return dungeonRoom[x][y];
	}
	
	public void fillRoom() {//Builds walls, places door
		int doorCounter = 0;
		int doorSpot = pickDoorSpot();
		
		for (int i = 0; i < getRoomWidth(); i++) {
			for (int j = 0; j < getRoomLength(); j++) {
				if (i == 0 || j == 0) {
					dungeonRoom[i][j] = new Wall(false);
					doorCounter++;
					if (doorCounter == doorSpot) {
						dungeonRoom[i][j] = new Door(" | ", false, false);
					}
				}
				else if (i == getRoomWidth() - 1 || j == getRoomLength() - 1) {
					dungeonRoom[i][j] = new Wall(false);
					doorCounter++;
					if (doorCounter == doorSpot) {
						dungeonRoom[i][j] = new Door(" | ", false, false);
					}
				}
			}
		}
	}
}
