package com.dungeon.engine;

//TODO build checkProximity method
//TODO determine how to handle multiple interaction possibilities 

public class GameState {
	private DungeonRoom dungeon;
	private Player player;
	
	public GameState(DungeonRoom dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
	}
	
	public DungeonRoom getDungeon() {
		return dungeon;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private boolean checkPassable(int changeX, int changeY) {
		int x = player.getXCoord() + changeX;
		int y = player.getYCoord() + changeY;
		DungeonObject object = dungeon.getDungeonTile(x, y);
		if (object != null) {
			return object.isPassable();
		} else {
			return true;
		}
	}
	
	private void triggerEvents() {
		DungeonObject currentTile = dungeon.getDungeonTile(player.getXCoord(), player.getYCoord());
		if (currentTile != null) {
			Event event = currentTile.steppedOn();
			if (event != null) {
				System.out.println(event.getEventText());
			}
		}
	}
	
	public void parseInput(String input) {
		if (input.equals("d")) {
			if (checkPassable(1, 0)) {
				player.moveRight(); 
			}
			
		} else if (input.equals("a")) {
			if (checkPassable(-1, 0)) {
				player.moveLeft();
			}
			
		} else if (input.equals("s")) {
			if (checkPassable(0, 1)) {
				player.moveDown();
			}
		
		} else if (input.equals("w")) {
			if (checkPassable(0, -1)) {
				player.moveUp();
			}
		}
		triggerEvents();
	}
}

/*	public static void main(String[] args) {
		DungeonAssembler assembler = new DungeonAssembler();
		DungeonRoom dungeon1 = assembler.setupDungeonRoom();
		Player player1 = new Player(5, 10, 1, 1);
		GameState gameState = new GameState(dungeon1, player1);
		
		boolean keepGoing = true;
		gameState.printState();
		while (keepGoing) {
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			keepGoing = gameState.parseInput(s);
			gameState.printState();
			
		}

	}*/
	/*public void printState() {//Displays room.
	for (int y = 0; y < dungeon.getRoomLength(); y++) {
		for (int x = 0; x < dungeon.getRoomWidth(); x++) {
			String coordinateChar;
			if (dungeon.getDungeonTile(x, y) == null) {
				coordinateChar = " . ";
			}
			else {
				coordinateChar = dungeon.getDungeonTile(x, y).getCharacter();
			}
			if (x == player.getXCoord() && y == player.getYCoord()) {
				coordinateChar = player.getCharacter();
			}
			System.out.print(coordinateChar);
		}
		System.out.println();
	}
	}*/

