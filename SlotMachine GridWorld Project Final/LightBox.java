/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *LibhtBox
 *Creates LightBox class which flashes lights in random
 *colors on the Slot Machine
 **/

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *The LightBox creates a box that lights up in random colors
 */
public class LightBox extends Box
{	
private int value;
	
	/**
	 *Creates the LightBox with a given image value and a random color
	 *@param givenValue the given image value
	 */
	public LightBox(int givenValue)
	{
		value = givenValue;
		setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
	}
	
	/**
	 *Gets the color of the Light Box
	 *return the color of the LightBox
	 */	
	public Color getColor()
	{
		return super.getColor();
	}

	/**
	 *Changes the color of the LightBox to a random color
	 */
	public void act()
	{
		setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
	}
	
	/**
	 * Used to determine which box corner should be displayed for this
	 * LightBox object.  Uses value.
	 * @return the image suffix for the gif representing this tile
	 */
	public String getImageSuffix()
	{
		switch(value)
		{
			case 0: return "_BotLCorner";
			case 1: return "_BotRCorner";
			case 2: return "_TopLCorner";
			case 3: return "_TopRCorner";
				default: return "";
		}
	}
}