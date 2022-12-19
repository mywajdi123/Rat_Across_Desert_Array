package classPackage;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.*;

public class Desert implements DesertInterface{
    Scanner input = new Scanner(System.in);
    RatInterface rat;
    CellInterface[][] ci;
    ArrayList<RatInterface> ratAl = new ArrayList<RatInterface>();

    public Desert() {
        System.out.println("Enter the number of rows of the desert:");
        int row = input.nextInt();
        System.out.println("Enter the number of columns of the desert:");
        int column = input.nextInt();
        System.out.println("Enter the number of holes:");
        int holes = input.nextInt();
        ci = new CellInterface[row][column];
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                int[] pLocation = new int[2];
                pLocation[0] = i;
                pLocation[1] = j;
                ci[i][j] = ObjectCreator.createNewCell(pLocation);
            }
        }
        SecureRandom sRand = new SecureRandom();
        int[] pLocation = new int[2];
        for(int h=0;h<holes ;h++) {
            int hRow = sRand.nextInt(row);
            int hColumn = sRand.nextInt(column);
            if(!ci[hRow][hColumn].getClass().toString().contains("Hole")) {
                pLocation[0] = hRow;
                pLocation[1] = hColumn;
                ci[hRow][hColumn] = ObjectCreator.createNewHoleCell(pLocation);
            }
            else {
                h--;
            }
        }
    }
    
    @Override
    public RatStatusInterface startRat() {
        rat = ObjectCreator.createNewRat();
        ratAl.add(rat);
        return ((Rat)rat).rState;
    }

    @Override
    public RatStatusInterface moveRat(String pRatID) {
        int ciRow = 0, ciColumn = 0;

        if(rat.getId().equals(pRatID) && rat.getAliveState() == 0) {
            rat.move ();
            ciRow = ((Rat)rat).pLocation[0];
            ciColumn = ((Rat)rat).pLocation[1];

            if(ciRow < 0) {
                ciRow = 0;
                ((Rat)rat).wearDown();}
            else if(ciRow >= ci.length) {
                ciRow = ci.length - 1;
                ((Rat)rat).wearDown();}
            if(ciColumn < 0) {
                ciColumn = 0;
                ((Rat)rat).wearDown();
            }else if(ciColumn >= ci[0].length){
                ciColumn = ci[0].length - 1;
                ((Rat)rat).wearDown();
            }

            ((Rat)rat).path.add((java.nio.file.Path) new Path(ciRow, ciColumn));

            ci[ciRow][ciColumn].receiveRat(rat);
            if(ciRow == ci.length-1 && ciColumn == ci[0].length-1) {
                ((Rat)rat).rState.setRatState(-1);
            }
        }
        return ((Rat)rat).rState;
    }

    @Override
    public void displayStatistics() {
        System.out.println("\nStatistics:");
        System.out.println("Rats that die in the cell:");
        for(int i=0;i<ci.length;i++) {
            for(int j=0;j<ci[i].length;j++) {
                System.out.print(((Cell)ci[i][j]).deadRatAl.size() + " ");

            }
            System.out.println();
        }

        System.out.println("\nRats that disappear down its hole:");
        for(int i=0;i<ci.length;i++) {
            for(int j=0; j<ci[i].length;j++) {
                if(((Cell)ci[i][j])instanceof Hole)
                    System.out.println("Hole "+ i + " " + j + " disappear count " + ((Hole)ci[i][j]).countLostSouls() + "");
            }
        }

        int finishedCount = 0, unfinishedCount = 0;
        for(RatInterface ri:ratAl) {
            if(((Rat)ri).getAliveState() == -1) {
                finishedCount++;
            }else {
                unfinishedCount++;
            }
        }
        double total = finishedCount + unfinishedCount;
        System.out.printf("finished rate is: %3.2f%%\n", finishedCount/total*100);
        System.out.printf("lost/dead rate is: %3.2f%%\n", unfinishedCount/total*100);

        for(RatInterface ri:ratAl) {
            if(((Rat)ri).getAliveState() == -1) {
                System.out.print("Finished:     ");
            }else {
                System.out.print("Lost or dead: ");
            }
            System.out.println(((Rat)ri).path);
        }
    }

    @Override
    public void printMap() {
        System.out.println("Cell type map:");
        for(int i=0;i<ci.length;i++) {
            for(int j=0;j<ci[i].length;j++) {
                System.out.print(ci[i][j].getCellType() + " ");
            }
            System.out.println();
        }

        System.out.println("Cell counts for rats' moves:");
        for(int i=0;i<ci.length;i++) {
            for(int j=0;j<ci[i].length;j++) {
                System.out.print(((Cell)ci[i][j]).ratAl.size() + " ");

            }
            System.out.println();
        }
    }
}