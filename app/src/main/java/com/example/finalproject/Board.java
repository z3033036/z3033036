package com.example.finalproject;

import android.widget.Toast;

import com.example.finalproject.Cell.E_STATUS;

import java.util.ArrayList;

public class Board {
    public static final int COLS = 10;//盤面の縦マス数
    public static final int ROWS = 10;//盤面の横マス数

    private int width;
    private int height;
    private int top;
    private int side;

    private Cell cells[][] = new Cell[ROWS][COLS];//配列の作成
    private Cell.E_STATUS turn;

    public Board(){
        for(int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell();
            }
        }
        cells[9][0].setStatus(E_STATUS.black);
        cells[9][9].setStatus(E_STATUS.black);
        cells[9][1].setStatus(E_STATUS.blue);
        cells[9][8].setStatus(E_STATUS.blue);
        cells[9][2].setStatus(E_STATUS.red);
        cells[9][7].setStatus(E_STATUS.red);
        cells[9][4].setStatus(E_STATUS.white);
        cells[9][5].setStatus(E_STATUS.white);

        turn = E_STATUS.None;
    }
    public void setSize(int width, int height){
        int sz = width < height ? width : height;
        setWidth(sz);
        setHeight(sz);
    }

    public void setWidth(int width) {
        this.width = (int)(width / Board.COLS) * Board.COLS;
        float cellW = this.getCellWidth();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j].setWidth(cellW);
                cells[i][j].setLeft((int)(j * cellW));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = (int)(height / Board.ROWS) * Board.ROWS;
        float cellH = this.getCellHeidht();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j].setHeight(cellH);
                cells[i][j].setTop((int)(i * cellH));
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void setLeft(int left) {
        this.side = left;
    }

    public int getLeft() {
        return side;
    }

    public Cell[][] getCells(){
        return cells;
    }

    public float getCellWidth(){
        return (float)(this.width / COLS);
    }

    public float getCellHeidht(){
        return (float)(this.height / ROWS);
    }

    public void changeCell(int r, int c, Cell.E_STATUS newStatus) throws Exception{
        Cell cell = cells[r][c];
        if (cell.getStatus() == E_STATUS.black){
            throw new Exception("2マス前に動くことができます.");
        }
        cell.setStatus(newStatus);
    }

    public void setCell(int r, int c, int a){
        if(a < 6){
        cells[r-1][c-1].setStatus(E_STATUS.black); }
    }



    public void MoveCells(int r, int c, Cell.E_STATUS newStatus){
        Cell cell = cells[r][c];
        if (cell.getStatus() == E_STATUS.black){
            cells[r-3][c].setStatus(E_STATUS.black); }
        else if(cell.getStatus() == E_STATUS.blue){
            cells[r-2][c].setStatus(E_STATUS.blue);}
        else if(cell.getStatus() == E_STATUS.red){
            cells[r-1][c].setStatus(E_STATUS.red);}
        else if(cell.getStatus() == E_STATUS.white){
            cells[r-1][c].setStatus(E_STATUS.white);
        }
        cell.setStatus(newStatus);
    }

    public Cell.E_STATUS getTurn(){
        return this.turn;
    }



    public int countBlack(Cell.E_STATUS newStatus){
        int n = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(cells[i][j].getStatus() == newStatus){
                    n++;
                }
            }
        }
        return n;
    }


    public int BlackCell(){
        return countBlack(E_STATUS.black);
    }
    public int WhiteCell(){
        return countBlack(E_STATUS.white);
    }

    public void changeTurn(){
        if (this.turn == E_STATUS.black){
            this.turn = E_STATUS.blue;
        } else {
            this.turn = E_STATUS.black;
        }
    }
}

