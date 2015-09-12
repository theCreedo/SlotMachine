/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *CoinAmountBox
 *Creates CoinAmountBox class with the coin amount the player has
 **/

/**
 *The CoinAmountBox contains the coin amount the player has
 */
public class CoinAmountBox extends Box
{
private int coinCount;

/**
 *Creates the CoinAmountBox with a given coinCount
 *@param givenCoinCountThe coin amount for the CoinAMount Box
 */
public CoinAmountBox(int givenCoinCount)
{
	coinCount = givenCoinCount;	
}

/**
 *Gets the coin count for the CoinAmountBox
 *@return the coin count for the CoinAmountBox
 */
public String getText()
{
	return "" + coinCount;
}

/**
 *Subtracts one coin in the coin amount
 */
public void subtractCoin()
{
	coinCount--;
}

/**
 *Adds an amount of coins to the coinCount
 *@param add the ammount of coins added to coin Count
 */
public void add(int add)
{
	coinCount+= add;
}


}