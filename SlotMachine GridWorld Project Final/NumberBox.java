/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *NumberBox
 *Creates NumberBox class which displays the Jackpot Number
 **/

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *The NumberBox creates the numbers that display the Jackpot
 */
public class NumberBox extends Box
{
	private int numValue;
	private int value;
	
	/**
	 *Creates the NumberBox with a given unit value and given number value
	 *@param givenValue the unit value of the NumberBox
	 *@param givenNumValue the number value of the NumberBox
	 */
	public NumberBox(int givenValue, int givenNumValue)
	{
		value = givenValue;
		numValue = givenNumValue;
	}
	
	/**
	 *Adds to the number value of the NumberBox. If
	 *the NumberBox has a number value greater than 10
	 *the NumberBox with a higher unit value gets increased by one
	 *and the number value of the current NumberBox gets set to 0;
	 */
	public void work()
	{

		if(numValue == 1)
		{
			value++;
		}
		if(value >= 10 && numValue!= 1000000)
		{
			Grid gr = getGrid();
			Object noob = gr.get(getLocation().getAdjacentLocation(Location.WEST));
			((NumberBox) (noob)).addValue();
			value = 0;
		}
	}
	
	/**
	 *Gets the number value of the NumberBox
	 *@return the number value of the NumberBox
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 *Gets the unit value of the NumberBox
	 *@return the unit value of the NumberBox
	 */
	public int getNumValue()
	{
		return numValue;
	}
	/**
	 *Adds one to the number value of the NumberBox
	 */
	public void addValue()
	{
		value++;
	}
	
	/**
	 * Used to determine which box number should be displayed for this
	 * NumberBox object.  Uses value.
	 * @return the image suffix for the gif representing this tile
	 */
	public String getImageSuffix()
	{
		switch(value)
		{
			case 0: return "_0";
			case 1: return "_1";
			case 2: return "_2";
			case 3: return "_3";
			case 4: return "_4";
			case 5: return "_5";
			case 6: return "_6";
			case 7: return "_7";
			case 8: return "_8";
			case 9: return "_9";
				default: return "";
		}
	}
}