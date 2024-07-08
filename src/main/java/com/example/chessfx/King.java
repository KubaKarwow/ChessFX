package com.example.chessfx;

import java.util.ArrayList;
import java.util.List;

public class King extends BasePawn {
    King(PawnColor type, int currentYlocation, int currentXlocation) {
        super(type, currentYlocation, currentXlocation);
    }

    @Override
    public String toString() {
        return "King at (" + currentXlocation + ", " + currentYlocation + ") (x,y)";
    }

    @Override
    public List<Point> showPossibilities(List<List<Area>> gameMap) {
        List<Point> toCheck = new ArrayList<>();
        List<Point> result= new ArrayList<>();
        toCheck.add(new Point(currentYlocation - 1, currentXlocation + 1));
        toCheck.add(new Point(currentYlocation - 1, currentXlocation));
        toCheck.add(new Point(currentYlocation - 1, currentXlocation - 1));
        toCheck.add(new Point(currentYlocation, currentXlocation + 1));
        toCheck.add(new Point(currentYlocation, currentXlocation - 1));
        toCheck.add(new Point(currentYlocation + 1, currentXlocation + 1));
        toCheck.add(new Point(currentYlocation + 1, currentXlocation));
        toCheck.add(new Point(currentYlocation + 1, currentXlocation - 1));
        List<Point> properIndexes= new ArrayList<>();
        for(Point point : toCheck){
            if((point.xPos>=0 && point.xPos<=7) && (point.yPos>=0 && point.yPos<=7)){
                properIndexes.add(point);
            }
        }
     //   System.out.println("first stage "+ properIndexes);
        BasePawn rememberPawn=gameMap.get(this.currentYlocation).get(currentXlocation).pawn;
        TypeOfArea rememberArea=gameMap.get(this.currentYlocation).get(currentXlocation).typeOfArea;
        PawnType rememberType=gameMap.get(this.currentYlocation).get(currentXlocation).typeOfPawn;
        gameMap.get(this.currentYlocation).get(this.currentXlocation).pawn=null;
        gameMap.get(this.currentYlocation).get(this.currentXlocation).typeOfPawn=PawnType.None;
        gameMap.get(this.currentYlocation).get(this.currentXlocation).typeOfArea=TypeOfArea.Empty;



        // we have to take care of the king not being able to move close to the other king
        int yOfOtherKing=0;
        int xOfOtherKing=0;
        for(int i=0; i<gameMap.size(); i++){
            for(int j=0; j< gameMap.get(i).size(); j++){
                if(gameMap.get(i).get(j).pawn!=null){
                    if(gameMap.get(i).get(j).typeOfPawn==PawnType.King && gameMap.get(i).get(j).pawn.color!=this.color){
                        yOfOtherKing=i;
                        xOfOtherKing=j;
                    }
                }
            }
        }
        List<Point> otherKingMoves= new ArrayList<>();
        List<Point> actualProperIndexes = new ArrayList<>();
        otherKingMoves.add(new Point(yOfOtherKing - 1, xOfOtherKing + 1));
        otherKingMoves.add(new Point(yOfOtherKing - 1, xOfOtherKing));
        otherKingMoves.add(new Point(yOfOtherKing - 1, xOfOtherKing - 1));
        otherKingMoves.add(new Point(yOfOtherKing, xOfOtherKing + 1));
        otherKingMoves.add(new Point(yOfOtherKing, xOfOtherKing - 1));
        otherKingMoves.add(new Point(yOfOtherKing + 1, xOfOtherKing + 1));
        otherKingMoves.add(new Point(yOfOtherKing + 1, xOfOtherKing));
        otherKingMoves.add(new Point(yOfOtherKing + 1, xOfOtherKing - 1));
        for(Point point : properIndexes){
            boolean goodPoint=true; //XD
            for(Point point2: otherKingMoves){
                if(point2.yPos==point.yPos && point2.xPos==point.xPos){
                    goodPoint=false;
                }
            }
            if(goodPoint){
                actualProperIndexes.add(point);
            }
        }

        // LOCATION OF KING IS SET TO NULL PAWN ^^
        for(Point point : actualProperIndexes){
            if(gameMap.get(point.yPos).get(point.xPos).pawn==null){
                if(!Controller.checkIfInDanger(gameMap,this.color,point.yPos, point.xPos)){
                 //   System.out.println("an empty area at "+point.yPos+","+point.xPos+" is not in danger");
                    result.add(point);
                }
            }
            else{
                if(gameMap.get(point.yPos).get(point.xPos).pawn.color!=this.color){
                    Area toRestoreLater= gameMap.get(point.yPos).get(point.xPos);
                  //  gameMap.get(point.yPos).get(point.xPos).typeOfPawn=PawnType.None;
                 //   gameMap.get(point.yPos).get(point.xPos).pawn=null;
                 //   gameMap.get(point.yPos).get(point.xPos).typeOfArea=TypeOfArea.Empty;
                    if(!Controller.checkIfInDanger(gameMap,this.color, point.yPos, point.xPos)){
                    //    System.out.println("a taken area at "+point.yPos+","+point.xPos+" is not in danger");
                        result.add(point);
                    }
                    System.out.println(toRestoreLater.typeOfPawn + " "+toRestoreLater.pawn + " "+ toRestoreLater.typeOfArea);
               //     gameMap.get(point.yPos).get(point.xPos).typeOfPawn=toRestoreLater.typeOfPawn;
               //     gameMap.get(point.yPos).get(point.xPos).pawn=toRestoreLater.pawn;
                //    gameMap.get(point.yPos).get(point.xPos).typeOfArea=toRestoreLater.typeOfArea;
                }
            }
        }
      //  System.out.println("after checking in danger "+result);
        gameMap.get(this.currentYlocation).get(this.currentXlocation).pawn=rememberPawn;
        gameMap.get(this.currentYlocation).get(this.currentXlocation).typeOfPawn=rememberType;
        gameMap.get(this.currentYlocation).get(this.currentXlocation).typeOfArea=rememberArea;

        // castling
        // 1 warunek: krol i wieza z ktora chcemy sie zamienic musza miec startowe pozycje
        // 2 warunek krol nie moze byc pod atakiem
        // 3 warunek droga ktora krol musi przebyc nie moze byc pod atakiem
        // czyli ze krol o 2 w prawo/lewo i wieza o za niego
        if(gameMap.get(this.currentYlocation).get(7).pawn!=null){
            if (this.amountOfMoves == 0 && gameMap.get(this.currentYlocation).get(7).pawn.amountOfMoves == 0) { // prawa roszada
                if (gameMap.get(this.currentYlocation).get(6).pawn == null && gameMap.get(this.currentYlocation).get(5).pawn == null) {
                    // pola miedzy nimi sa wolne
                    boolean test1 = isUnderSiege(gameMap, currentYlocation, currentXlocation, this.color);
                    boolean test2 = isUnderSiege(gameMap, currentYlocation, currentXlocation + 1, this.color);
                    boolean test3 = isUnderSiege(gameMap, currentYlocation, currentXlocation + 2, this.color);
                    if (!test1 && !test2 && !test3 ) {
                        result.add(new Point(true, currentYlocation, 6));
                    }
                }
            }
        }
         if(gameMap.get(this.currentYlocation).get(0).pawn!=null){
             if (this.amountOfMoves == 0 && gameMap.get(this.currentYlocation).get(0).pawn.amountOfMoves == 0) { // left one
                 if(gameMap.get(currentYlocation).get(1).pawn==null && gameMap.get(currentYlocation).get(2).pawn==null && gameMap.get(currentYlocation).get(3).pawn==null){
                     boolean test1 = isUnderSiege(gameMap, currentYlocation, currentXlocation, this.color);
                     boolean test2 = isUnderSiege(gameMap, currentYlocation, currentXlocation - 1, this.color);
                     boolean test3 = isUnderSiege(gameMap, currentYlocation, currentXlocation - 2, this.color);
                     if (!test1 && !test2 && !test3 ) {
                         result.add(new Point(true, currentYlocation, 2));
                     }
                 }
             }
         }
        return result;
    }

    public boolean isUnderSiege(List<List<Area>> gameMap, int y, int x, PawnColor color) {
        for (int i = 0; i < gameMap.size(); i++) {
            for (int j = 0; j < gameMap.get(i).size(); j++) {
                if (gameMap.get(i).get(j).pawn != null) {
                    if (gameMap.get(i).get(j).pawn.color != color && gameMap.get(i).get(j).typeOfPawn!=PawnType.King) {
                        List<Point> possibilitesOfEnemy = gameMap.get(i).get(j).pawn.showPossibilities(gameMap);
                        if (Controller.isMatchingPoint(x, y, possibilitesOfEnemy)) {
                            System.out.println("can be attacked by ("+i+","+j+")");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}

