/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *Date: 5/28/2014
 *SlotMachine
 *Creates SlotMachine class which creates the SlotMachineWorld
 **/

/**
 *Contains the background information for the SlotMachineWorld and instantiates SlotMachineWorld
 */
public class SlotMachine
{
private int jackpot;
private int coinCount;
private int score;
private int difficulty;
	
	
	/**
	 *Creates the SlotMachine with an initial coin count of 10, a score of 0
	 *a jackpot of 10000, and an easy difficulty. Also creates the SlotMachineWorld
 	 */
	public SlotMachine()
	{	
		coinCount = 10;
		score = 0;
		jackpot = 10000;
		difficulty = 0;
		SlotMachineWorld world = new SlotMachineWorld(coinCount, score, jackpot, 0);
	}
	
	/**
	 *Creates the SlotMachine with a given coin count, a given score 
	 *a given jackpot, and a given difficulty. Also creates the SlotMachineWorld
	 *@param givenCoinCount the given coin count
	 *@param givenScore the given score
	 *@param givenJackpot the given Jackpot
	 *@param givenDifficulty the given difficulty
 	 */
	public SlotMachine(int givenCoinCount, int givenScore, int givenJackpot, int givenDifficulty)
	{
		SlotMachineWorld world = new SlotMachineWorld(givenCoinCount, givenScore, givenJackpot, givenDifficulty);
		coinCount = givenCoinCount;
		score = givenScore;
		jackpot = givenJackpot;
		difficulty = givenDifficulty;
	}

}