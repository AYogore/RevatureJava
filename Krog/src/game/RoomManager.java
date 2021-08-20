package game;
import fixtures.Room;

public class RoomManager {
	
	public Room startingRoom;
	public Room[] rooms =  new Room[8]; //set length equal to amount of total runes
	
	public void init() { //create rooms
	    Room foyer = new Room("The Foyer","a small foyer",
			"The small entryway of a modern apartment. A dining room is open to the west, where a large table can be seen." + "\n"
			+ "The hardwood floor leads north into a hallway, next to a staircase that leads up to a second floor." + "\n"
			+ "To the east is a small room, where you can see a small bar.");
	    //set exit array of Foyer to set room 123 or w.e.
		this.rooms[0] = foyer;
		
		
		
		Room diningHall = new Room("Dining Hall", "a room with long table and chairs",
			"A long table sits in the middle room lined with 3 chairs on each side and a chair on each head. A living room is" + "\n"
			+ "seen to the south of the room. A delicious smell is coming from the kitchen located on the northside. You" + "\n"
			+ "also see a painting hung on a wall overlooking the table.");
		this.rooms[1] = diningHall;
		
		Room bar = new Room("Bar", "a room filled with bottles of alcohol behind a bar and high table",
			"Bottles of alcohols line the bar as well as high tables around the room."
			+ "\n" + "A doorway back to the Foyer is on the west"
			);
		this.rooms[2] = bar;
		
		Room upstairs = new Room("Upstairs", "an upstairs hallway", 
				"You find yourself upstairs overlooking the foyer. You see a collection of rooms on the right"
				+ "and an office located on the left."
				);
		this.rooms[3] = upstairs;
		
		Room livingRoom = new Room("Living Room", "a cozy living room", 
				"Organized around a fireplace are some couches near the edges of the room."
				+ "\n" + "The doorway back to the Dining Room is on the north."
				);
		this.rooms[4] = livingRoom;
		
		Room kitchen = new Room("Kitchen", "sleek modern kitchen", 
				"The delicious smell of apple pie located on the island table fills the room with savory bliss." + "\n" +
				"This kitchen is filled with brand new stainless steel appliances and enough room worthy for Gordon Ramsay." + "\n" +
				"The exit to the Dining Room is on the south side."
				);
		this.rooms[5] = kitchen;
		
		Room bedroom = new Room("Bedroom", "the bedroom", 
				"You find yourself in a comfy bedroom with king size bed in the middle and modern decor adorning the room; "+ "\n" +
				"perfectly suitable for a bachelor/bachelorette. On the west end is the exit back to the hallway."
				
				);
		this.rooms[6] = bedroom;
		
		Room office = new Room("Office", "modern office room",
				"This small office room, has your basic desk and cabinets. A great view of the city is seen on the" + "\n" +
				"window on the edge of the room. The desk also comes equipped with a new SecretLab chair to sit in." + "\n" +
				"On the east end is the exit back to the hallway."
				);
		this.rooms[7] = office;
		Room nullRoom = new Room("Null Room", " ", " ");
		
	    this.startingRoom = foyer;
	    
	    foyer.exits = foyer.setExits(upstairs, bar,nullRoom, diningHall);
	    diningHall.exits= diningHall.setExits(kitchen, foyer, livingRoom, nullRoom);
	    bar.exits = bar.setExits(nullRoom, nullRoom, nullRoom, foyer);
	    upstairs.exits = upstairs.setExits(nullRoom, bedroom, foyer, office);
	    livingRoom.exits = livingRoom.setExits(diningHall, nullRoom, nullRoom, nullRoom);
	    kitchen.exits = kitchen.setExits(nullRoom, nullRoom, diningHall, nullRoom);
	    bedroom.exits = bedroom.setExits(nullRoom, nullRoom, nullRoom, upstairs);
	    office.exits = office.setExits(nullRoom, upstairs, nullRoom, nullRoom);
	    
	    
	    //Items
	    Room painting = new Room("Painting", "a painting", 
	    		"A beutiful painting of a centaur stands in the middle of the room."+ "\n" +
	    		"It's muscular frame and long flowing hair depicts an eerily similar visage of Fabio."
	    		);
	    Room bottles = new Room("Bottles", "bottles of alcohol",
	    		"You admire the amount of vintage alcohol in the back of the bar. You even see a bottle of" + "\n" +
	    			"black label in the back"
	    		);
	    Room fireplace = new Room("Fireplace", "a cozy fireplace",
	    		"The fireplace looks to be a greatplace to be around in winter or just whenever you want smores."
	    		);
	    Room applePie = new Room("Apple Pie", "warm apple pie",
	    		"The pie is still too hot to eat, but not to hot to get a good whiff of apple and spices."
	    		);
	    Room chair = new Room("Chair", "a fancy gaming chair",
	    		"You sit in the super fancy and expensive SecretLab chair. Nice"
	    		);
	    foyer.items = foyer.setExits(nullRoom, nullRoom, nullRoom, nullRoom);
	    diningHall.items = diningHall.setExits(painting, nullRoom, nullRoom, nullRoom);
	    bar.items = bar.setExits(bottles, nullRoom, nullRoom, nullRoom);
	    livingRoom.items = livingRoom.setExits(fireplace, nullRoom, nullRoom, nullRoom);
	    kitchen.items = kitchen.setExits(applePie, nullRoom, nullRoom, nullRoom);
	    office.items = office.setExits(chair, nullRoom, nullRoom, nullRoom);
	    upstairs.items = upstairs.setExits(nullRoom, nullRoom, nullRoom, nullRoom);
	    bedroom.items = bedroom.setExits(nullRoom, nullRoom, nullRoom, nullRoom);
	    
	    //foyer.items = {null};
	}
	
	
}
