package game;

import gameinterfaces.Monster;

public class MyMonster extends MyCreature implements Monster {
	
	private boolean isEnraged;
	private int enrageThreshold;
	
	
	public MyMonster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name, description, hitPoints, damage);
		this.enrageThreshold = enrageThreshold;
	}

	@Override
	public void enrage() {
		if (!isEnraged) {
			this.damage *= 2;
			System.out.println(this.name + " has been enraged.");
			isEnraged = true;
		}
	}

	@Override
	public boolean canEnrage() {
		if (this.hitPoints < this.enrageThreshold) {
			return true;
		}
		else {
			return false;
		}
	}

}
