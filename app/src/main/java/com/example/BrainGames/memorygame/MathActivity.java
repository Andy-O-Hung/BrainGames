package com.example.BrainGames.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MathActivity extends AppCompatActivity {

    private static Button additionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        onClickMathAdditionButtonListener();
    }

    public void onClickMathAdditionButtonListener(){
        additionButton = (Button)findViewById(R.id.additionButton);
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
}
