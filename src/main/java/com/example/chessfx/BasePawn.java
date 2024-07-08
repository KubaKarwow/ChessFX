package com.example.chessfx;

import java.util.List;

public class BasePawn {
    PawnColor color;

    int currentXlocation;
    int currentYlocation;
    int amountOfMoves=0;
    BasePawn(PawnColor type,  int currentYlocation,int currentXlocation){
        this.color =type;
        this.currentXlocation=currentXlocation;
        this.currentYlocation=currentYlocation;
    }
    public List<Point> showPossibilities(List<List<Area>> gameMap){
        System.out.println("man i dont do shit here");
        return null;
    }

}
