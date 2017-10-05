package com.example.andyhung.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;


public class MainActivity extends AppCompatActivity {

    private Button button4x4;
    private static Button mathButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickMathButtonListener();
        button4x4 = (Button)findViewById(R.id.button_4x4_game);
        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Game4x4Activity.class);
                startActivity(intent);

            }
        });


    }

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
