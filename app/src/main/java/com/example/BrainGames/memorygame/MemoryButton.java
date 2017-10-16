package com.example.BrainGames.memorygame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.GridLayout;

/**
 * Created by Andy Hung on 9/26/2017.
 */

/**
 * Class for our custom memory button. Extends to widget which we get our
 * attributes from.
 */
public class MemoryButton extends android.support.v7.widget.AppCompatButton {
    /** Initialize row */
    private int row;

    /** Initialize column*/
    private int col;

    /** Initialize the ID from activity*/
    private int frontDrawableId;

    /** Initialize the flipped state*/
    protected boolean isFlipped = false;

    /** Initialize the matched state*/
    private boolean isMatched = false;

    /** Initialize the front*/
    private Drawable front;

    /** Initialize  the back*/
    private Drawable back;


    /**
     * Our default constructor for our memory button game.
     * @param context the context of the activity.
     * @param r the row which this button will be "located."
     * @param c the column which this button will be "located."
     * @param frontImageDrawAbleId Connects this button to the ID from the activity.
     */
    public MemoryButton(Context context, int r, int c, int frontImageDrawAbleId){

        //Must pass our resources from activity
        super(context);

        this.row = r;
        this.col = c;
        this.frontDrawableId = frontImageDrawAbleId;

        //Set the front image base on the image passed into our constructor.
        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawAbleId);

        //set the back image to question mark.
        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.button_question_mark);


        setBackground(back);

        //Where this particular button is set up.
        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));

        tempParams.width = (int) getResources().getDisplayMetrics().density * 130;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 130;

        setLayoutParams(tempParams);

    }


    /**
     * Deterimine if this button is matched.
     * @return
     */
    public boolean isMatched() {
        return isMatched;
    }

    /**
     * Setter for if the button is matched.
     * @param matched
     */
    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontDrawableId() {
        return frontDrawableId;
    }

    public void setFrontDrawableId(int frontDrawableId) {
        this.frontDrawableId = frontDrawableId;
    }

    /**
     * Flip the object around.
     */
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
