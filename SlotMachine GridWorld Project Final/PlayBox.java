/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *PlayBox
 *Creates PlayBox class which works the other boxes in the
 *GridWorld SlotMachineWorld
 **/
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.gui.WorldFrame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.JOptionPane;

/**
 *The PlayBox creates a box that plays the slot machine
 */
public class PlayBox extends Box
{

private boolean pushable;
private int jackpot;
private int coinCount;
private int score;
private boolean win;
private JFrame frame;
	
	/**
	 *Creates PlayBox with a given coin count, score, jackpot, and JFrame
	 *@param givenCoinCount the coin amount of the player
	 *@param givenScore the score of the player
	 *@param givenJackpot the Jackpot of the slot machine
	 *@param givenFrame the JFrame of the GridWorld
	 */
	public PlayBox(int givenCoinCount, int givenScore, int givenJackpot, JFrame givenFrame)
	{
		pushable = false;
		win = false;
		jackpot = givenJackpot;
		coinCount = givenCoinCount;
		score= givenScore;
		setColor(Color.WHITE);
		frame = givenFrame;
	}
	
	/**
	 *Gets if PlayBox is pushable
	 *@return if PlayBox is pushable
	 */
	public boolean getPushable()
	{
		return pushable;
	}
	
	/**
	 *If the PlayBox button is pushable, when pressed,
 	 *is will start the slot machine, turning all the reels. It maintains
	 *the LightBoxes and ReelBoxes and gives the score and coin account
	 *for the ScoreBoxDisplay and CoinAmountBoxDisplay
	 *When game is done, it will ask if the game wants to be played again.
	 *If so, then the difficulty will be asked.
	 *If not, then the game exits.
	 */
	public void act()
	{
		
		if(pushable = true && ((CoinBox)getGrid().get(new Location(2, 8))).getInsertable() == false)
		{
			coinCount--;
			System.out.println (coinCount);
//			if(coinCount <= 0)
			Grid gr = getGrid();
			ReelBox r1 = ((ReelBox)getGrid().get(new Location(3, 1)));
			ReelBox r2 = ((ReelBox)getGrid().get(new Location(3, 3)));
			ReelBox r3 = ((ReelBox)getGrid().get(new Location(3, 5)));
			LightBox l1 = ((LightBox)getGrid().get(new Location(2, 0)));
			LightBox l2 = ((LightBox)getGrid().get(new Location(2, 6)));
			LightBox l3 = ((LightBox)getGrid().get(new Location(6, 0)));
			LightBox l4 = ((LightBox)getGrid().get(new Location(6, 6)));

			pushable = false;
			int spin = 10;
		
//			r1.blur((int) (Math.random()*4));
//			r2.blur((int) (Math.random()*4));
//			r3.blur((int) (Math.random()*4));
			for(int i = 0; i<=spin; i++)
			{
			l1.act();
			l2.act();
			l3.act();
			l4.act();
				if(i<=spin-5)
				{
					
					r1.blur((int) (Math.random()*4));
					r2.blur((int) (Math.random()*4));
					r3.blur((int) (Math.random()*4));

					frame.update(frame.getGraphics());
					
					try
					{
						Thread.sleep(5);
					}
					catch(InterruptedException e){}
				Object obj = new Object();
				obj = null;
				System.gc();
				}
			else
			if(i<=spin-8)
			{
					r1.work();
					r2.work();
					r3.work();	
					frame.update(frame.getGraphics());
				try
				{
				Thread.sleep(200);
				}	
				catch(InterruptedException e){}
				Object obj = new Object();
				obj = null;
				System.gc();
			}
			else
			{			
					r1.work();
					r2.work();
					r3.work();	
					frame.update(frame.getGraphics());
				try
				{
				Thread.sleep(500);
				}	
				catch(InterruptedException e){}
				Object obj = new Object();
				obj = null;
				System.gc();
			}
			
			}


			ScoreAmountBox s4 = ((ScoreAmountBox)getGrid().get(new Location(1, 8)));			


			NumberBox l = ((NumberBox)getGrid().get(new Location(1, 6)));
			l.work();
			jackpot++;
			((CoinBox)getGrid().get(new Location(2, 8))).setInsertable(true);
			((CoinBox)getGrid().get(new Location(2, 8))).setColor(Color.RED);
			setColor(Color.white);
			CoinAmountBox c4 = ((CoinAmountBox)getGrid().get(new Location(0, 8)));
			System.out.println ("Hey");
			System.out.println (coinCount);
			if(r1.getImageSuffix().equals(r2.getImageSuffix()) && r2.getImageSuffix().equals(r3.getImageSuffix()))
			{
				if(r1.getImageSuffix().equals("_Cherry"))
				{
				s4.add(3);
				c4.add(3);
				coinCount +=3;
				score+=3;
				}
				if(r1.getImageSuffix().equals("_Grape"))
				{
				s4.add(5);
				c4.add(5);
				coinCount+=5;
				score+=5;
				}
				if(r1.getImageSuffix().equals("_Orange"))
				{
				s4.add(10);
				c4.add(10);
				coinCount+=10;
				score+=10;
				}
				if(r1.getImageSuffix().equals("_Red7"))
				{
				s4.add(jackpot);
				c4.add(jackpot);
				score+=jackpot;
				coinCount+=jackpot;
				jackpot = 10000;
				win = true;
				}
			}
			else
			if((r1.getImageSuffix().equals(r2.getImageSuffix())&& r1.getImageSuffix().equals("_Cherry")) || (r3.getImageSuffix().equals(r2.getImageSuffix())&& r2.getImageSuffix().equals("_Cherry")) || (r1.getImageSuffix().equals(r3.getImageSuffix()) && r1.getImageSuffix().equals("_Cherry")))
			{
				s4.add(1);
				c4.add(1);
				coinCount++;
			}
			else
			if(coinCount <= 0|| win == true)
			{
				System.out.println ("Hello");
				if(win == true)
				{
				JOptionPane.showMessageDialog(null, "Congrats! You Won the Jackpot!");
				win = false;
				int num = 1000000;
				for(int col = 6; col >=0; col--)
				{

				NumberBox hm = new NumberBox(0, num);
				hm.putSelfInGrid(gr, new Location(1, col));
				num /= 10;
				}	
				NumberBox ha = new NumberBox(1, 10000);
				ha.putSelfInGrid(gr, new Location(1, 2));
				
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Good game. You're out of coins! You're end score is " + score);
				String ok = JOptionPane.showInputDialog(null, "Would you like to play again?");
				if(ok.equalsIgnoreCase("yes"))
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
				
				coinCount = 10;
				jackpot = 10000;
				score = 0;
				CoinAmountBox heh = new CoinAmountBox(10);
				ScoreAmountBox how = new ScoreAmountBox(0);
				heh.putSelfInGrid(gr, new Location(0,8));
				how.putSelfInGrid(gr, new Location(1,8));
				ReelBox wow1 = new ReelBox(temp);
				ReelBox wow2 = new ReelBox(temp);
				ReelBox wow3 = new ReelBox(temp);
				
				wow1.putSelfInGrid(gr, new Location(3, 1));
				wow2.putSelfInGrid(gr, new Location(3, 3));
				wow3.putSelfInGrid(gr, new Location(3, 5));
				int num = 1000000;
				for(int col = 6; col >=0; col--)
				{

				NumberBox hm = new NumberBox(0, num);
				hm.putSelfInGrid(gr, new Location(1, col));
				num /= 10;
				}	
				NumberBox ha = new NumberBox(1, 10000);
				ha.putSelfInGrid(gr, new Location(1, 2));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ok, Bye!");
					System.exit(0);
				}
				}
			}
		}
	}
	
	/**
	 *Gets the coin account of the player
	 *@return the coin amount of the player
	 */
	public int getCoinCount()
	{
		return coinCount;
	}
	
	/**
	 *Sets the coin amount for the player
	 *@param givenCoinCount the coin amount for the player
	 */
	public void setCoinCount(int givenCoinCount)
	{
		coinCount = givenCoinCount;
	}
	
	/**
	 *Gets the score of the player
	 *@return the score of the player
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 *Sets the score for the player
	 *@param givenScore the score for the player
	 */
	public void setScore(int givenScore)
	{
		score = givenScore;
	}
	
	/**
	 *Gets the jackpot of the slot machine
	 *@return the jackpot of the player
	 */
	public int getJackpot()
	{
		return jackpot;
	}
		
	/**
	 *Sets the jackpot for the slot machine
	 *@param givenJackpot the jackpot for the slot machine
	 */
	public void setJackpot(int givenJackpot)
	{
		jackpot = givenJackpot;
	}
	
	/**
	 *Adds to the score of the player
	 *@param add the score amount added to the player's score
	 */
	public void addScore(int add)
	{
		score+= add;
	}
	/**
	 *Adds to the coin amount of the player
	 *@param add the coin amount added to the player's coin amount
	 */
	public void addCoin(int add)
	{
		coinCount += add;
	}
}