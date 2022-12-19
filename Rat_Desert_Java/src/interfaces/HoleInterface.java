package interfaces;

/**
 * 
 * @author Larry Shannon
 *
 */

public interface HoleInterface extends CellInterface
{
	/**
	 * The receiveRat() method receives a rat,<br>
	 * then randomly determines if the rat went down the hole<br>
	 *   to another cell<br>
	 *   to disappear/escape<br>
	 *   or stayed at this location<br>
	 * @param RatInterface holds reference to Rat object
	 * @return 
	 * Returns {row,col}<br>
	 * new row , col of cell rat is ends up in
	 * -1,-1 if rat disappears 
	 */
	public int[] receiveRat(RatInterface pRat);
	
	/**
	 * @return
	 * count of rats that have disappeared
	 */
	public int countLostSouls();
}