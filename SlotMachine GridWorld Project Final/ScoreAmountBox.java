/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *ScoreAmountBox
 *Creates ScoreAmountBox class contains the score of the player
 **/

/**
 *ScoreAmountBox shows the score the player has
 */
public class ScoreAmountBox extends Box
{
private int score;

/**
 *Creates the ScoreAmountBox with a given score
 *@param givenScore the given score for the player
 */
public ScoreAmountBox(int givenScore)
{
	score = givenScore;	
}

/**
 *Gets the text in ScoreAmountBox
 *@return the score for ScoreAmountBox
 */
public String getText()
{
	return "" + score;
}

/**
 *Adds to the score a certain amount
 *@param add a certain amount of points to the score
 */
public void add(int add)
{
	score += add;
}

}