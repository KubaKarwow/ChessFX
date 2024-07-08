package com.example.chessfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private List<List<Label>> mapLabels = new ArrayList<>();
    boolean isOver=false;
    List<List<Area>> gameMap = new ArrayList<>();
    PawnColor currentTurn;
    boolean selectedAPawn = false;
    @FXML
    private Label A1, B1, C1, D1, E1, F1, G1, H1,
            A2, B2, C2, D2, E2, F2, G2, H2,
            A3, B3, C3, D3, E3, F3, G3, H3,
            A4, B4, C4, D4, E4, F4, G4, H4,
            A5, B5, C5, D5, E5, F5, G5, H5,
            A6, B6, C6, D6, E6, F6, G6, H6,
            A7, B7, C7, D7, E7, F7, G7, H7,
            A8, B8, C8, D8, E8, F8, G8, H8;  // labels


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        char blackPawn = '♟';
        A2.setText(blackPawn + "");
        B2.setText(blackPawn + "");
        C2.setText(blackPawn + "");
        D2.setText(blackPawn + "");
        E2.setText(blackPawn + "");
        F2.setText(blackPawn + "");
        G2.setText(blackPawn + "");
        H2.setText(blackPawn + "");
        //  ^^correcting text at black pawns
        List<Label> row1 = new ArrayList<>();
        row1.add(A1);
        row1.add(B1);
        row1.add(C1);
        row1.add(D1);
        row1.add(E1);
        row1.add(F1);
        row1.add(G1);
        row1.add(H1);
        List<Label> row2 = new ArrayList<>();
        row2.add(A2);
        row2.add(B2);
        row2.add(C2);
        row2.add(D2);
        row2.add(E2);
        row2.add(F2);
        row2.add(G2);
        row2.add(H2);
        List<Label> row3 = new ArrayList<>();
        row3.add(A3);
        row3.add(B3);
        row3.add(C3);
        row3.add(D3);
        row3.add(E3);
        row3.add(F3);
        row3.add(G3);
        row3.add(H3);
        List<Label> row4 = new ArrayList<>();
        row4.add(A4);
        row4.add(B4);
        row4.add(C4);
        row4.add(D4);
        row4.add(E4);
        row4.add(F4);
        row4.add(G4);
        row4.add(H4);
        List<Label> row5 = new ArrayList<>();
        row5.add(A5);
        row5.add(B5);
        row5.add(C5);
        row5.add(D5);
        row5.add(E5);
        row5.add(F5);
        row5.add(G5);
        row5.add(H5);
        List<Label> row6 = new ArrayList<>();
        row6.add(A6);
        row6.add(B6);
        row6.add(C6);
        row6.add(D6);
        row6.add(E6);
        row6.add(F6);
        row6.add(G6);
        row6.add(H6);
        List<Label> row7 = new ArrayList<>();
        row7.add(A7);
        row7.add(B7);
        row7.add(C7);
        row7.add(D7);
        row7.add(E7);
        row7.add(F7);
        row7.add(G7);
        row7.add(H7);
        List<Label> row8 = new ArrayList<>();
        row8.add(A8);
        row8.add(B8);
        row8.add(C8);
        row8.add(D8);
        row8.add(E8);
        row8.add(F8);
        row8.add(G8);
        row8.add(H8);
        mapLabels.add(row1);
        mapLabels.add(row2);
        mapLabels.add(row3);
        mapLabels.add(row4);
        mapLabels.add(row5);
        mapLabels.add(row6);
        mapLabels.add(row7);
        mapLabels.add(row8); // setting up gameMap
        gameMap = generateMap();
        currentTurn = PawnColor.White;
    }

    public List<List<Area>> generateMap() {
        List<List<Area>> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<Area> row = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    if (j == 0 || j == 7) { // rook black
                        row.add(new Area(TypeOfArea.Taken, new Rook(PawnColor.Black, i, j), PawnType.Rook));
                    } else if (j == 1 || j == 6) {
                        row.add(new Area(TypeOfArea.Taken, new Knight(PawnColor.Black, i, j), PawnType.Knight));
                    } else if (j == 2 || j == 5) {
                        row.add(new Area(TypeOfArea.Taken, new Bishop(PawnColor.Black, i, j), PawnType.Bishop));
                    } else if (j == 3) {
                        row.add(new Area(TypeOfArea.Taken, new Queen(PawnColor.Black, i, j), PawnType.Queen));
                    } else {
                        row.add(new Area(TypeOfArea.Taken, new King(PawnColor.Black, i, j), PawnType.King));
                    }
                } else if (i == 1) {
                    row.add(new Area(TypeOfArea.Taken, new Pawn(PawnColor.Black, i, j), PawnType.Pawn));
                } else if (i == 6) {
                    row.add(new Area(TypeOfArea.Taken, new Pawn(PawnColor.White, i, j), PawnType.Pawn));
                } else if (i == 7) {
                    if (j == 0 || j == 7) { // rook black
                        row.add(new Area(TypeOfArea.Taken, new Rook(PawnColor.White, i, j), PawnType.Rook));
                    } else if (j == 1 || j == 6) {
                        row.add(new Area(TypeOfArea.Taken, new Knight(PawnColor.White, i, j), PawnType.Knight));
                    } else if (j == 2 || j == 5) {
                        row.add(new Area(TypeOfArea.Taken, new Bishop(PawnColor.White, i, j), PawnType.Bishop));
                    } else if (j == 3) {
                        row.add(new Area(TypeOfArea.Taken, new Queen(PawnColor.White, i, j), PawnType.Queen));
                    } else {
                        row.add(new Area(TypeOfArea.Taken, new King(PawnColor.White, i, j), PawnType.King));
                    }

                } else {
                    row.add(new Area(TypeOfArea.Empty));
                }
            }
            result.add(row);
        }
        return result;
    }

    List<Point> possibilities;
    int xOfFocused;
    int yOfFocused;

    // kolor zielony  #9EB384
    private int xOfPawnToSwitch, yOfPawnToSwitch;
    public List<Move> forcedMoves = new ArrayList<>();
    @FXML
    GridPane parent;
    @FXML
    Label gameOverText;


    public void areaClick(MouseEvent event) {
        int xLoc = (int) event.getSceneX() / 100;
        int yLoc = (int) event.getSceneY() / 100;
        int yOfWhiteKing=0;
        int xOfWhiteKing=0;
        int yOfBlackKing=0;
        int xOfBlackKing=0;
        for(int i=0; i<gameMap.size(); i++){
            for(int j=0; j<gameMap.get(i).size(); j++){
                if(gameMap.get(i).get(j).typeOfPawn==PawnType.King){
                    if(gameMap.get(i).get(j).pawn.color==PawnColor.White){
                        yOfWhiteKing=i;
                        xOfWhiteKing=j;
                    } else{
                        yOfBlackKing=i;
                        xOfBlackKing=j;
                    }
                }
            }
        }
        forcedMoves.clear();
        if(currentTurn==PawnColor.White && checkIfInDanger(gameMap,PawnColor.White,yOfWhiteKing,xOfWhiteKing)){
            // thats where we set the necessary moves
            List<Point> possibilitesOfWhiteKing= gameMap.get(yOfWhiteKing).get(xOfWhiteKing).pawn.showPossibilities(gameMap);
            for(Point point : possibilitesOfWhiteKing){
                forcedMoves.add(new Move(yOfWhiteKing,xOfWhiteKing,point.yPos,point.xPos));
            }
            // thats where we add the blocks
            forcedMoves.addAll(movesToProtectKing(gameMap,PawnColor.White,yOfWhiteKing,xOfWhiteKing));
            System.out.println("white king is danger the moves we can do are:" + forcedMoves);


        } else if(currentTurn==PawnColor.Black && checkIfInDanger(gameMap,PawnColor.Black,yOfBlackKing,xOfBlackKing)){
            List<Point> possibilitiesOfBlackKing= gameMap.get(yOfBlackKing).get(xOfBlackKing).pawn.showPossibilities(gameMap);
            for(Point point : possibilitiesOfBlackKing){
                forcedMoves.add(new Move(yOfBlackKing,xOfBlackKing,point.yPos,point.xPos));
            }
            forcedMoves.addAll(movesToProtectKing(gameMap,PawnColor.Black,yOfBlackKing,xOfBlackKing));
            System.out.println("black king is danger the moves we can do are:" + forcedMoves);
        }
        // somewhere around here we want to set forcedMoves with a function or smth,
        // then when we have the complete list we just compare the possibilties which we make in line 292
        // and just remove the moves that are not "forced"

        System.out.println("current index -> "+yLoc+","+xLoc+" is a "+
                gameMap.get(yLoc).get(xLoc).typeOfPawn);
        if(isOver) return;
        if (selectedAPawn) { // selecting the actual place where the pawn moves to
            if (gameMap.get(yLoc).get(xLoc).pawn != null && gameMap.get(yLoc).get(xLoc).pawn.color == currentTurn) { // in case we want to switch pawns to move with
                // System.out.println(gameMap.get(yLoc).get(xLoc).typeOfPawn + " " + gameMap.get(yLoc).get(xLoc).pawn.color);
                for (int i = 0; i < possibilities.size(); i++) {
                    if ((possibilities.get(i).xPos + possibilities.get(i).yPos) % 2 != 0) {
                        mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                                getParent().setStyle("-fx-background-color: #9EB384;");
                    } else {
                        mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                                getParent().setStyle("-fx-background-color: white;");
                    }
                } // reseting the previous possibilities
                selectedAPawn = false;
            } else {
                for (int i = 0; i < possibilities.size(); i++) {
                    if (xLoc == possibilities.get(i).xPos && yLoc == possibilities.get(i).yPos) {
                        if (possibilities.get(i).enPassant) { // en Passant
                            if (gameMap.get(yOfFocused).get(xOfFocused).pawn.color == PawnColor.White) {
                                gameMap.get(yLoc + 1).get(xLoc).typeOfArea = TypeOfArea.Empty;
                                gameMap.get(yLoc + 1).get(xLoc).pawn = null;
                                gameMap.get(yLoc + 1).get(xLoc).typeOfPawn = PawnType.None;
                                mapLabels.get(yLoc + 1).get(xLoc).setText("");
                            } else {
                                gameMap.get(yLoc - 1).get(xLoc).typeOfArea = TypeOfArea.Empty;
                                gameMap.get(yLoc - 1).get(xLoc).pawn = null;
                                gameMap.get(yLoc - 1).get(xLoc).typeOfPawn = PawnType.None;
                                mapLabels.get(yLoc - 1).get(xLoc).setText("");
                            }
                        } else if (possibilities.get(i).castling) { // castling
                            if (possibilities.get(i).xPos == 2) { // castling to the left
                                gameMap.get(yLoc).get(3).pawn = gameMap.get(yLoc).get(0).pawn;
                                gameMap.get(yLoc).get(3).typeOfPawn = gameMap.get(yLoc).get(0).typeOfPawn;
                                gameMap.get(yLoc).get(3).typeOfArea = gameMap.get(yLoc).get(0).typeOfArea;
                                mapLabels.get(yLoc).get(3).setText(mapLabels.get(yLoc).get(0).getText());
                                gameMap.get(yLoc).get(3).pawn.currentXlocation = 3;
                                gameMap.get(yLoc).get(3).pawn.currentYlocation = yLoc;
                                gameMap.get(yLoc).get(3).pawn.amountOfMoves++;
                                gameMap.get(yLoc).get(0).pawn = null;
                                gameMap.get(yLoc).get(0).typeOfArea = TypeOfArea.Empty;
                                gameMap.get(yLoc).get(0).typeOfPawn = PawnType.None;
                                mapLabels.get(yLoc).get(0).setText("");
                            } else if (possibilities.get(i).xPos == 6) { // castling to the right
                                gameMap.get(yLoc).get(5).pawn = gameMap.get(yLoc).get(7).pawn;
                                gameMap.get(yLoc).get(5).typeOfPawn = gameMap.get(yLoc).get(7).typeOfPawn;
                                gameMap.get(yLoc).get(5).typeOfArea = gameMap.get(yLoc).get(7).typeOfArea;
                                mapLabels.get(yLoc).get(5).setText(mapLabels.get(yLoc).get(7).getText());
                                gameMap.get(yLoc).get(5).pawn.currentXlocation = 5;
                                gameMap.get(yLoc).get(5).pawn.currentYlocation = yLoc;
                                gameMap.get(yLoc).get(5).pawn.amountOfMoves++;
                                gameMap.get(yLoc).get(7).pawn = null;
                                gameMap.get(yLoc).get(7).typeOfArea = TypeOfArea.Empty;
                                gameMap.get(yLoc).get(7).typeOfPawn = PawnType.None;
                                mapLabels.get(yLoc).get(7).setText("");
                            }
                        }
                        // setting up the place where it moved
                        if(gameMap.get(yLoc).get(xLoc).typeOfPawn!=PawnType.King){
                            gameMap.get(yLoc).get(xLoc).typeOfPawn = gameMap.get(yOfFocused).get(xOfFocused).typeOfPawn;
                            gameMap.get(yLoc).get(xLoc).pawn = gameMap.get(yOfFocused).get(xOfFocused).pawn;
                            gameMap.get(yLoc).get(xLoc).typeOfArea = gameMap.get(yOfFocused).get(xOfFocused).typeOfArea;
                            mapLabels.get(yLoc).get(xLoc).setText(mapLabels.get(yOfFocused).get(xOfFocused).getText());
                        } else{
                            if (currentTurn == PawnColor.White) {
                                currentTurn = PawnColor.Black;
                            } else {
                                currentTurn = PawnColor.White;
                            }
                        }
                        gameMap.get(yLoc).get(xLoc).pawn.currentXlocation = xLoc;
                        gameMap.get(yLoc).get(xLoc).pawn.currentYlocation = yLoc;
                        gameMap.get(yLoc).get(xLoc).pawn.amountOfMoves++;

                        // reseting the place from where it moved
                        gameMap.get(yOfFocused).get(xOfFocused).typeOfArea = TypeOfArea.Empty;
                        gameMap.get(yOfFocused).get(xOfFocused).pawn = null;
                        gameMap.get(yOfFocused).get(xOfFocused).typeOfPawn = PawnType.None;
                        mapLabels.get(yOfFocused).get(xOfFocused).setText("");
                        selectedAPawn = false;
                        if ((yLoc == 0 || yLoc == 7) && gameMap.get(yLoc).get(xLoc).typeOfPawn == PawnType.Pawn) {    // pawn made it to the end of the board so we switch him
                            xOfPawnToSwitch = xLoc;
                            yOfPawnToSwitch = yLoc;
                            parent.setMaxWidth(900);
                            parent.setPrefWidth(900);
                            Stage stage = (Stage) parent.getScene().getWindow();
                            System.out.println(stage.getWidth());
                            stage.setWidth(925);
                        }
                        if (currentTurn == PawnColor.White) {
                            currentTurn = PawnColor.Black;
                        } else {
                            currentTurn = PawnColor.White;
                        }
                    }
                }
                for (int i = 0; i < possibilities.size(); i++) {
                    if ((possibilities.get(i).xPos + possibilities.get(i).yPos) % 2 != 0) {
                        mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                                getParent().setStyle("-fx-background-color: #9EB384;");
                    } else {
                        mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                                getParent().setStyle("-fx-background-color: white;");
                    }
                }
            }
        }
        if (!selectedAPawn) {   // selecting a pawn that we're gonna move with
            if (gameMap.get(yLoc).get(xLoc).typeOfPawn != PawnType.None) {
                if (gameMap.get(yLoc).get(xLoc).pawn.color != currentTurn) {
                    return;
                }
                possibilities = gameMap.get(yLoc).get(xLoc).pawn.showPossibilities(gameMap);
                possibilities=filterPossibilities(yLoc,xLoc,possibilities,forcedMoves);
                for (int i = 0; i < possibilities.size(); i++) {
                    mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                            getParent().setStyle("-fx-background-color: #AED2FF;");
                }
                xOfFocused = xLoc;
                yOfFocused = yLoc;
                selectedAPawn = true;
                //   System.out.println(gameMap.get(yLoc).get(xLoc).pawn);
            }
        }
        // checking if over

        if(checkIfOver(gameMap,PawnColor.White,yOfWhiteKing,xOfWhiteKing) || checkIfOver(gameMap,PawnColor.Black,yOfBlackKing,xOfBlackKing)){
            isOver=true;
            gameOverText.setOpacity(1.0);
        }
        if(isOver) {
            for (int i = 0; i < possibilities.size(); i++) {
                if ((possibilities.get(i).xPos + possibilities.get(i).yPos) % 2 != 0) {
                    mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                            getParent().setStyle("-fx-background-color: #9EB384;");
                } else {
                    mapLabels.get(possibilities.get(i).yPos).get(possibilities.get(i).xPos).
                            getParent().setStyle("-fx-background-color: white;");
                }
            }

        }

    }
    public static boolean checkIfInDanger(List<List<Area>> gameMap, PawnColor kingColor, int yOfKing, int xOfKing) {
        Area toRestore = new Area(gameMap.get(yOfKing).get(xOfKing).typeOfArea,gameMap.get(yOfKing).get(xOfKing).pawn,
                gameMap.get(yOfKing).get(xOfKing).typeOfPawn);
        gameMap.get(yOfKing).get(xOfKing).pawn=new King(kingColor,yOfKing,xOfKing);
        gameMap.get(yOfKing).get(xOfKing).typeOfPawn=PawnType.King;
        gameMap.get(yOfKing).get(xOfKing).typeOfArea=TypeOfArea.Taken;
        for (int i = 0; i < gameMap.size(); i++) {
            for (int j = 0; j < gameMap.get(i).size(); j++) {
                if (gameMap.get(i).get(j).pawn != null) {
                    if (gameMap.get(i).get(j).pawn.color != kingColor && gameMap.get(i).get(j).typeOfPawn!=PawnType.King) {
                        List<Point> possibilitesToAtack = gameMap.get(i).get(j).pawn.showPossibilities(gameMap);
                     //   System.out.println(i+","+j+" possibilities > " + possibilitesToAtack);
                        if (isMatchingPoint(xOfKing, yOfKing, possibilitesToAtack)) {
                            System.out.println("pawn at "+i+","+j+" can attack king "+kingColor);
                            gameMap.get(yOfKing).get(xOfKing).typeOfArea=toRestore.typeOfArea;
                            gameMap.get(yOfKing).get(xOfKing).pawn=toRestore.pawn;
                            gameMap.get(yOfKing).get(xOfKing).typeOfPawn=toRestore.typeOfPawn;
                            return true;
                        }
                    }
                }
            }
        }
        gameMap.get(yOfKing).get(xOfKing).typeOfArea=toRestore.typeOfArea;
        gameMap.get(yOfKing).get(xOfKing).pawn=toRestore.pawn;
        gameMap.get(yOfKing).get(xOfKing).typeOfPawn=toRestore.typeOfPawn;
        return false;
    }
    public static List<Point> inBetween(List<List<Area>> gameMap, int yOfAttacker, int xOfAttacker, int yOfKing, int xOfKing){
        List<Point> result = new ArrayList<>();
        if(yOfAttacker==yOfKing){  // so thats a straight horizontal line
            if(xOfAttacker>xOfKing){
                for (int i=xOfKing+1; i<=xOfAttacker; i++){
                    result.add(new Point(yOfAttacker,i));
                }
            } else{
                for (int i=xOfKing-1; i>=xOfAttacker; i--){
                    result.add(new Point(yOfAttacker,i));
                }
            }
        } else if(xOfAttacker==xOfKing) { // thats a straight vertical line
            if(yOfAttacker>yOfKing){
                for (int i=yOfKing+1; i<=yOfAttacker; i++){
                    result.add(new Point(i,xOfAttacker));
                }
            } else{
                for (int i=yOfKing-1; i>=yOfAttacker; i--){
                    result.add(new Point(i,xOfAttacker));
                }
            }
        } else{      // some wonky wonky weird shanannigans with 45* degrees
            // we dont need to check if this is a horse just because well there is no blocking a horse i suppose
            if(xOfAttacker>xOfKing){
                if(yOfAttacker>yOfKing){  // 135'
                    int yIndex= yOfKing+1;
                    for(int x=xOfKing+1; x<=xOfAttacker; x++){
                        result.add(new Point(yIndex,x));
                        yIndex++;
                    }
                } else{
                    int yIndex= yOfKing-1;
                    for(int x=xOfKing+1; x<=xOfAttacker; x++){
                        result.add(new Point(yIndex,x));
                        yIndex--;
                    }
                }
            } else {
                if(yOfAttacker>yOfKing){
                    int yIndex=yOfKing+1;
                    for(int x=xOfKing-1; x>=xOfAttacker; x--){
                        result.add(new Point(yIndex,x));
                        yIndex++;
                    }
                } else{
                    int yIndex=yOfKing-1;
                    for(int x=xOfKing-1; x>=xOfAttacker; x--){
                        result.add(new Point(yIndex,x));
                        yIndex--;
                    }
                }
            }
        }
        return result;
    }
    public List<Move> movesToProtectKing(List<List<Area>> gameMap, PawnColor kingColor, int yOfKing, int xOfKing){
        List<BasePawn> kingThreats= new ArrayList<>();
        List<List<Point>> betweenKingnAttacker = new ArrayList<>();
        List<Move> result = new ArrayList<>();
        for(int i=0; i<gameMap.size(); i++){
            for(int j=0; j<gameMap.get(i).size(); j++){
                if(gameMap.get(i).get(j).pawn!=null){
                    if(gameMap.get(i).get(j).pawn.color!=kingColor){
                        List<Point> possibilities = gameMap.get(i).get(j).pawn.showPossibilities(gameMap);
                        if(isMatchingPoint(xOfKing,yOfKing,possibilities)){
                            kingThreats.add(gameMap.get(i).get(j).pawn);
                            betweenKingnAttacker.add(inBetween(gameMap,i,j,yOfKing,xOfKing));
                        }
                    }
                }
            }
        }

        // znamy juz zagrozenia teraz czy da sie zbic te pionki lub zablokowac atak innym pionkiem
        // idea jest taka zeby kazdy pionek ktory stwarza zagrozenie
        List<Move> movesToCheck = new ArrayList<>();
        for(int i=0; i<gameMap.size(); i++){
            for(int j=0; j<gameMap.get(i).size(); j++){
                if(gameMap.get(i).get(j).pawn!=null){
                    if(gameMap.get(i).get(j).pawn.color==kingColor){
                        List<Point> possibilities = gameMap.get(i).get(j).pawn.showPossibilities(gameMap);
                        for(int k=0; k<betweenKingnAttacker.size(); k++){
                            for(int l=0; l<betweenKingnAttacker.get(k).size(); l++){
                                if(isMatchingPoint(betweenKingnAttacker.get(k).get(l).xPos,
                                        betweenKingnAttacker.get(k).get(l).yPos,possibilities)){
                                    movesToCheck.add(new Move(i,j,
                                            betweenKingnAttacker.get(k).get(l).yPos,
                                            betweenKingnAttacker.get(k).get(l).xPos));
                                }
                            }
                        }
                    }
                }
            }
        }
        // now we just try every move if one makes the king safe we return true else false

        for(int i=0; i<movesToCheck.size(); i++){
            BasePawn pawnStart=gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).pawn;
            TypeOfArea typeOfAreaStart=gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfArea;
            PawnType pawnTypeStart=gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfPawn;

            BasePawn pawnEnd=gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).pawn;
            TypeOfArea typeOfAreaEnd=gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfArea;
            PawnType pawnTypeEnd=gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfPawn;

            gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).pawn=null;
            gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfArea=TypeOfArea.Empty;
            gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfPawn=PawnType.None;

            gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).pawn=pawnStart;
            gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfArea=typeOfAreaStart;
            gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfPawn=pawnTypeStart;

            if(!checkIfInDanger(gameMap,kingColor,yOfKing,xOfKing)){
                gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).pawn=pawnStart;
                gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfArea=typeOfAreaStart;
                gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfPawn=pawnTypeStart;

                gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).pawn=pawnEnd;
                gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfArea=typeOfAreaEnd;
                gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfPawn=pawnTypeEnd;

                result.add(movesToCheck.get(i));
            }
            gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).pawn=pawnStart;
            gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfArea=typeOfAreaStart;
            gameMap.get(movesToCheck.get(i).startY).get(movesToCheck.get(i).startX).typeOfPawn=pawnTypeStart;

            gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).pawn=pawnEnd;
            gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfArea=typeOfAreaEnd;
            gameMap.get(movesToCheck.get(i).endY).get(movesToCheck.get(i).endX).typeOfPawn=pawnTypeEnd;
        }
        return result;
    }
    public boolean checkIfOver(List<List<Area>> gameMap, PawnColor kingColor, int yOfKing, int xOfKing){
        boolean isInDanger=checkIfInDanger(gameMap,kingColor,yOfKing,xOfKing);
        boolean cantMove=true;
        if(isInDanger){
            System.out.println("king of color: " +kingColor+" is in danger");
            List<Point> kingPossibilities= gameMap.get(yOfKing).get(xOfKing).pawn.showPossibilities(gameMap);
            if(kingPossibilities==null){
                cantMove=true;
                System.out.println("king "+kingColor +" cant move anywhere");
            } else{
                for(int i=0; i<kingPossibilities.size(); i++){
                    if(!checkIfInDanger(gameMap,kingColor,kingPossibilities.get(i).yPos,kingPossibilities.get(i).xPos)){
                        cantMove=false;
                    }
                }
            }
        }
        boolean canBlock= false;
        if(cantMove && isInDanger ){
            System.out.println("king of color: " +kingColor+" cant move and is in danger");
            if(movesToProtectKing(gameMap,kingColor,yOfKing,xOfKing).size()!=0){
                canBlock=true;
            }
        }

    return (cantMove&&isInDanger)&&!canBlock;
    }
    public List<Point> filterPossibilities(int startY, int startX, List<Point> possibilities, List<Move> filter){

        List<Point> result = new ArrayList<>();
        for(Move move : filter){
            if(move.startY==startY && move.startX==startX){
                for(Point point : possibilities){
                    if(move.endY==point.yPos && move.endX==point.xPos){
                        result.add(point);
                    }
                }
            }
        }
        int yOfKing = 0,xOfKing=0;
        List<Point> actualPossibilities= new ArrayList<>();
        for(int i=0; i<gameMap.size(); i++){
            for(int j=0; j<gameMap.get(i).size(); j++){
                if(gameMap.get(i).get(j).typeOfPawn==PawnType.King){
                    if(gameMap.get(i).get(j).pawn.color==currentTurn){
                        yOfKing=i;
                        xOfKing=j;
                    }
                }
            }
        }
        if(!checkIfInDanger(gameMap,currentTurn,yOfKing,xOfKing)){
            PawnType type= gameMap.get(startY).get(startX).typeOfPawn;
            TypeOfArea typeArea= gameMap.get(startY).get(startX).typeOfArea;
            BasePawn pawn= gameMap.get(startY).get(startX).pawn;

            gameMap.get(startY).get(startX).pawn=null;
            gameMap.get(startY).get(startX).typeOfPawn=PawnType.None;
            gameMap.get(startY).get(startX).typeOfArea=TypeOfArea.Empty;
            System.out.println("the king is not in danger and we're checking if the moves wont make him in danger");
            for(Point point : possibilities){

                BasePawn pawnAtMove=gameMap.get(point.yPos).get(point.xPos).pawn;
                TypeOfArea areaAtMove=gameMap.get(point.yPos).get(point.xPos).typeOfArea;
                PawnType typeAtMove=gameMap.get(point.yPos).get(point.xPos).typeOfPawn;

                gameMap.get(point.yPos).get(point.xPos).pawn=pawn;
                gameMap.get(point.yPos).get(point.xPos).typeOfPawn=type;
                gameMap.get(point.yPos).get(point.xPos).typeOfArea=typeArea;

                if(!checkIfInDanger(gameMap,currentTurn,yOfKing,xOfKing)){
                 //   gameMap.get(startY).get(startX).pawn=pawn;
                  //  gameMap.get(startY).get(startX).typeOfPawn=type;
                //    gameMap.get(startY).get(startX).typeOfArea=typeArea;

                    gameMap.get(point.yPos).get(point.xPos).pawn=pawnAtMove;
                    gameMap.get(point.yPos).get(point.xPos).typeOfPawn=typeAtMove;
                    gameMap.get(point.yPos).get(point.xPos).typeOfArea=areaAtMove;
                    actualPossibilities.add(point);
                }
                gameMap.get(point.yPos).get(point.xPos).pawn=pawnAtMove;
                gameMap.get(point.yPos).get(point.xPos).typeOfPawn=typeAtMove;
                gameMap.get(point.yPos).get(point.xPos).typeOfArea=areaAtMove;
            }
            gameMap.get(startY).get(startX).pawn=pawn;
            gameMap.get(startY).get(startX).typeOfPawn=type;
            gameMap.get(startY).get(startX).typeOfArea=typeArea;
        }
        if(filter.size()==0){
            System.out.println("we return moves here when the filter is 0");
            return actualPossibilities;
        } else {
            System.out.println("we return moves here when the filter is not 0");
            System.out.println(gameMap.get(startY).get(startX).pawn + " from filter posiblities");
            return result;
        }
    }
    public static boolean isMatchingPoint(int x, int y, List<Point> points) {
        for (Point point : points) {
            if (point.yPos == y && point.xPos == x) {
                return true;
            }
        }
        return false;
    }
    @FXML
    private Label textSwitch, queenSwitch, rookSwitch, bishopSwitch, knightSwitch;

    public void pawnSwitch(MouseEvent event) {
        int mouseY = (int) event.getSceneY() / 100;
        if (mouseY == 1) {  // switching to Queen
            Queen queen = new Queen(gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentYlocation, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentXlocation);
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).typeOfPawn = PawnType.Queen;
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn = queen;
            if (gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color == PawnColor.White) {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♕");
            } else {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♛");
            }
        } else if (mouseY == 2) { // rook
            Rook rook = new Rook(gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentYlocation, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentXlocation);
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).typeOfPawn = PawnType.Rook;
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn = rook;
            if (gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color == PawnColor.White) {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♖");
            } else {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♜");
            }
        } else if (mouseY == 3) { // bishop
            Bishop bishop = new Bishop(gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentYlocation, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentXlocation);
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).typeOfPawn = PawnType.Rook;
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn = bishop;
            if (gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color == PawnColor.White) {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♗");
            } else {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♝");
            }
        } else {   // knight
            Knight knight = new Knight(gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentYlocation, gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.currentXlocation);
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).typeOfPawn = PawnType.Rook;
            gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn = knight;
            if (gameMap.get(yOfPawnToSwitch).get(xOfPawnToSwitch).pawn.color == PawnColor.White) {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♘");
            } else {
                mapLabels.get(yOfPawnToSwitch).get(xOfPawnToSwitch).setText("♞");
            }
        }
        Stage stage = (Stage) parent.getScene().getWindow();
        stage.setWidth(816);
    }
}