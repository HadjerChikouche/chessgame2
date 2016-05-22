package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PieceSquare[] board = initiliseBoard();
        displayBoard(board);
        move();
    }


    private static PieceSquare[] initiliseBoard() {

        PieceSquare[] board = new PieceSquare[64];

        board[0] = new PieceSquare("WR", "a1");
        board[1] = new PieceSquare("WN", "b1");
        board[2] = new PieceSquare("WB", "c1");
        board[3] = new PieceSquare("WQ", "d1");
        board[4] = new PieceSquare("WK", "e1");
        board[5] = new PieceSquare("WB", "f1");
        board[6] = new PieceSquare("WN", "g1");
        board[7] = new PieceSquare("WR", "h1");
        board[8] = new PieceSquare("WP", "a2");
        board[9] = new PieceSquare("WP", "b2");
        board[10] = new PieceSquare("WP", "c2");
        board[11] = new PieceSquare("WP", "d2");
        board[12] = new PieceSquare("WP", "e2");
        board[13] = new PieceSquare("WP", "f2");
        board[14] = new PieceSquare("WP", "g2");
        board[15] = new PieceSquare("WP", "h2");
        board[16] = new PieceSquare(null, "a3");
        board[17] = new PieceSquare(null, "b3");
        board[18] = new PieceSquare(null, "c3");
        board[19] = new PieceSquare(null, "d3");
        board[20] = new PieceSquare(null, "e3");
        board[21] = new PieceSquare(null, "f3");
        board[22] = new PieceSquare(null, "g3");
        board[23] = new PieceSquare(null, "h3");
        board[24] = new PieceSquare(null, "a4");
        board[25] = new PieceSquare(null, "b4");
        board[26] = new PieceSquare(null, "c4");
        board[27] = new PieceSquare(null, "d4");
        board[28] = new PieceSquare(null, "e4");
        board[29] = new PieceSquare(null, "f4");
        board[30] = new PieceSquare(null, "g4");
        board[31] = new PieceSquare(null, "h4");
        board[32] = new PieceSquare(null, "a5");
        board[33] = new PieceSquare(null, "b5");
        board[34] = new PieceSquare(null, "c5");
        board[35] = new PieceSquare(null, "d5");
        board[36] = new PieceSquare(null, "e5");
        board[37] = new PieceSquare(null, "f5");
        board[38] = new PieceSquare(null, "g5");
        board[39] = new PieceSquare(null, "h5");
        board[40] = new PieceSquare(null, "a6");
        board[41] = new PieceSquare(null, "b6");
        board[42] = new PieceSquare(null, "c6");
        board[43] = new PieceSquare(null, "d6");
        board[44] = new PieceSquare(null, "e6");
        board[45] = new PieceSquare(null, "f6");
        board[46] = new PieceSquare(null, "g6");
        board[47] = new PieceSquare(null, "h6");
        board[48] = new PieceSquare("BP", "a7");
        board[49] = new PieceSquare("BP", "b7");
        board[50] = new PieceSquare("BP", "c7");
        board[51] = new PieceSquare("BP", "d7");
        board[52] = new PieceSquare("BP", "e7");
        board[53] = new PieceSquare("BP", "f7");
        board[54] = new PieceSquare("BP", "g7");
        board[55] = new PieceSquare("BP", "h7");
        board[56] = new PieceSquare("BR", "a8");
        board[57] = new PieceSquare("BN", "b8");
        board[58] = new PieceSquare("BB", "c8");
        board[59] = new PieceSquare("BQ", "d8");
        board[60] = new PieceSquare("BK", "e8");
        board[61] = new PieceSquare("BB", "f8");
        board[62] = new PieceSquare("BN", "g8");
        board[63] = new PieceSquare("BR", "h8");


        return board;

    }

    private static void displayBoard(PieceSquare[] board) {

        System.out.print("   a " + "  b " + "  c " + "  d " + "  e " + "  f " + "  g " + "  h ");

        int k = 0;
        for (int i=0 ; i < 64; i++) {
            k=+k;
            if (i%8 == 0) {
                System.out.println();
                k++;
                System.out.print(k+" ");
            }
            PieceSquare pieceSquare = board[i];

            if(pieceSquare.getPiece() == null){
                System.out.print(" *  ");
            }else{
                System.out.print(" " + pieceSquare.getPiece() + " ");
            }
        }
    }

    private static void move(){
        Scanner in = new Scanner(System.in);
        PieceSquare[] board = initiliseBoard();
        MoteurDeRegles moteurDeRegles;
        while(true){
            System.out.println();
            System.out.println(" Please Enter the position of the piece that you want to play : ");
            String from = in.nextLine();
            System.out.println("Please enter the position you want it to be in ");
            String to = in.nextLine();

            moteurDeRegles = new MoteurDeRegles();
            String piece = getPieceByPosition(from, board);
            if (moteurDeRegles.pawnRules(from, to, piece) == false){
                System.out.println("this move is not possible try something else");
                displayBoard(board);
            }else{
                move(board, from, to);
                displayBoard(board);
            }
        }
    }

    private static void move(PieceSquare[] board, String from, String to) {
        String piece = null;
        for (int i = 0; i < 64; i++) {
            if (board[i].getSquare().equals(from)) {
                piece = board[i].getPiece();
                board[i].setPiece(null);
            }
        }
        for (int i = 0; i < 64; i++) {
            if (board[i].getSquare().equals(to)) {
                board[i].setPiece(piece);
            }
        }
    }

    private static String getPieceByPosition(String from, PieceSquare[] board) {
        for (PieceSquare pieceSquare : board) {
            if(from.equals(pieceSquare.getSquare())){
                return pieceSquare.getPiece();
            }
        }
        return null;
    }
}