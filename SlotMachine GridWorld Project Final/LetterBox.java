/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *LetterBox
 *Creates LetterBox class which spells the word Jackpot
 **/


import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *LetterBox makes one of the letters of the word Jackpot
 */
public class LetterBox extends Box
{
private int value;

	/**
	 *Creates the LetterBox with a given value for a letter
	 *@param value the image value representing a letter
	 */
	public LetterBox(int givenValue)
	{
		value = givenValue;

	}
	
	/**
	 *Gets the Color of the LetterBox
	 *@return the Color of the LetterBox
	 */
	public Color getColor()
	{
		return null;
	}
	
	/**
	 * Used to determine which box letter should be displayed for this
	 * tile object.  Uses value.
	 * @return the image suffix for the gif representing this tile
	 */
	public String getImageSuffix()
	{
		switch(value)
		{
			case 0: return "_J";
			case 1: return "_A";
			case 2: return "_C";
			case 3: return "_K";
			case 4: return "_P";
			case 5: return "_O";
			case 6: return "_T";
			case 7: return "_LeftLine";
			case 8: return "_RightLine";
			case 9: return "_TopLine";
			case 10: return "_BottomLine";
				default: return "";
		}
	}
}