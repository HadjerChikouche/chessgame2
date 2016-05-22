package com.company;

/**
 * Created by hadjer on 22/05/16.
 */
public class MoteurDeRegles {



//*pown can't move backwards
// It can move a single square
// If it's its first move ,he has the option to move two squares
// if a square in front of him is occupied ,it can't move
//can't capture it nor move over it *//
    public boolean pawnRules(String from,String to,String piece){
        if (piece.substring(1).equals("P")){
            int tO = Integer.valueOf(to.substring(1));
            int fRom = Integer.valueOf(from.substring(1));

            if(piece.substring(0).equals("WP")){

                if (tO<fRom){
                    return false;
                }
            }

            if(piece.substring(0).equals("BP")){
                if(tO > fRom){
                    return false;
                }
            }
        }
        return true;
    }
}
