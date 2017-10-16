package com.example.BrainGames.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import java.util.Random;

public class Game4x4Activity extends AppCompatActivity implements View.OnClickListener{

    private int numberOfElements;
    private MemoryButton[] buttons;

    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;

    private boolean isBusy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4x4);

        //Create our layout of the 4x4 game.
        GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout_4x4);

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
        for(int r = 0; r < numRows; r++){
            for(int c = 0; c < numColumns; c++){
                MemoryButton tempButton = new MemoryButton(this,r,c, buttonGraphics[buttonGraphicLocations[r * numColumns + c]]);
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
    private void setButtonGraphics(){
        buttonGraphics[0] = R.drawable.button_1;
        buttonGraphics[1] = R.drawable.button_2;
        buttonGraphics[2] = R.drawable.button_3;
        buttonGraphics[3] = R.drawable.button_4;
        buttonGraphics[4] = R.drawable.button_5;
        buttonGraphics[5] = R.drawable.button_6;
        buttonGraphics[6] = R.drawable.button_7;
        buttonGraphics[7] = R.drawable.button_8;
    }
    /**
     * Shuffles the images/graphics for our game.
     */
    protected void shuffleButtonGraphics(){
        Random rand = new Random();

        for(int i = 0; i < numberOfElements; i++){
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }
        for(int i = 0; i < numberOfElements; i++){
            int temp = buttonGraphicLocations[i];

            int swapIndex = rand.nextInt(16);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];

            buttonGraphicLocations[swapIndex] = temp;
        }
    }

    /**
     * Check if the game is complete.
     */
    protected void checkClear(){

        int check = 0;
        int numElementsCheck = numberOfElements - 1;
        for(int i = 0; i < numberOfElements; i++){
            if(buttons[i].isFlipped){
                check++;
                //Log.d("Flipped?", "button is flipped?");
            }
        }

        if(check == numElementsCheck){
            Log.d("finished", String.valueOf(check));
        }
    }

    /**
     * Our action listener whenever a button is clicked.
     * @param view
     */
    @Override
    public void onClick(View view) {
        checkClear();
        Log.d("?", "clicked");
        if(isBusy){
            return;
        }
        MemoryButton button = (MemoryButton) view;

        if(button.isMatched()){
            return;
        }
        if(selectedButton1 == null){
            selectedButton1 = button;
            selectedButton1.flip();
            return;
        }
        if(selectedButton1.getId() == button.getId()){
            return;
        }
        if(selectedButton1.getFrontDrawableId() == button.getFrontDrawableId()){
            button.flip();
            button.setMatched(true);
            selectedButton1.setMatched(true);

            selectedButton1.setEnabled(false);
            button.setEnabled(false);

            selectedButton1 = null;


            return;
        }


        else{
            selectedButton2 = button;
            selectedButton2.flip();
            isBusy = true;

            //Creates a delay so the user knows what the second betton was.
            final android.os.Handler handler = new android.os.Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1= null;
                    selectedButton2 = null;
                    isBusy = false;
                }
            }, 500);

        }


    }
}
