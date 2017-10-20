package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * The options menu for our set of memory games.
 */
public class MemoryActivity extends AppCompatActivity {

    /** Initialize our color game button. */
    private static Button colorMemoryActivity;

    /**
     * Initializes all the components of our color memory
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        onClickColorMemoryButtonListener();
    }

    /**
     * Action listener that will change activity to the
     * memory color game.
     */
    public void onClickColorMemoryButtonListener() {
        colorMemoryActivity = (Button) findViewById(R.id.colorMemoryButtonActivity);
        colorMemoryActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent colorMemoryActivity = new Intent(MemoryActivity.this, ColorMemoryGame.class);
                        startActivity(colorMemoryActivity);
                    }
                }
        );
    }
}
