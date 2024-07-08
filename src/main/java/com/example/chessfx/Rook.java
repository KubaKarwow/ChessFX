package com.example.chessfx;

import java.util.ArrayList;
import java.util.List;

public class Rook extends BasePawn {
    Rook(PawnColor type, int currentYlocation, int currentXlocation) {
        super(type, currentYlocation, currentXlocation);
    }

    @Override
    public String toString() {
        return "Rook at (" + currentXlocation + ", " + currentYlocation + ") (x,y)";
    }

    @Override
    public List<Point> showPossibilities(List<List<Area>> gameMap) {
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
            for (int i = this.currentYlocation + 1; i <= 7; i++) {
                if (gameMap.get(i).get(currentXlocation).pawn == null) {
                    result.add(new Point(i, currentXlocation));
                } else {
                    if (gameMap.get(i).get(currentXlocation).pawn.color != this.color) {
                        result.add(new Point(i, currentXlocation));
                    }
                    break;
                }
            }
            return result;
        }
    }

