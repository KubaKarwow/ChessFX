package com.example.chessfx;

import java.util.ArrayList;
import java.util.List;

public class Knight extends BasePawn{
    Knight(PawnColor type,  int currentYlocation,int currentXlocation) {
        super(type, currentYlocation, currentXlocation);
    }
    @Override
    public String toString(){
        return "Knight at ("+currentXlocation+", "+currentYlocation+") (x,y)";
    }
    @Override
    public List<Point> showPossibilities(List<List<Area>> gameMap) {
        List<Point> possibilities= new ArrayList<>();
        List<Point> result = new ArrayList<>();
        possibilities.add(new Point(currentYlocation-2,currentXlocation-1));
        possibilities.add(new Point(currentYlocation-2,currentXlocation+1));
        possibilities.add(new Point(currentYlocation+2,currentXlocation-1));
        possibilities.add(new Point(currentYlocation+2,currentXlocation+1));
        possibilities.add(new Point(currentYlocation-1,currentXlocation-2));
        possibilities.add(new Point(currentYlocation+1,currentXlocation-2));
        possibilities.add(new Point(currentYlocation-1,currentXlocation+2));
        possibilities.add(new Point(currentYlocation+1,currentXlocation+2));

        for(Point point: possibilities){
            if(point.xPos>=0 && point.xPos<=7){
                if(point.yPos>=0 && point.yPos<=7){
                    result.add(point);
                }
            }
        }

        possibilities.removeAll(possibilities);

        for(int i=0; i<result.size(); i++){
            if (gameMap.get(result.get(i).yPos).get(result.get(i).xPos).pawn==null){
                possibilities.add(result.get(i));
            } else{
                if(gameMap.get(result.get(i).yPos).get(result.get(i).xPos).pawn.color!=this.color){
                    possibilities.add(result.get(i));
                }
            }
        }
        return possibilities;
    }

}

