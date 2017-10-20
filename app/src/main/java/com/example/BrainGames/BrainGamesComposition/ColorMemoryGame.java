package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * The activity of our 4x4 memory game with colors.
 * To win, find all pairs.
 */
public class ColorMemoryGame extends AppCompatActivity implements View.OnClickListener {

    /** Initialize the number of elements. */
    private int numberOfElements;

    /** Initialize our array of buttons. */
    private MemoryButton[] buttons;

    /** Initialize the locations of our buttons. */
    private int[] buttonGraphicLocations;

    /** Initialize the buttons images. */
    private int[] buttonGraphics;

    /** Initialize the selected button object. */
    private MemoryButton selectedButton1;

    /** Initialize the second selected button object. */
    private MemoryButton selectedButton2;

    /** Initialize the state of the activity. */
    private boolean isBusy = false;

    /** Display state of game. */
    private TextView state;

    /** Display amount of clicks. */
    private TextView clickCounter;

    /** Initialize the amount of clicks to 0. */
    private int clicks = 0;

    /**
     * Initializes all the components of our color memory
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4x4color);
        state = (TextView) findViewById(R.id.colorStateActivity);
        state.setText("In Progress");
        clickCounter = (TextView) findViewById(R.id.clicksCounterActivity);
        clickCounter.setText(String.valueOf(clicks));
        //Create our layout of the 4x4 game.
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout_4x4);

        //Match our number of columns and rows with the grid.
        int numColumns = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();

        //Set the number of elements that will be in our game.
        numberOfElements = numColumns * numRows;

        //Creates the number of memory buttons that will be in our game.
        buttons = new MemoryButton[numberOfElements];
        Log.d("numofELE", String.valueOf(numberOfElements));

        //Set the number of images that are needed.
        buttonGraphics = new int[numberOfElements / 2];

        //Call the method to assign the images.
        setButtonGraphics();

        buttonGraphicLocations = new int[numberOfElements];

        //shuffle the buttons
        shuffleButtonGraphics();

        //Create our memory buttons and connect them to gridlayout.
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                MemoryButton tempButton = new MemoryButton(this, r, c, buttonGraphics[buttonGraphicLocations[r * numColumns + c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                buttons[r * numColumns + c] = tempButton;
                gridLayout.addView(tempButton);
            }
        }

    }

    /**
     * Set the images to the buttons.
     */
    private void setButtonGraphics() {
        buttonGraphics[0] = R.drawable.red;
        buttonGraphics[1] = R.drawable.blue;
        buttonGraphics[2] = R.drawable.green;
        buttonGraphics[3] = R.drawable.orange;
        buttonGraphics[4] = R.drawable.yellow;
        buttonGraphics[5] = R.drawable.pink;
        buttonGraphics[6] = R.drawable.purple;
        buttonGraphics[7] = R.drawable.black;
    }
    /**
     * Shuffles the images/graphics for our game.
     */
    protected void shuffleButtonGraphics() {
        Random rand = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }
        for (int i = 0; i < numberOfElements; i++) {
            int temp = buttonGraphicLocations[i];

            int swapIndex = rand.nextInt(16);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];

            buttonGraphicLocations[swapIndex] = temp;
        }
    }

    /**
     * Check if the game is complete.
     */
    protected void checkClear() {

        int check = 0;
        int numElementsCheck = numberOfElements - 1;
        for (int i = 0; i < numberOfElements; i++) {
            if (buttons[i].isFlipped()) {
                check++;
                //Log.d("Flipped?", "button is flipped?");
            }
        }

        if (check == numElementsCheck) {
            final android.os.Handler handler = new android.os.Handler();
            state.setText("DONE!");
            //Not working why?
            clickCounter.setText("You won with " + String.valueOf(clicks) + " clicks!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    recreate();
                }
            }, 1500);
            //Log.d("finished", String.valueOf(check));

        }
    }

    /**
     * Increases the click counter and
     * set the value to the click counter
     * so the user can see how many clicks.
     */
    public void clicks() {
        clicks++;
        clickCounter.setText(String.valueOf(clicks));
    }
    /**
     * Our action listener whenever a button is clicked.
     * @param view the contents of the activity
     */
    @Override
    public void onClick(final View view) {
        checkClear();
        Log.d("?", "clicked");

        //So it doesn't crash.
        if (isBusy) {
            return;
        }
        MemoryButton button = (MemoryButton) view;

        //If matched,
        if (button.isMatched()) {
            return;
        }

        //Set first button if null.
        if (selectedButton1 == null) {
            selectedButton1 = button;
            selectedButton1.flip();
            clicks();
            return;
        }


        if (selectedButton1.getId() == button.getId()) {
            return;
        }

        //If two buttons are the same, flip, change variables
        //and reset.
        if (selectedButton1.getFrontDrawableId() == button.getFrontDrawableId()) {
            button.flip();
            button.setMatched(true);
            selectedButton1.setMatched(true);

            selectedButton1.setEnabled(false);
            button.setEnabled(false);

            selectedButton1 = null;

            clicks();
        } else { //If not the same, let the user see then reset.
            selectedButton2 = button;
            selectedButton2.flip();
            isBusy = true;
            clicks();

            //Creates a delay so the user knows what the second button was.
            final android.os.Handler handler = new android.os.Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1 = null;
                    selectedButton2 = null;
                    isBusy = false;
                }
            }, 500);

        }


    }
}
