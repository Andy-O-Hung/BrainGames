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

// brown?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4x4);


        GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout_4x4);


        int numColumns = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();
        Log.d("row", String.valueOf(numRows));
        numberOfElements = numColumns * numRows;

        buttons = new MemoryButton[numberOfElements];
        Log.d("numofELE", String.valueOf(numberOfElements));
        buttonGraphics = new int[numberOfElements / 2];

        buttonGraphics[0] = R.drawable.button_1;
        buttonGraphics[1] = R.drawable.button_2;
        buttonGraphics[2] = R.drawable.button_3;
        buttonGraphics[3] = R.drawable.button_4;
        buttonGraphics[4] = R.drawable.button_5;
        buttonGraphics[5] = R.drawable.button_6;
        buttonGraphics[6] = R.drawable.button_7;
        buttonGraphics[7] = R.drawable.button_8;

        buttonGraphicLocations = new int[numberOfElements];

        shuffleButtonGraphics();

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

    protected void checkClear(){
        //GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout_4x4);
        int check = 0;
        int numElementsCheck = numberOfElements - 1;
        for(int i = 0; i < numberOfElements; i++){
            if(buttons[i].isFlipped){
                check++;
                Log.d("Flipped?", "button is flipped?");
            }
        }
        Log.d("numberOfElements", String.valueOf(numElementsCheck));
        Log.d("# of checks:", String.valueOf(check));
        if(check == numElementsCheck){
            Log.d("finished", String.valueOf(check));
        }
    }

    @Override
    public void onClick(View view) {
        checkClear();
        Log.d("?", "clicked");
        if(isBusy){
            return;
        }
        MemoryButton button = (MemoryButton) view;

        if(button.isMatched){
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

        //checkClear();
    }
}
