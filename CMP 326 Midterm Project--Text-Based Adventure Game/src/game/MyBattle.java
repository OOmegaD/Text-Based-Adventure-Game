package game;

import java.util.Scanner;

import gameinterfaces.Battle;
import gameinterfaces.Monster;
import gameinterfaces.Player;

public class MyBattle implements Battle{
	
	private Player player;
	private Monster monster;
	
	public MyBattle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
	}

	@Override
	public void run() {
		Scanner scnr = new Scanner(System.in);
		char userAction;
		System.out.println("Battle begins: " + player.getName() + " vs " + monster.getName());
		
		while(monster.isAlive()) {
			System.out.println("Player HP: " + player.getHitPoints() + " | Monster HP: " + monster.getHitPoints());
			System.out.println("Player's turn attack (a) or heal (h)?");
			userAction = scnr.nextLine().charAt(0);
			
			switch(userAction) {
				case 'a':
					player.attack(monster);
					break;
				case 'h':
					player.heal();
					break;
			default:
			}
			
			if(!monster.isAlive()) {
				System.out.println(monster.getName() + " died. ");
				break;
			}
			System.out.println("Monster's turn: ");
			
			if (monster.canEnrage()) {
				monster.enrage();
			}
			monster.attack(player);
			
			if(!player.isAlive()) {
				System.out.println(player.getName() + " died.");
				break;
			}
		}
		
		
	}

}
