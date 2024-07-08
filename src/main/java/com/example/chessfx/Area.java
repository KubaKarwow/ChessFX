package com.example.chessfx;

public class Area {
        TypeOfArea typeOfArea;
        PawnType typeOfPawn;

        BasePawn pawn;

        Area(TypeOfArea typeOfArea){
                this.typeOfArea=typeOfArea;
        }
        Area(TypeOfArea typeOfArea,BasePawn pawn, PawnType typeOfPawn){
                this.typeOfArea=typeOfArea;
                this.pawn=pawn;
                this.typeOfPawn=typeOfPawn;

        }
}
