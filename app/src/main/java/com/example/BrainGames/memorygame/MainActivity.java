package com.example.BrainGames.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //instantiate our buttons.
    private static Button button4x4;
    private static Button mathButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickMathButtonListener();
        onClick4x4ButtonListener();


    }

    /**
     * Change activity when memory game is pressed.
     */
    public void onClick4x4ButtonListener(){
        button4x4 = (Button)findViewById(R.id.button_4x4_game);
        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent memory4x4Activity = new Intent(MainActivity.this, ColorMemoryGame.class);
                startActivity(memory4x4Activity);

            }
        }
        );
    }

    /**
     * Change activity when math game is pressed.
     */
    public void onClickMathButtonListener(){
        mathButton = (Button)findViewById(R.id.mathButton);
        mathButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent mathActivity = new Intent(MainActivity.this, MathActivity.class);
                        startActivity(mathActivity);
                    }
                }
        );
    }

}
