/*Thoughts on balancing things: limit to num of each particular dungeon object on each floor. Certain num of chests, traps, etc. 
 * More robust rarity rankings
 * 
 * Other thoughts: How can I set it up to randomize which objects can appear in the room? Will I need to set them up as an array and pull from that?
 * How will I prioritize things in the array so that it is appropriately weighted? 
 * 
 * I feel like DungeonRoomGenerator is still chunky. I'm repeating code when I generate the walls and the like, so that means I'm doing something not quite
 * right. Let's try setting the wall, floor, traps, etc. at the beginning and invoking them. 
 * 
 * Well, mild improvement to reduce the repetition in my code by defining walls earlier. 
 * I need it here in the main class, though. Perhaps it needs to be a part of buildRoomArray?
 * Last thought on this for today is that I've got some useless crap kicking around in my Dungeon Objects classes
 *
 *I can set it up with methods to generate dungeon pieces of certain dimensions, ie vertical or horizontal hallways.
 */
package com.dungeon.engine;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class DungeonAssembler {
	
	public int randomWithinRange(int x, int y) {
		int randomWithinRange = ThreadLocalRandom.current().nextInt(x, y);
		return randomWithinRange;
	}
	
	public DungeonObject buildDungeonObject() {
		int randChoice = randomWithinRange(1, 100);
		if (randChoice < 50) {
			return new Chest(false, false);
		} else {
			return new FloorTrap(5);
		}
	}
	
	public DungeonRoom setupDungeonRoom() {
		int roomWidth = randomWithinRange(6, 20);
		int roomLength = randomWithinRange(6, 20);
		int numObjInRoom = randomWithinRange(0, 6);
		

		DungeonRoom dungeon1 = new DungeonRoom(roomWidth, roomLength);
		dungeon1.fillRoom();
		
		for (int i = 0; i < numObjInRoom; i++) {
			dungeon1.addDungeonObject(randomWithinRange(1, (roomWidth - 1)), randomWithinRange(1, roomLength - 1), buildDungeonObject());
		}
		return dungeon1;
	}
}

