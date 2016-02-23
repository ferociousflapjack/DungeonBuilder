package com.dungeon;

import java.util.concurrent.ThreadLocalRandom;

public class DungeonRoom {//Class procedurally generate a room in a dungeon.
	private int roomLength;
	private int roomWidth;
	private DungeonObject[][] dungeonRoom;
	
	public DungeonRoom(int roomWidth, int roomLength) {//Constructor
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
	
	public int setObjXCoord() {
		int objX = ThreadLocalRandom.current().nextInt(1, getRoomWidth() - 1);
		return objX;
	}
	public int setObjYCoord() {
		int objY = ThreadLocalRandom.current().nextInt(1, getRoomLength() - 1);
		return objY;
	}
	public int pickDoorSpot() {
		int doorSpot = ThreadLocalRandom.current().nextInt(1, ((getRoomWidth() * 2) + ((getRoomLength() - 1) * 2)));
		return doorSpot;
	}
	public void addDungeonObject(int x, int y, DungeonObject obj) {
		dungeonRoom[x][y] = obj;
	}
	public DungeonObject getDungeonTile(int x, int y) {
		return dungeonRoom[x][y];
	}
	
	public void fillRoom() {//Builds walls, places door, fills room with things.
		int doorCounter = 0;
		int doorSpot = pickDoorSpot();
		
		for (int i = 0; i < getRoomWidth(); i++) {
			for (int j = 0; j < getRoomLength(); j++) {
				if (i == 0 || j == 0) {
					dungeonRoom[i][j] = new Wall(" + ", false);
					doorCounter++;
					if (doorCounter == doorSpot) {
						dungeonRoom[i][j] = new Door(" | ", false, false);
					}
				}
				else if (i == getRoomWidth() - 1 || j == getRoomLength() - 1) {
					dungeonRoom[i][j] = new Wall(" + ", false);
					doorCounter++;
					if (doorCounter == doorSpot) {
						dungeonRoom[i][j] = new Door(" | ", false, false);
					}
				}
			}
		}
	}
}
