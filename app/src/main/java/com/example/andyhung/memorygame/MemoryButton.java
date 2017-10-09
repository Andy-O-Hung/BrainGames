package com.example.andyhung.memorygame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.andyhung.memorygame.R;

/**
 * Created by Andy Hung on 9/26/2017.
 */

public class MemoryButton extends android.support.v7.widget.AppCompatButton {
    protected int row;
    protected int col;
    protected int frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    protected Drawable front;
    protected Drawable back;

    public MemoryButton(Context context, int r, int c, int frontImageDrawAbleId){

        super(context);

        this.row = r;
        this.col = c;
        this.frontDrawableId = frontImageDrawAbleId;

        //just to show backwards compaitable
        //front = context.getDrawable(frontImageDrawAbleId);

        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawAbleId);
        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.button_question_mark);

        setBackground(back);


        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));

        tempParams.width = (int) getResources().getDisplayMetrics().density * 130;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 130;

        setLayoutParams(tempParams);

    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontDrawableId() {
        return frontDrawableId;
    }

    public void setFrontDrawableId(int frontDrawableId) {
        this.frontDrawableId = frontDrawableId;
    }
    public void flip(){
        if(isMatched){
            return;
        }
        if(isFlipped){
            setBackground(back);
            isFlipped = false;
        }

        else{
            setBackground(front);
            isFlipped = true;
        }
    }
}
