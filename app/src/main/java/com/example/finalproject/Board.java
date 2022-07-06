package com.example.finalproject;

import com.example.finalproject.Cell.E_STATUS;

public class Board {
    public static final int COLS = 8;//盤面の縦マス数
    public static final int ROWS = 8;//盤面の横マス数

    private int width;
    private int height;
    private int top;
    private int side;

    private Cell cells[][] = new Cell[ROWS][COLS];//配列方式でマス目を作成する
    private Cell.E_STATUS turn;

    public Board(){
        for(int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell();
            }
        }
        cells[ROWS/2 -1][COLS/2 -1].setStatus(Cell.E_STATUS.Black);//初期配置オセロの場合
        cells[ROWS/2 -1][COLS/2].setStatus(Cell.E_STATUS.White);
        cells[ROWS/2][COLS/2 -1].setStatus(Cell.E_STATUS.White);
        cells[ROWS/2][COLS/2].setStatus(Cell.E_STATUS.Black);
        turn = Cell.E_STATUS.Black;
    }
    public void setSize(int width, int height){
        int sz = width < height ? width : height;
        setWidth(sz);
        setHeight(sz);
    }

    public void setWidth(int width) {
        this.width = (int)(width / Board.COLS) * Board.COLS;//列数で割り切れない場合は余りを捨てる。
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
        this.height = (int)(height / Board.ROWS) * Board.ROWS;//行数で割り切れない場合は余りを捨てる。
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
        if (cell.getStatus() != E_STATUS.None){
            throw new Exception("Cell is not empty.");
        }
        cell.setStatus(newStatus);
    }

    public Cell.E_STATUS getTurn(){
        return this.turn;
    }

    public void changeTurn(){
        if (this.turn == E_STATUS.Black){
            this.turn = E_STATUS.White;
        } else {
            this.turn = E_STATUS.Black;
        }
    }
}

