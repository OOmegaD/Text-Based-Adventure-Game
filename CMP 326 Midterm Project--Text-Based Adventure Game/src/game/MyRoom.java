package game;

import gameinterfaces.Monster;
import gameinterfaces.Player;
import gameinterfaces.Room;

public class MyRoom implements Room{
	
	protected int roomIndex;
	protected String description;
	protected Monster monster;
	
	public MyRoom(int roomIndex, String description, Monster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}

	@Override
	public boolean isComplete() {
		if (!monster.isAlive()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void enter(Player player) {
		System.out.println(player);
		System.out.println("This room is " + this.description  + ", and has " + this.monster);
		
		if(monster.isAlive()) {
			MyBattle battle = new MyBattle(player, monster);
			battle.run();
		}
	}
	
	@Override
	public String toString() {
		return String.format("Room index %2d, description %20s, monster name %20s", roomIndex, description, monster);
		
	}
	
}
