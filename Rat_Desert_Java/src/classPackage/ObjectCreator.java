package classPackage;

import interfaces.*;

public class ObjectCreator {
    public static DesertInterface createNewDesert()
    {
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
    public static RatStatusInterface createNewRatID()
    {
        return new RatStatus();
    }
    
}