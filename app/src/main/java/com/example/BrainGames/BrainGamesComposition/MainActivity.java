package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The main menu/activity for our brain games.
 */
public class MainActivity extends AppCompatActivity {

    /** Initilize the splash screen time out. */
    private static int splashTimeOut = 4000;

    /** Intialize the the memory games button. */
    private Button memoryButton;

    /** Intialize the the memory games button. */
    private Button mathButton;

    /** Intialize the the reaction game button. */
    private Button reactionButton;

    /**
     * Initializes all the components of our color memory
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickMathButtonListener();
        onClick4x4ButtonListener();
        onClickReactionButtonListener();
    }

    /**
     * Change activity when memory game is pressed.
     */
    public void onClick4x4ButtonListener() {
        memoryButton = (Button) findViewById(R.id.button_4x4_game);
        memoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent memoryActivity = new Intent(MainActivity.this, MemoryActivity.class);
                startActivity(memoryActivity);

            }
        }
        );
    }

    /**
     * Change activity when math game is pressed.
     */
    public void onClickMathButtonListener() {
        mathButton = (Button) findViewById(R.id.mathButton);
        mathButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent mathActivity = new Intent(MainActivity.this, MathActivity.class);
                        startActivity(mathActivity);
                    }
                }
        );
    }

    /**
     * Change activity when reaction game is pressed.
     */
    public void onClickReactionButtonListener() {
        reactionButton = (Button) findViewById(R.id.reactionMainButtonActivity);
        reactionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent reactionActivity = new Intent(MainActivity.this, ReactionActivity.class);
                        startActivity(reactionActivity);
                    }
                }
        );
    }
}
