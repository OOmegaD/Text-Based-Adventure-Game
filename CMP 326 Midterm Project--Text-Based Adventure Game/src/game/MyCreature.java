package game;

import gameinterfaces.Creature;
import gameinterfaces.Room;

public class MyCreature implements Creature{
	protected String name;
	protected String description;
	protected int hitPoints;
	protected int damage;
	private Room[] room;
	
	public MyCreature(String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints;
		this.damage = damage;
		room = null;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public Room[] getRoom() {
		return room;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setRoom(Room[] room) {
		this.room = room;
	}
		
	@Override
	public void attack(Creature creature) {
		System.out.println(this.name + " attacks target creature's name, dealing " + damage + " damage");
	} // add take damage method?

	@Override
	public void takeDamage(int damage) {
		hitPoints -= damage; // Come back to display error if hitPoints goes below zero		
	}

	@Override
	public boolean isAlive() {
		if (hitPoints > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return String.format("name %15s, description %20s, hitPoints %03d, damage %02d", name, description, hitPoints, damage);
	}
	
}
