package classPackage;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.*;


public class ControlDriver {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String op = "y";
        String option;

        do {
            System.out.println("Create a new desert(y/n):");
            option = input.nextLine();
            if(option.startsWith("y")) {
                ArrayList<String> ratIDList = new ArrayList<String>();
                DesertInterface d1 = ObjectCreator.createNewDesert();
                op = "y";
                while(op.startsWith("y")) {
                    RatStatusInterface ratStatus = d1.startRat();
                    ratIDList.add(ratStatus.getRatID());

                    
                while(ratStatus.getRatState() == 0){
                    ratStatus = d1.moveRat(ratIDList.get(ratIDList.size()-1));
                }
                if(ratStatus.getRatState() == 1) {
                    System.out.println("Rat lost or dead. Start with a new rat(y/n)?");
                    op = input.nextLine();
                }else if(ratStatus.getRatState() == -1) {
                    System.out.println("Rat Finished. Start with a new rat(y/n)?");
                    op = input.nextLine();
                }
            }
            ((Desert)d1).printMap();
            ((Desert)d1).displayStatistics();
        }else {
            option = "n";

        }
    }while(option.startsWith("y"));
}
}