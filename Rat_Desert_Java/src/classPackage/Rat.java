package classPackage;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ArrayList;

import interfaces.*;


public class Rat implements RatInterface{
    RatStatusInterface rState;
    public int[] pLocation = new int[2];
    public int energy = 50;
    public ArrayList<Path> path = new ArrayList<Path>();

    public Rat() {
        rState = ObjectCreator.createNewRatID();
       // path.add(new Path(0, 0));
  
    }

    @Override
    public String move() {
        SecureRandom sRand = new SecureRandom();
        int direction = sRand.nextInt(8);
        switch(direction) {
            case 0: pLocation[1] -= 1; return "N";
            case 1: pLocation[0] -= 1; pLocation[1] -= 1; return "NW";
            case 2: pLocation[0] -= 1; return "W";
            case 3: pLocation[0] -= 1; pLocation[1] += 1; return "SW";
            case 4: pLocation[1] += 1; return "S";
            case 5: pLocation[0] += 1; pLocation[1] += 1; return "SE";
            case 6: pLocation[0] += 1; return "E";
            case 7: pLocation[0] += 1; pLocation[1] -= 1; return "NE";
        }
        return null;
    }

    @Override
    public int getAliveState() {
        if(rState != null) {
            return rState.getRatState();

        }else {
            return -1;
        }
    }

    @Override
    public void refresh() {
        energy += 1;

    }

    @Override 
    public void wearDown() {
        energy -= 1;
        
    }

    @Override
    public String getId() {
        
        return null;
    }
}