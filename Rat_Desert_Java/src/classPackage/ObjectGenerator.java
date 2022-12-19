/**
 * 
 */
package classPackage;

import interfaces.CellInterface;
import interfaces.DesertInterface;
import interfaces.HoleInterface;
import interfaces.RatInterface;
import interfaces.RatStatusInterface;

/**
 * @author Larry
 *
 */
public class ObjectGenerator
{
	public static DesertInterface createNewDesert()
	{
		Object pLocation;
		return new Desert();
	}
	public static CellInterface createNewCell(int[] pLocation)
	{
		return new Cell(pLocation);
	}
	public static HoleInterface createNewHoleCell(int[] pLocation)
	{
		return new Hole(pLocation);
	}
	public static RatInterface createNewRat()
	{
		return new Rat();
	}
	public static RatStatusInterface createNewRatID(String pID, int pState)
	{
		return new RatStatus();
	}
}

