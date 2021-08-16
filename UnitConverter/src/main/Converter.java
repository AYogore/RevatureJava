package main;
import java.util.Scanner; //needed to use scanner obj
public class Converter {
	
	public static void main(String args[]) // Shortcut: main ctrl+Space
	{
		boolean statement = false;
		
		
		Intro(); //ascii art to make things look prettier
		Menu(); //void of menu select
		Scanner menu = new Scanner(System.in); //initialize scanner obj
		int selection = menu.nextInt();
		
		
		while(statement == false)
		{
			if (selection < 1 || selection > 4) //validate selection is within bounds
			{
				System.out.println("Please Enter a Valid Answer"); //if out of bounds repeat statement
				Menu();
				selection = menu.nextInt();
			}
			else {
				
				switch(selection) 
				{
				case 1:
					CollectQuantity("cups", "teaspoons");
					selection = menu.nextInt();
					if (selection < 0)
					{
						System.out.println("Please Enter a Valid Answer");
						CollectQuantity("cups", "teaspoons");
					}
					else 
					{
						System.out.println(selection + " cups converts to " + ConvertCupsToTeaspoons(selection) + " teaspoons");					
					}
					
					break;
				case 2:
					CollectQuantity("miles", "kilometers");
					selection = menu.nextInt();
					if (selection < 0)
					{
						System.out.println("Please Enter a Valid Answer");
						CollectQuantity("miles", "kilometers");
					}
					else 
					{
						System.out.println(selection + " miles converts to " + ConvertMilesToKilometers(selection) + " kilometers");					
					}//How many miles would you like to convert to kilometers?:
					//entry miles equals output teaspoons.
					break;
				case 3:
					CollectQuantity("pounds", "kilograms");
					selection = menu.nextInt();
					if (selection < 0)
					{
						System.out.println("Please Enter a Valid Answer");
						CollectQuantity("pounds", "kilograms");
					}
					else 
					{
						System.out.println(selection + " pounds converts to " + ConvertPoundsToKilograms(selection) + " kilograms");					
					}
					//How many cups would you like to convert?:
					//entry cups equals output teaspoons.
					break;
				case 4:
					statement = true; //ends loop
					break;
				}
				
				if(statement == false)
				{
					
					Continue(); //continue if user wants to keep using converter
					selection = menu.nextInt();
					boolean con = false;
					while (con == false)
					{
						if (selection < 1 || selection > 2) 
						{
							System.out.println("Please Enter a Valid Answer");
							Continue();
							selection = menu.nextInt();
						}
						else if(selection == 1) //close valid loop, stay in while loop
						{
							con = true;
							//restart while loop by asking menu question
							Menu();
							selection = menu.nextInt();
						}
						else if(selection == 2) //close loop, scanner,  and finish while loop
						{
							con = true;
							statement = true;
							menu.close();
						}
						
					}
				}
						
				
			}
			
		}
		//switch
	}
	
	

	public static void Intro() 
	{
		//insert ASCII art and Intro text
	}
	
	public static void Menu()
	{
		System.out.println("Please select an option:\r\n"
				+ "1. Cups to Teaspoons\r\n"
				+ "2. Miles to Kilometers\r\n"
				+ "3. US Gallons to Imperial Gallons\r\n"
				+ "4. Quit");
		
	}
	
	public static void CollectQuantity(String unit1, String unit2)
	{
		System.out.println("How many " + unit1 + " would you like to convert to " + unit2 + "?: ");
	}
	
	public static double ConvertCupsToTeaspoons(double quantity)
	{
		return quantity * 48;
	}
	public static double ConvertMilesToKilometers(double quantity)
	{
		return quantity * 1.6;
	}
	public static double ConvertPoundsToKilograms(double quantity)
	{
		return quantity * 2.2;
	}
	
	public static void Continue()
	{
		System.out.println("Would you like to do another conversion? (1 for YES, 2 for NO):");
		
	}
	

	
	
	
}
