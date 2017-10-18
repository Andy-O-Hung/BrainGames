package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MathActivity extends AppCompatActivity {

    private static Button additionButton;

    private static Button subtractionButton;

    private static Button multiplicationButton;

    private static Button divisionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        onClickMathAdditionButtonListener();
        onClickMathSubtractionButtonListener();
    }

    public void onClickMathAdditionButtonListener(){
        additionButton = (Button)findViewById(R.id.additionActivityButton);
        additionButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent mathAdditionActivity = new Intent(MathActivity.this, MathAdditionActivityV2.class);
                        startActivity(mathAdditionActivity);
                    }
                }
        );
    }
    public void onClickMathSubtractionButtonListener(){
        subtractionButton = (Button)findViewById(R.id.subtractionActivityButton);
        subtractionButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent mathSubtractionActivity = new Intent(MathActivity.this, MathSubtractActivity.class);
                        startActivity(mathSubtractionActivity);
                    }
                }
        );
    }
}
