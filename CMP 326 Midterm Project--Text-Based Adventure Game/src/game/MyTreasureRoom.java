package game;

import gameinterfaces.Monster;
import gameinterfaces.Player;
import gameinterfaces.TreasureRoom;

public class MyTreasureRoom extends MyRoom implements TreasureRoom {
	
	private String treasure;
	
	public MyTreasureRoom(int roomIndex, String description, Monster monster, String treasure) {
		super(roomIndex, description, monster);
		this.setTreasure(treasure);
	}
	
	@Override
	public void enter(Player player) {
		System.out.println(player);
		System.out.println("This room is " + this.description  + ", and has " + this.monster);
		
		if(monster.isAlive()) {
			MyBattle battle = new MyBattle(player, monster);
			battle.run();
		}
		
		if(player.isAlive()) {
			System.out.println("You explored the room and found the hidden treasure!");
		}
	}

	public String getTreasure() {
		return treasure;
	}

	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}
	
	
}
