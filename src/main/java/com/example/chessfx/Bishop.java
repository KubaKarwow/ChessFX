package com.example.chessfx;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends BasePawn {

    Bishop(PawnColor type, int currentYlocation, int currentXlocation) {
        super(type, currentYlocation, currentXlocation);
    }

    @Override
    public String toString() {
        return "Bishop at (" + currentXlocation + ", " + currentYlocation + ") (x,y)";
    }

    @Override
    public List<Point> showPossibilities(List<List<Area>> gameMap) {
        List<Point> result = new ArrayList<>();
        int yIndex = currentYlocation;
        for (int xIndex = currentXlocation + 1; xIndex <= 7; xIndex++) { //45'
            yIndex--;
            if (yIndex == -1) {
                break;
            }
            if (gameMap.get(yIndex).get(xIndex).pawn == null) {
                result.add(new Point(yIndex, xIndex));
            } else {
                if (gameMap.get(yIndex).get(xIndex).pawn.color != this.color) {
                    result.add(new Point(yIndex, xIndex));
                }
                break;
            }
        }
        yIndex = currentYlocation;
        for (int xIndex = currentXlocation + 1; xIndex <= 7; xIndex++) { //135'
            yIndex++;
            if (yIndex == 8) {
                break;
            }
            if (gameMap.get(yIndex).get(xIndex).pawn == null) {
                result.add(new Point(yIndex, xIndex));
            } else {
                if (gameMap.get(yIndex).get(xIndex).pawn.color != this.color) {
                    result.add(new Point(yIndex, xIndex));
                }
                break;
            }
        }
        yIndex = currentYlocation;
        for (int xIndex = currentXlocation - 1; xIndex >= 0; xIndex--) { //225'
            yIndex++;
            if (yIndex == 8) {
                break;
            }
            if (gameMap.get(yIndex).get(xIndex).pawn == null) {
                result.add(new Point(yIndex, xIndex));
            } else {
                if (gameMap.get(yIndex).get(xIndex).pawn.color != this.color) {
                    result.add(new Point(yIndex, xIndex));
                }
                break;
            }
        }
        yIndex = currentYlocation;
        for (int xIndex = currentXlocation - 1; xIndex >= 0; xIndex--) { //315'
            yIndex--;
            if (yIndex == -1) {
                break;
            }
            if (gameMap.get(yIndex).get(xIndex).pawn == null) {
                result.add(new Point(yIndex, xIndex));
            } else {
                if (gameMap.get(yIndex).get(xIndex).pawn.color != this.color) {
                    result.add(new Point(yIndex, xIndex));
                }
                break;
            }
        }
        return result;
    }
}
