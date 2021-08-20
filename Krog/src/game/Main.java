package game;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		//create instances of statics
		Player player = new Player();
		RoomManager rm = new RoomManager();
		String[] command = new String[2];
		//boolean game = true;
		//instantiate rooms with Room Constructor
		rm.init();
		player.currentRoom = rm.startingRoom;
		
		while(player.game)
		{
			//while loop game is true
			//input command, show options of room
			printRoom(player);
			//collect input
			command = collectInput(sc.nextLine());
			//parse input
			parse(command, player);
			
		}
		
		sc.close();
	}
	
	private static void printRoom(Player player) {
		
		System.out.println("\n" + "*****" + player.currentRoom.name.toUpperCase() + "*****" +
				"\n" + player.currentRoom.longDescription +
				"\n\n" + "Exits:");
		//add null rooms to not print
		String direction = "";
		for(int i = 0; i < player.currentRoom.exits.length; i++)
		{
			switch (i)
			{
			case 0:
				direction = "North";
				break;
			case 1:
				direction = "East";
				break;
			case 2:
				direction = "South";
				break;
			case 3:
				direction = "West";
				break;
			}
			if(player.currentRoom.exits[i].name != "Null Room")
			{
				System.out.println(direction + ": " + player.currentRoom.exits[i].shortDescription);

			}
		}
		
		if(player.currentRoom.items[0].name != "Null Room")
		{
			
			System.out.println("\n" + "Items: " + "\n" + player.currentRoom.items[0].shortDescription);
		}
		
			
		
		
		/*System.out.println("North: " + player.currentRoom.exits[0].name);
		System.out.println("South: " + player.currentRoom.exits[2].name);
		System.out.println("West: " + player.currentRoom.exits[3].name);
		*/
		//print all exits
		//Room[] exitArray = player.currentRoom.getExits();
		
	}

	private static String[] collectInput(String command) {
		//split command to command and fixture
		//boolean l = false;
		//String[] s;
		//Scanner sca = new Scanner(System.in);
		/*
		while(l == false)
		{
			if(command.toCharArray().length <= 4)
			{
				System.out.println("Please enter a valid command(move x, use x, quit x:)");
				s = collectInput(sca.nextLine());
				System.out.println(".");
			}
			else
				l = true;
			
		}*/
		//valid statement loop
		String[] commandArray = command.toLowerCase().split(" ");
		//sca.close();
		return commandArray ;
	}
		
	private static void parse(String[] command, Player player) {
		//split with space
		String action = command[0];
		String item = command[1];
		if(command[1] != null)
		{
			item = command[1];		
		}
		else
		{
			System.out.println("bleh");
		}
		//go command
		
		switch(action)
		{
			case "move":
				//second switch on direction command
				//return player.currentRoom.getExit(item); 
				player.currentRoom = player.currentRoom.getExit(item);

				break;
		
			case "use":
				System.out.println("\n" + "**" + item + "**");
				System.out.println(player.currentRoom.items[0].longDescription);
				break;
			case "quit":
				player.game = false;
				break;
			
				
		}
		//direction command calls for Room.getexit(DIRECTION);
	}
}
