/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *ReelBox
 *Creates ReelBox class which shows the images of the slot
 *machine and decides whether the player gets money or not
 **/

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *ReelBox is the reel of the SLot Machine with all the pictures
 *that determine whether the player gets any money or not.
 */
public class ReelBox extends Box
{
	
//public final int RANDOM_TYPE = (int)(Math.random() * 4) + 2;
private int type;
private int difficulty;

	/**
	 *Creates the ReelBox with a random reel image and easy difficulty
	 */
	public ReelBox()
	{
		type = (int)(Math.random() * 4)+4;
		difficulty = 0;
	}
	
	/**
	 *Creates the ReelBox with a given reel image and a given difficulty
	 *@param givenType given reel image reference
	 *@param givenDifficulty given difficulty of slot machine
	 */	
	public ReelBox(int givenType, int givenDifficulty)
	{
		difficulty = givenDifficulty;
		type = givenType;
	}
	
	/**
	 *Creates the ReelBox with a random reel image and a given difficulty
	 *@param givenDifficulty given difficulty of slot machine
	 */	
	public ReelBox(int givenDifficulty)
	{
		type = (int)(Math.random() * 4)+4;
		difficulty = givenDifficulty;
	}
	
	/**
	 *Changes the reel image to a random algorithmic reel image
	 *depending on the difficulty
	 */
	public void work()
	{
		if(difficulty == 1)
		{
			int temp= (int)(Math.random() * 100);	
			if(temp<30)
			{
				type = 4;
			}
			else if(temp<55)
			{
				type = 5;
			}
			else if(temp< 75)
			{
				type = 6;
			}
			else
			{
				type = 7;
			}
			
			if(type == 7)
			{
				temp= (int)(Math.random() * 100);
				if(temp<25)
				{
					type = 4;
				}
				else if(temp<50)
				{
					type = 5;
				}
				else if(temp< 75)
				{
					type = 6;
				}
				else
				{
					type = 7;
				}
			}	
		}
		else
		{
			type= (int)(Math.random()*4) + 4;
		}
		
	}
	
	/**
	 *Gets the color of the ReelBox
	 *@return the color of the ReelBox
	 */
	public Color getColor()
	{
		return null;
	}
	
	/**
	 *Given blur number which blurs the reel image
	 */
	public void blur(int blur)
	{
		type = blur;
	}
	
	/**
	 * Used to determine which image should be displayed for this
	 * tile object.  Uses value.
	 * @return the image suffix for the gif representing this tile
	 */
	public String getImageSuffix()
	{
		switch(type)
		{
			case 0: return "_Blur1";
			case 1: return "_Blur2";
			case 2: return "_Blur3";
			case 3: return "_Blur4";			
			case 4: return "_Cherry";
			case 5: return "_Orange";
			case 6: return "_Grape";
			case 7: return "_Red7";
			default: return "";
		}
	}
}