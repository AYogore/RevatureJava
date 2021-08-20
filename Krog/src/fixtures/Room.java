package fixtures;

public class Room extends Fixture{

	public String name;
	public int room;
	public Room[] exits;
	public Room[] items;

	
	public Room(String name, String shortDescription, String longDescription) {
		//super constructor of Fixture
		super(name, shortDescription, longDescription);
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.exits = new Room[4];
		this.items = new Room[4];// size is your choice
	}
		
	public Room[] getExits() {
		//print Room[] length
		for(int i = 0; i < this.exits.length; i++)
		{
			System.out.println(exits[i].name); 
		}
		return exits;
			
		//give options
	}
		
	public Room getExit(String direction) {
		//move current room with direction, update room
		switch (direction)
		{
		case "north":
			room = 0;
			break;
		case "east":
			room = 1;
			break;
		case "south":
			room = 2;
			break;
		case "west":
			room = 3;
			break;
		}
		return exits[room];
	}
	public Room[] setExits(Room a, Room b, Room c, Room d)
	{
		//sets exits for each rooms in room manager
		Room[] exitArray = {a,b,c,d};
		return exitArray;
	}
}