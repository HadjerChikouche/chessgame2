package com.company;

/**
 * Created by hadjer on 17/05/16.
 */
public class PieceSquare {

    private String piece;
    private String square;

    public PieceSquare(String piece, String square) {
        this.piece = piece;
        this.square = square;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }
}
