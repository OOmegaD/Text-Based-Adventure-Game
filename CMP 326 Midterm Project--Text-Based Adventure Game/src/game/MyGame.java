package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import gameinterfaces.Game;
import gameinterfaces.Player;
import gameinterfaces.Room;

public class MyGame implements Game {
	
	private Player player;
	private Room[] dungeon;
	
	public MyGame() {
		FileInputStream fileByteStream = null;
		Scanner inFS = null;
		
		try {
			fileByteStream = new FileInputStream("C:\\");
			inFS = new Scanner(fileByteStream);
			String playerName = inFS.nextLine();
			String playerDesc = inFS.nextLine();
			int playerHP = inFS.nextInt();
			inFS.nextLine();
			int playerDamage = inFS.nextInt();
			inFS.hasNextLine();
			int playerHealAmount = inFS.nextInt();
			setPlayer(new MyPlayer(playerName, playerDesc, playerHP, playerDamage, playerHealAmount));
		}
		catch(IOException e) {
			System.out.println("IOException: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			inFS.close();
			System.out.println("Player created.");
		}
		
		dungeon = new Room[3];
		MyMonster monster1 = new MyMonster("Orc "," covered with green dry and slimy blood", 20, 5, 0);
		MyMonster monster2 = new MyMonster("Skeleton "," Funny how it moves", 40, 10, 10);
		MyMonster monster3 = new MyMonster("Fire Dragon "," Spout fire with each breath", 100, 20, 40);
		MyRoom room1 = new MyRoom(0, "A room with an ubearable smell", monster1);
		MyRoom room2 = new MyRoom(1, "Dark and cold", monster2);
		MyRoom room3 = new MyRoom(3, "A giant all with something shiny on the other end", monster3);
		dungeon[0] = room1;
		dungeon[2] = room2;
		dungeon[3] = room3;	
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
