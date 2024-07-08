package com.example.chessfx;

public class Point {
    int xPos;
    int yPos;
    boolean enPassant=false;
    boolean castling=false;
    Point(int y, int x){
        xPos=x;
        yPos=y;
    }
    Point(int y, int x,boolean enPassant){
        xPos=x;
        yPos=y;
        this.enPassant=enPassant;

    }
    Point( boolean castling,int y, int x){
        xPos=x;
        yPos=y;
        this.castling=castling;
    }
    @Override
    public String toString(){
        return "y-"+yPos+" x-"+xPos;
    }

}
