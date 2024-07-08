package com.example.chessfx;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends BasePawn {
    // jezeli jestes na poczatku to moze sie ruszyc o 1/2
    // rusza sie tylko do przodu
    // jezeli zbijasz to tylko po przekatnej
    // jezeli dojdzie do konca to mozesz go wymienic na wszystko oprocz króla

    int startPositionX;
    int startPositionY;
    boolean passedBy = false;

    Pawn(PawnColor type, int currentYlocation, int currentXlocation) {
        super(type, currentYlocation, currentXlocation);
        this.startPositionX = currentXlocation;
        this.startPositionY = currentYlocation;
    }

    @Override
    public String toString() {
        return "Pawn at (" + currentXlocation + ", " + currentYlocation + ") (x,y)";
    }

    @Override
    public List<Point> showPossibilities(List<List<Area>> gameMap) {

        List<Point> result = new ArrayList<>();
        if (this.color == PawnColor.White) {
            if (gameMap.get(currentYlocation - 1).get(currentXlocation).typeOfArea == TypeOfArea.Empty) {
                if (startPositionX == currentXlocation && startPositionY == currentYlocation) {
                    result.add(new Point(currentYlocation - 1, currentXlocation));
                    passedBy = false;
                    if (gameMap.get(currentYlocation - 2).get(currentXlocation).typeOfArea == TypeOfArea.Empty) {
                        result.add(new Point(currentYlocation - 2, currentXlocation));
                        passedBy = true;
                    }
                } else {
                    result.add(new Point(currentYlocation - 1, currentXlocation));
                    passedBy = false;
                }
            }
            // bicia
            if (currentXlocation != 0) {
                if (gameMap.get(currentYlocation - 1).get(currentXlocation - 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation - 1).get(currentXlocation - 1).pawn.color == PawnColor.Black) {
                    result.add(new Point(currentYlocation - 1, currentXlocation - 1));
                }
                if (gameMap.get(currentYlocation).get(currentXlocation - 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).pawn.color == PawnColor.Black) {
                }
                if (gameMap.get(currentYlocation).get(currentXlocation - 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).pawn.color == PawnColor.Black
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).pawn.amountOfMoves == 1
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).typeOfPawn == PawnType.Pawn
                        && currentYlocation == 3) {
                    result.add(new Point(currentYlocation - 1, currentXlocation - 1, true)); // 3rd argument here is used for the sake of "passing by" rule
                }
            }
            if (currentXlocation != 7) {
                if (gameMap.get(currentYlocation - 1).get(currentXlocation + 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation - 1).get(currentXlocation + 1).pawn.color == PawnColor.Black) {
                    result.add(new Point(currentYlocation - 1, currentXlocation + 1));
                }
                // en passant
                if (gameMap.get(currentYlocation).get(currentXlocation + 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation).get(currentXlocation + 1).pawn.color == PawnColor.Black
                        && gameMap.get(currentYlocation).get(currentXlocation + 1).pawn.amountOfMoves == 1
                        && gameMap.get(currentYlocation).get(currentXlocation + 1).typeOfPawn == PawnType.Pawn
                        && currentYlocation == 3) {
                    result.add(new Point(currentYlocation - 1, currentXlocation + 1, true)); // 3rd argument here is used for the sake of "passing by" rule
                }

            }
        } else { // zachowania czarnych pionkow
            if (gameMap.get(currentYlocation + 1).get(currentXlocation).typeOfArea == TypeOfArea.Empty) {
                if (startPositionX == currentXlocation && startPositionY == currentYlocation) {
                    result.add(new Point(currentYlocation + 1, currentXlocation));
                    if (gameMap.get(currentYlocation + 2).get(currentXlocation).typeOfArea == TypeOfArea.Empty) {
                        result.add(new Point(currentYlocation + 2, currentXlocation));
                    }
                } else {
                    result.add(new Point(currentYlocation + 1, currentXlocation));
                }
            }
            // bicia czarnych :D
            if (currentXlocation != 0) {
                if (gameMap.get(currentYlocation + 1).get(currentXlocation - 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation + 1).get(currentXlocation - 1).pawn.color == PawnColor.White) {
                    result.add(new Point(currentYlocation + 1, currentXlocation - 1));
                }
                if (gameMap.get(currentYlocation).get(currentXlocation - 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).pawn.color == PawnColor.White
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).pawn.amountOfMoves == 1
                        && gameMap.get(currentYlocation).get(currentXlocation - 1).typeOfPawn == PawnType.Pawn
                        && currentYlocation == 4) {
                    result.add(new Point(currentYlocation + 1, currentXlocation - 1, true)); // 3rd argument here is used for the sake of "passing by" rule
                }
            }
            if (currentXlocation != 7) {
                if (gameMap.get(currentYlocation + 1).get(currentXlocation + 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation + 1).get(currentXlocation + 1).pawn.color == PawnColor.White) {
                    result.add(new Point(currentYlocation + 1, currentXlocation + 1));
                }
                if (gameMap.get(currentYlocation).get(currentXlocation + 1).typeOfArea == TypeOfArea.Taken
                        && gameMap.get(currentYlocation).get(currentXlocation + 1).pawn.color == PawnColor.White
                        && gameMap.get(currentYlocation).get(currentXlocation + 1).pawn.amountOfMoves == 1
                        && gameMap.get(currentYlocation).get(currentXlocation + 1).typeOfPawn == PawnType.Pawn
                        && currentYlocation == 4) {
                    result.add(new Point(currentYlocation + 1, currentXlocation + 1, true)); // 3rd argument here is used for the sake of "passing by" rule
                }
            }
        }
     //   System.out.println(result);
        return result;
    }
}

