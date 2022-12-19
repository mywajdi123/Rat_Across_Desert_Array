package classPackage;

import java.security.SecureRandom;
import java.util.ArrayList;

import interfaces.*;

public class Cell implements CellInterface {
    public int[] pLocation = new int[2];
    public ArrayList<RatInterface> ratAl = new ArrayList<RatInterface>();
    public ArrayList<RatInterface> deadRatAl = new ArrayList<RatInterface>();

    public Cell() {
        pLocation[0] = -1;
        pLocation[1] = -1;
    }

    public Cell(int[] pLocation) {
        this.pLocation[0] = pLocation[0];
        this.pLocation[1] = pLocation[1];
    }

    @Override
    public char getCellType() {
        String type = this.getClass() .toString();
        char cellType = ' ';
        if(type.contains("Cell")) {
            cellType = 'C';
        }else if(type.contains("Hole")) {
            cellType = 'H';
        }
        return cellType;
    }

    @Override
    public int[] receiveRat(RatInterface pRat) {
        ratAl.add(pRat);
        SecureRandom sRand = new SecureRandom();
        int op = sRand.nextInt(2);
        if(op == 0) {
            pRat.refresh();
        }else {
            pRat.wearDown();
        }
        if(((Rat)pRat).energy < 6) {
            storeTheDead(pRat);
        }
        return pLocation;
    }
    @Override
    public RatInterface retrieveRat(String pRatID) {
        RatInterface rat = ObjectCreator.createNewRat();
        for(RatInterface pRat:ratAl) {
            if(pRat.getId() == pRatID) {
                rat = pRat;
                break;
            }
        }
        return rat;
    }

    @Override
    public void storeTheDead(RatInterface pRat) {
        ((Rat)pRat).rState.setRatState(1);
        deadRatAl.add(pRat);
    }

    @Override
    public ArrayList<RatInterface> returnTheDead() {
        return deadRatAl;
    }
    
}
