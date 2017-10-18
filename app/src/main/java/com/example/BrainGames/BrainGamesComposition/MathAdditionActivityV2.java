package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MathAdditionActivityV2 extends AppCompatActivity {
    private static Button checkButton;
    private TextView displayAddition;
    private int userInput;
    private EditText addInput;
    private Math math;
    private int[] results;
    private int level = 1;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_addition_v2);
        displayAddition = (TextView)findViewById(R.id.displayAdditionQuestion);
        generateAddition();
        displayAddition.setText(results[0] + " + " + results[1] + " =  ?");
        addInput = (EditText) findViewById(R.id.additionInput);
        addInput.setText("");
        OnClickCheckButtonListener();
    }

    public void generateAddition(){
        math = new Math(level);
        math.generateSum();
        results = math.getNumbers();
    }

    /**
     * Checks if the answer is correct
     * and generate new question.
     */
    private void checkAnswer(){
        //To create delay so that the
        //user knows correct or wrong.
        final android.os.Handler handler = new android.os.Handler();
        try
        {
            userInput = Integer.valueOf(String.valueOf(addInput.getText()));
        } catch (NumberFormatException ex)
        {
            displayAddition.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    NewQuestion();
                }
            }, 300);
            return;
        }
        if(results[2] == userInput){
            displayAddition.setText("CORRECT");
            score++;
        }
        else{
            displayAddition.setText("WRONG");
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
        newMath.generateSum();
        results = newMath.getNumbers();
        displayAddition.setText(results[0] + " + " + results[1] + " =  ?");
        addInput.setText("");
    }

    /**
     * Action Listener for our check button
     * that will run through the check.
     */
    public void OnClickCheckButtonListener(){
        checkButton = (Button) findViewById(R.id.checkButtonActivity);
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
}
