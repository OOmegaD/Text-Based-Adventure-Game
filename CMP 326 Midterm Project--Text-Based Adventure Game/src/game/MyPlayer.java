package game;

import gameinterfaces.Player;

public class MyPlayer extends MyCreature implements Player  {
	
	private int healAmount;
	
	public MyPlayer(String name, String description, int hitPoints, int damage, int healAmount) {
		super(name, description, hitPoints, damage);
		this.healAmount = healAmount;
	}

	@Override
	public void heal() {
		hitPoints += this.healAmount;	
		System.out.println(this.name + " is healed by " + this.healAmount);
	}
}
