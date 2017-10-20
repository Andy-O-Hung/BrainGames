package com.example.BrainGames.BrainGamesComposition;

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

    /** Initialize row. */
    private int row;

    /** Initialize column. */
    private int col;

    /** Initialize the ID from activity. */
    private int frontDrawableId;

    /** Initialize the flipped state. */
    private boolean isFlipped = false;

    /** Initialize the matched state. */
    private boolean isMatched = false;

    /** Initialize the front. */
    private Drawable front;

    /** Initialize  the back. */
    private Drawable back;


    /**
     * Our default constructor for our memory button game.
     * @param context the context of the activity.
     * @param r the row which this button will be "located."
     * @param c the column which this button will be "located."
     * @param frontImageDrawAbleId Connects this button to the ID from the activity.
     */
    public MemoryButton(final Context context, final int r, final int c, final int frontImageDrawAbleId) {

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
     * @return if it is matched, true or false.
     */
    public boolean isMatched() {
        return isMatched;
    }

    /**
     * Setter for if the button is matched.
     * @param matched matched state.
     */
    public void setMatched(final boolean matched) {
        isMatched = matched;
    }

    /**
     * Gets the drawable id from activity that is
     * associated with this object.
     * @return the drawable ID.
     */
    public int getFrontDrawableId() {
        return frontDrawableId;
    }

//    /**
//     * Sets the front drawable ID.
//     * @param frontDrawableId the drawable ID that will be
//     *                        used.
//     */
//    public void setFrontDrawableId (final int frontDrawableId) {
//        this.frontDrawableId = frontDrawableId;
//    }

    /**
     * Flip the object around.
     */
    public void flip() {
        if (isMatched) {
            return;
        }
        if (isFlipped) {
            setBackground(back);
            isFlipped = false;
        } else {
            setBackground(front);
            isFlipped = true;
        }
    }

    /**
     * Returns the boolean value of it
     * is flupped.
     * @return boolean value isFlipped.
     */
    public boolean isFlipped() {
        return isFlipped;
    }
}
