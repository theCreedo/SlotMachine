/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *CoinBox
 *Creates CoinBox class which decides whether PlayBox
 *can be played. Then takes a coin.
 **/
 
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *The CoinBox creates a box with the slot to insert coins.
 */
public class CoinBox extends Box
{
	private boolean insertable;
	
	/**
	 *Creates a CoinBox with default color red and is insertable
	 */
	public CoinBox()
	{
		insertable = true;
		setColor(Color.RED);
	}

	
	/**
	 *Gets whether coins are insertable into CoinBox 
	 *@return whether coins are insertable
	 */
	public boolean getInsertable()
	{
		return insertable;
	}
	
	/**
	 *Checks to see if the box is insertable. if it is
	 *then it becomes uninsertable, and the Playbox becomes null color.
	 *The CoinAmountBox is subtracted one coin
	 */
	public void act()
	{	
		if(insertable == true)
		{
		insertable = false;
		setColor(null);
		((PlayBox)getGrid().get(new Location(5, 8))).setColor(null);
		((CoinAmountBox)getGrid().get(new Location(0, 8))).subtractCoin();
		}
		
	}
	
	/**
	 *Sets CoinBox to be insertable or not
	 *@param givenInsert whether the button is insertable or not
	 */
	public void setInsertable(boolean givenInsert)
	{
		insertable = givenInsert;
	}
	
	
}