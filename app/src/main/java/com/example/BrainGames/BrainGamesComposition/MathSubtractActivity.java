package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MathSubtractActivity extends AppCompatActivity {

    private static Button checkButton;
    private TextView displaySubtraction;
    private int userInput;
    private EditText subInput;
    private Math math;
    private int[] results;
    private int level = 1;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_subtract);
        displaySubtraction = (TextView)findViewById(R.id.displaySubtractionQuestion);
        generateSubtraction();
        displaySubtraction.setText(results[0] + " - " + results[1] + " =  ?");
        subInput = (EditText) findViewById(R.id.inputSubtraction);
        subInput.setText("");
        OnClickCheckButtonListener();
    }
    public void generateSubtraction(){
        math = new Math(level);
        math.generateSub();
        results = math.getNumbers();
    }
    public void OnClickCheckButtonListener(){
        checkButton = (Button) findViewById(R.id.checkSubAnswerButton);
        checkButton.setText("Check");
        checkButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkAnswer();
                    }
                }
        );
    }
    private void checkAnswer(){
        //To create delay so that the
        //user knows correct or wrong.
        final android.os.Handler handler = new android.os.Handler();
        try
        {
            userInput = Integer.valueOf(String.valueOf(subInput.getText()));
        } catch (NumberFormatException ex)
        {
            displaySubtraction.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    NewQuestion();
                }
            }, 300);
            return;
        }
        if(results[2] == userInput){
            displaySubtraction.setText("CORRECT");
            score++;
        }
        else{
            displaySubtraction.setText("WRONG");
        }

        //Create delay so user knows if its right or wrong.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NewQuestion();
            }
        }, 300);


    }
    /**
     * Generates new Question and resets
     * user input.
     */
    private void NewQuestion() {
        if(score == 2){
            level++;
        }

        //Add more score logic

        Math newMath = new Math(level);
        newMath.generateSub();
        results = newMath.getNumbers();
        displaySubtraction.setText(results[0] + " - " + results[1] + " =  ?");
        subInput.setText("");
    }
}
