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
    public boolean pawnRules(String from, String to, String pieceFrom, String pieceTo){
        if (pieceFrom.substring(1).equals("P")) {
            return backwardsRule(from, to, pieceFrom) && singleMoveRule(from, to, pieceFrom) && dontEatWhenDirect(from, to, pieceTo);
        }
        return true;
    }

    private boolean dontEatWhenDirect(String from, String to, String pieceTo) {

        String tO = to.substring(0,1);
        String fRom = from.substring(0,1);

        if(pieceTo != null && tO.equals(fRom)){
            return false;
        }

        return true;
    }

    private boolean twoSquaresAtFirst(String from, String to, String piece) {

        int tO = Integer.valueOf(to.substring(1));
        int fRom = Integer.valueOf(from.substring(1));

        if(piece.substring(0).equals("WP")){

            if (from.substring(1).equals("2") && tO-fRom==2){
                return true;
            }
        }

        if(piece.substring(0).equals("BP")){
            if(from.substring(1).equals("7") && fRom- tO == 2){
                return true;
            }
        }



        return false;
    }

    private boolean singleMoveRule(String from, String to, String piece) {
        if (twoSquaresAtFirst(from,to,piece)==true){
            twoSquaresAtFirst(from,to,piece);
        }else {
            int tO = Integer.valueOf(to.substring(1));
            int fRom = Integer.valueOf(from.substring(1));
            if (piece.substring(0).equals("WP")) {

                if (tO - fRom != 1) {
                    return false;
                }
            }

            if (piece.substring(0).equals("BP")) {
                if (fRom - tO != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean backwardsRule(String from, String to, String piece) {
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
        return true;
    }
}
