package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MemoryActivity extends AppCompatActivity {

    private static Button colorMemoryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        onClickColorMemoryButtonListener();
    }

    /**
     * Action listener that will change activity to the
     * memory color game.
     */
    public void onClickColorMemoryButtonListener(){
        colorMemoryActivity = (Button)findViewById(R.id.colorMemoryButtonActivity);
        colorMemoryActivity.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent colorMemoryActivity = new Intent(MemoryActivity.this, ColorMemoryGame.class);
                        startActivity(colorMemoryActivity);
                    }
                }
        );
    }
}
