package com.example.chessfx;

public class Move {
    int startY,startX,endY,endX;
    Move(int startY, int startX, int endY, int endX){
        this.startX=startX;
        this.startY=startY;
        this.endX=endX;
        this.endY=endY;
    }
    @Override
    public String toString(){
        return "("+startY+","+startX+") -> ("+ endY+","+endX+")";
    }
}
