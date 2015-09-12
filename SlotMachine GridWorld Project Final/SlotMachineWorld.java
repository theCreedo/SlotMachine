/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *SlotMachineWorld
 *Creates SlotMachineWorld class which creates and puts all the
 *Boxes into a world for the Slot Machine to function
 **/

import info.gridworld.grid.*;
import info.gridworld.world.*;

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.JFrame;

 import javax.swing.*;

import javax.swing.JOptionPane;

/*The SlotMachineWorld creates the world with all the
 *Boxes for the Slot Machine to function.
 */	
public class SlotMachineWorld extends ActorWorld
{
	
/*Creates the SlotMachineWorld
 *@param coinCount the amount of coins to be used
 *@param score the score the user has
 *@param jackpot the jackpot the user can get
 *@param difficulty the difficulty of the game
 */	
	public SlotMachineWorld(int coinCount, int score, int jackpot, int difficulty)
	{
		
		super(new BoundedGrid<Actor>(7,9));
		Grid<Actor> gr = getGrid();
		System.setProperty("info.gridworld.gui.selection", "hide"); // doesn’t show cell selection
		System.setProperty("info.gridworld.gui.tooltips", "hide"); // doesn’t show tooltips
		System.setProperty("info.gridworld.gui.frametitle", "Slot Machine"); // set your own title
		setMessage("Welcome");
		int num = 1000000;
		CoinAmountBox hmmmm = new CoinAmountBox(coinCount);
		hmmmm.putSelfInGrid(gr, new Location(0,8));
		ScoreAmountBox hmmmmm = new ScoreAmountBox(score);
		hmmmmm.putSelfInGrid(gr, new Location(1,8));
		
		CoinTextBox ok = new CoinTextBox();
		ok.putSelfInGrid(gr, new Location(0,7));
		ScoreBox okk = new ScoreBox();
		okk.putSelfInGrid(gr, new Location(1,7));
		
		for(int col = 0; col<7; col++)
		{
			LetterBox bob = new LetterBox(col);
			bob.putSelfInGrid(gr, new Location(0, col));
		}
		
		LightBox lol1 = new LightBox(2);
		LightBox lol2 = new LightBox(3);
		LightBox lol3 = new LightBox(0);
		LightBox lol4 = new LightBox(1);
		
		lol1.putSelfInGrid(gr, new Location(2, 0));
		lol2.putSelfInGrid(gr, new Location(2, 6));
		lol3.putSelfInGrid(gr, new Location(6, 0));
		lol4.putSelfInGrid(gr, new Location(6, 6));
		
		show();
		
					try
					{
						Thread.sleep(1000);
						
				System.out.println("sleep");
					}	catch(InterruptedException e){}
					
		ReelBox wow1 = new ReelBox(difficulty);
		ReelBox wow2 = new ReelBox(difficulty);
		ReelBox wow3 = new ReelBox(difficulty);
		
		wow1.putSelfInGrid(gr, new Location(3, 1));
		wow2.putSelfInGrid(gr, new Location(3, 3));
		wow3.putSelfInGrid(gr, new Location(3, 5));

		CoinBox no = new CoinBox();
		no.putSelfInGrid(gr, new Location(2, 8));

		PlayBox now = new PlayBox(coinCount, score, jackpot, super.getFrame());
		now.putSelfInGrid(gr, new Location(5, 8));
		
		for(int col = 1; col<6; col++)
		{
			LetterBox bill = new LetterBox(9);
			bill.putSelfInGrid(gr, new Location(2, col));
		}
		
		for(int col = 1; col<6; col++)
		{
			LetterBox bill = new LetterBox(10);
			bill.putSelfInGrid(gr, new Location(6, col));
		}
		
		for(int row = 3; row<6; row++)
		{
			LetterBox bill = new LetterBox(7);
			bill.putSelfInGrid(gr, new Location(row, 0));
		}
		for(int row = 3; row<6; row++)
		{
			LetterBox bill = new LetterBox(8);
			bill.putSelfInGrid(gr, new Location(row, 6));
		}
		
		int jtemp = jackpot;
		int ntemp = 1000000;
		int temp = jtemp;

		for(int col = 0; col <=6; col++)
		{

			temp = jtemp%ntemp;
			jtemp/=ntemp;
			
			ntemp/=10;
			System.out.println (temp);
			System.out.println (jtemp);
			System.out.println (ntemp);

			
			NumberBox hm = new NumberBox(jtemp, num);
			hm.putSelfInGrid(gr, new Location(1, col));
			jtemp = temp;
			num /= 10;
		}		
		show();
	}
	

/**
 *Asks the user if he wants to save, and if yes, saves
 *the SlotMachineWorld's jackpot, score, and coinCount
 *with the user's given name
 */	
    public void step() //throws FileNotFoundException
    {
	String lol = JOptionPane.showInputDialog(null, "Would you like to save game?");
		if(lol.equalsIgnoreCase("yes"))
		{
			try
			{
				int coin, score, pot;
				Grid<Actor> grid = getGrid();
				if(grid.get(new Location(5, 8)) != null)
				{
					Object bob = grid.get(new Location(5, 8));
					coin = ((PlayBox)bob).getCoinCount();
					score = ((PlayBox)bob).getScore();
					pot = ((PlayBox)bob).getJackpot();
					
					String name = JOptionPane.showInputDialog(null, "What would be the name you'd like to save your game under?");
					Scanner input = new Scanner(new FileReader("slotMachine.dat"));
			String temp = "";
			while(input.hasNextLine())
			{
				temp += input.nextLine() + "\n";
			}
				PrintWriter out = new PrintWriter("slotMachine.dat");
				out.println(temp);
				out.println(name);
				out.println(coin);
				out.println(score);
				out.println(pot);
				
				out.close();
				JOptionPane.showMessageDialog(null, "Your game has been saved to " + name);
		
				}
			}
			catch(IOException e)
			{}
		}
    }

}