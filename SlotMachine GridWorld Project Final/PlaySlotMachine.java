/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *PlaySlotMachine
 *Creates PlaySlotMachine class which plays the SlotMachine. Asks to
 *load game, and if so, asked for name to load. If unloadable, will ask again.
 *Will ask what difficulty the user would like it in, then loads the SlotMachine.
 **/

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *Starts the game for SlotMachine
 */
public class PlaySlotMachine
{
	
	public static void main(String args[]) throws IOException
	{

		
		JOptionPane.showMessageDialog(null, "Hi, Welcome to the Fun and Games Slot Machine!");

		String lol = JOptionPane.showInputDialog(null, "Would you like to load your previous game (if you have played before)?");
		if(lol.equalsIgnoreCase("yes"))
		{	int score= 0, jackpot = 10000, coinCount = 10; 	
			boolean check = false;
			while(!check)
			{

			Scanner input = new Scanner(new FileReader("slotMachine.dat"));			
			String no = JOptionPane.showInputDialog(null, "What name would you like to load? \n(Type New for a new game if after several attempts, name could not be found.)");

			while(input.hasNextLine())
			{
				if(no.equals(input.nextLine()) && !check)
				{
					System.out.println ("wow");

					coinCount = Integer.parseInt(input.nextLine());
   					score = Integer.parseInt(input.nextLine());
   					jackpot = Integer.parseInt(input.nextLine());
   					check = true;
   					
				}
				else
				{
					System.out.println (coinCount);
					System.out.println (input.nextLine());
					System.out.println (input.nextLine());
					System.out.println (input.nextLine());
					if(input.hasNextLine())
					{
					System.out.println (input.nextLine());
					}
					System.out.println ("lolz");
				}
			}
			if(!check)
			{
				JOptionPane.showMessageDialog(null, "I'm sorry. The name you asked for could not be found. Try again!");
			}	

			}
			
			boolean well = false;
			int temp = 0;
			do
			{
			String difficulty = JOptionPane.showInputDialog(null, "What difficulty would you like it on? (easy/hard)");
			if(!difficulty.equalsIgnoreCase("easy") && !difficulty.equalsIgnoreCase("hard"))
			{
				JOptionPane.showMessageDialog(null, "I'm sorry, that wasn't a difficulty. Please select again. (easy/hard)");
			}
			else
			{
				if(difficulty.equalsIgnoreCase("easy"))
				{
					temp = 0;
				}
				else
				{
					temp = 1;
				}
				well = true;
			}
			
			}while(!well);
			
   			SlotMachine wow = new SlotMachine(coinCount, score, jackpot, temp);

			JOptionPane.showMessageDialog(null, "*You have received "+ coinCount + " coins.*");
			JOptionPane.showMessageDialog(null, "Good Luck at the slots!!!");   			
		}
		else
		{	
			boolean well = false;
			int temp = 0;
			do
			{
			String difficulty = JOptionPane.showInputDialog(null, "What difficulty would you like it on? (easy/hard)");
			if(!difficulty.equalsIgnoreCase("easy") && !difficulty.equalsIgnoreCase("hard"))
			{
				JOptionPane.showMessageDialog(null, "I'm sorry, that wasn't a difficulty. Please select again. (easy/hard)");
			}
			else
			{
				if(difficulty.equalsIgnoreCase("easy"))
				{
					temp = 0;
				}
				else
				{
					temp = 1;
				}
				well = true;
			}
			
			}while(!well);
			
			SlotMachine wow = new SlotMachine(10, 0, 10000, temp);

			JOptionPane.showMessageDialog(null, "*You have received 10 coins.*");
			JOptionPane.showMessageDialog(null, "Good Luck at the slots!!!");
		}

				
		
	}
}