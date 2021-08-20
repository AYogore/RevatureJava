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
		
	}

	private static String[] collectInput(String command) {
		
		String[] commandArray = command.toLowerCase().split(" ");
		return commandArray ;
	}
		
	private static void parse(String[] command, Player player) throws IllegalArgumentException {
		//split with space
		String action = command[0];
		String item = command[1];
		
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
				System.out.println("Quit Game");
				player.game = false;
				break;
				
			default:
				System.out.println("Please enter valid statement(move x, use x, game x): ";
			
				
		}
		//direction command calls for Room.getexit(DIRECTION);
	}
}
