package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This is the class that will run the multiplication game.
 */
public class MathMultiplicationActivity extends AppCompatActivity {

    /** Initialize the check button */
    private Button checkButton;

    /** Initialize  */
    private TextView displayMultiplication;

    /** Initialize the user's input */
    private int userInput;

    /** Initialize the input object */
    private EditText mulInput;

    /** Initialize the math object */
    private Math math;

    /** Initialize the results */
    private int[] results;

    /** Initialize the level to 1 */
    private int level = 1;

    /** Initialize the score to 0 */
    private int score = 0;

    /** Initialize the textView object for "correct" */
    private TextView multiplicationDisplayCorrect;

    /** Initialize the amount of answers correct to 0 */
    private int correct = 0;

    /** Initialize the TextView object for "wrong"  */
    private TextView multiplicationDisplayWrong;

    /** Initialize the amount of wrong answers to 0 */
    private int wrong = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_multiplication);

        //Initialize what the texts display
        displayMultiplication = (TextView) findViewById(R.id.displayMultiplicationQuestion);
        generateMultiplication();
        displayMultiplication.setText(results[0] + " * " + results[1] + " =  ?");
        mulInput = (EditText) findViewById(R.id.multiplicationInput);
        mulInput.setText("");
        multiplicationDisplayCorrect = (TextView) findViewById(R.id.multiplicationDisplayCorrectActivity);
        multiplicationDisplayCorrect.setText("Correct: " + String.valueOf(correct));
        multiplicationDisplayWrong = (TextView) findViewById(R.id.multiplicationDisplayWrongActivity);
        multiplicationDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        onClickCheckButtonListener();
    }

    /**
     * This will generate a new multiplication question.
     */
    public void generateMultiplication(){
        math = new Math(level);
        math.generateMul();
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
            userInput = Integer.valueOf(String.valueOf(mulInput.getText()));
        } catch (NumberFormatException ex)
        {
            displayMultiplication.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    NewQuestion();
                }
            }, 300);
            return;
        }
        if(results[2] == userInput){
            displayMultiplication.setText("CORRECT");
            correct++;
            multiplicationDisplayCorrect.setText("Correct: " + String.valueOf(correct));
            score++;
        }
        else{
            displayMultiplication.setText("WRONG");
            wrong++;
            multiplicationDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
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

        if(score == 4){
            level++;
        }

        if(score == 6){
            level++;
        }

        if(score == 8){
            level++;
        }

        generateMultiplication();
        displayMultiplication.setText(results[0] + " * " + results[1] + " =  ?");
        mulInput.setText("");
    }

    /**
     * Action Listener for our check button
     * that will run through the check.
     */
    public void onClickCheckButtonListener(){
        checkButton = (Button) findViewById(R.id.checkMulAnswerButton);
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