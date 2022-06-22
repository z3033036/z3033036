package com.example.finalproject;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Display extends View {
    private Board mBoard = new Board();
    public Display(Context context){
        super(context);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        mBoard.setSize(getWidth(),getHeight());
        drawBoard(canvas);
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                int r = (int) (y / mBoard.getCellHeidht());
                int c = (int) (x / mBoard.getCellWidth());
                if (r < Board.ROWS && c < Board.COLS) {
                    try {
                        mBoard.changeCell(r, c, mBoard.getTurn());
                        mBoard.changeTurn();
                    } catch (Exception e) {
                        Toast.makeText(this.getContext(), e.getMessage(), 300,show());

                    }
                }
        }
}
