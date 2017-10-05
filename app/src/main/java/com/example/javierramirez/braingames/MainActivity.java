package com.example.javierramirez.braingames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    private static Button mathButton;
    private static Button memoryButton;
    private static Button reactionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickMathButtonListener();
        onClickMemoryButtonListener();
        onClickReactionButtonListener();
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
    public void onClickMemoryButtonListener(){
        memoryButton = (Button)findViewById(R.id.memoryButton);
        memoryButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent memoryActivity = new Intent(MainActivity.this, MemoryActivity.class);
                        startActivity(memoryActivity);
                    }
                }
        );
    }
    public void onClickReactionButtonListener(){
        reactionButton = (Button)findViewById(R.id.reactionButton);
        reactionButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent reactionActivity = new Intent(MainActivity.this, ReactionActivity.class);
                        startActivity(reactionActivity);
                    }
                }
        );
    }
}
