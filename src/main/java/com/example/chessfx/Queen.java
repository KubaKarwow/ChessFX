package com.example.chessfx;

import java.util.ArrayList;
import java.util.List;

public class Queen extends BasePawn{

    Queen(PawnColor type,  int currentYlocation,int currentXlocation) {
        super(type, currentYlocation, currentXlocation);
    }
    @Override
    public String toString() {
        return "Queen at (" + currentXlocation + ", " + currentYlocation + ") (x,y)";
    }
    @Override
    public List<Point> showPossibilities(List<List<Area>> gameMap){
        List<Point> result = new ArrayList<>();
        for (int i = this.currentXlocation - 1; i >= 0; i--) { // left
            if (gameMap.get(currentYlocation).get(i).pawn == null) {
                result.add(new Point(currentYlocation, i));
            } else {
                if (gameMap.get(currentYlocation).get(i).pawn.color != this.color) {
                    result.add(new Point(currentYlocation, i));
                }
                break;
            }
        }
        for (int i = this.currentXlocation + 1; i <= 7; i++) { // right
            if (gameMap.get(currentYlocation).get(i).pawn == null) {
                result.add(new Point(currentYlocation, i));
            } else {
                if (gameMap.get(currentYlocation).get(i).pawn.color != this.color) {
                    result.add(new Point(currentYlocation, i));
                }
                break;
            }
        }
        for (int i = this.currentYlocation - 1; i >= 0; i--) {   // up
            if (gameMap.get(i).get(currentXlocation).pawn == null) {
                result.add(new Point(i, currentXlocation));
            } else {
                if (gameMap.get(i).get(currentXlocation).pawn.color != this.color) {
                    result.add(new Point(i, currentXlocation));
                }
                break;
            }
        }
        for (int i = this.currentYlocation + 1; i <= 7; i++) { // down
            if (gameMap.get(i).get(currentXlocation).pawn == null) {
                result.add(new Point(i, currentXlocation));
            } else {
                if (gameMap.get(i).get(currentXlocation).pawn.color != this.color) {
                    result.add(new Point(i, currentXlocation));
                }
                break;
            }
        }
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

