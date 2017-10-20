package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * The class that will change to other math games.
 */
public class MathActivity extends AppCompatActivity {

    /** Initialize the addition button. */
    private static Button additionButton;

    /** Initialize the subtraction button. */
    private static Button subtractionButton;

    /** Initialize the multiplication button. */
    private static Button multiplicationButton;

    /** Initialize the division button. */
    private static Button divisionButton;

    /**
     * Initializes all the components of our color memory
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        onClickMathAdditionButtonListener();
        onClickMathSubtractionButtonListener();
    }

    /**
     * Action listener to change activity to the addition game.
     */
    public void onClickMathAdditionButtonListener() {
        additionButton = (Button) findViewById(R.id.additionActivityButton);
        additionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent mathAdditionActivity = new Intent(MathActivity.this, MathAdditionActivityV2.class);
                        startActivity(mathAdditionActivity);
                    }
                }
        );
    }

    /**
     * Action listener to change activity to the subtraction game.
     */
    public void onClickMathSubtractionButtonListener() {
        subtractionButton = (Button) findViewById(R.id.subtractionActivityButton);
        subtractionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent mathSubtractionActivity = new Intent(MathActivity.this, MathSubtractActivity.class);
                        startActivity(mathSubtractionActivity);
                    }
                }
        );
    }

    /**
     * Action listener to for multiplication button
     * to change activity to multiplication.
     */
    public void onClickMathMultiplicationButtonListener() {
        multiplicationButton = (Button) findViewById(R.id.multiplicationActivityButton);
        multiplicationButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent mathMultiplicationActivity = new Intent(MathActivity.this, MathMultiplicationActivity.class);
                        startActivity(mathMultiplicationActivity);
                    }
                }
        );
    }
}
