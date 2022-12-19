package classPackage;

import java.security.SecureRandom;
import java.util.ArrayList;

import interfaces.*;

public class Hole extends Cell implements HoleInterface {
    int lostSoulCount = 0;
    static ArrayList<Hole> holeList = new ArrayList<Hole>();
    public Hole() {
        pLocation[0] = -1;
        pLocation[1] = -1;
    }
    
    public Hole(int[] pLocation) {
        this.pLocation[0] = pLocation[0];
        this.pLocation[1] = pLocation[1];
        holeList.add(this);
    }

    @Override 
    public int[] receiveRat(RatInterface pRat) {
        ratAl.add(pRat);
        SecureRandom sRand = new SecureRandom();
        int random = sRand.nextInt(10);
        int nextHole = sRand.nextInt(holeList.size());

        switch(random) {
            case 0:
                ((Rat)pRat).pLocation[0] = -1;
                ((Rat)pRat).pLocation[1] = -1;
                storeTheDead(pRat);
                lostSoulCount++;
                break;
            case 1: case 2: case 3:
                break;
            default:
                ((Rat)pRat).pLocation[0] = holeList.get(nextHole).pLocation[0];
                ((Rat)pRat).pLocation[1] = holeList.get(nextHole).pLocation[1];
                break;
        }
        return pLocation;
    }

    @Override
    public int countLostSouls() {
        return lostSoulCount;
    }
}