package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This is the class that will run the addition game.
 */
public class MathAdditionActivityV2 extends AppCompatActivity {

    /** Initialize the check button. */
    private static Button checkButton;

    /** Initialize the TextView object first displaying the question. */
    private TextView displayAddition;

    /** Initialize the user's input. */
    private int userInput;

    /** Initialize the input object. */
    private EditText addInput;

    /** Initialize the math object. */
    private Math math;

    /** Initialize the results. */
    private int[] results;

    /** Initialize the level to 1. */
    private int level = 1;

    /** Initialize the score to 0. */
    private int score = 0;

    /** Initialize the textView object for "correct". */
    private TextView additionDisplayCorrect;

    /** Initialize the amount of answers correct to 0. */
    private int correct = 0;

    /** Initialize the TextView object for "wrong".  */
    private TextView additionDisplayWrong;

    /** Initialize the amount of wrong answers to 0. */
    private int wrong = 0;

    /**
     * Initializes all the components of our color memory
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_addition_v2);

        //Initialize what the texts display
        displayAddition = (TextView) findViewById(R.id.displayAdditionQuestion);
        generateAddition();
        displayAddition.setText(results[0] + " + " + results[1] + " =  ?");
        addInput = (EditText) findViewById(R.id.additionInput);
        addInput.setText("");
        additionDisplayCorrect = (TextView) findViewById(R.id.additionDisplayCorrectActivity);
        additionDisplayCorrect.setText("Correct: " + String.valueOf(correct));
        additionDisplayWrong = (TextView) findViewById(R.id.additionDisplayWrongActivity);
        additionDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        onClickCheckButtonListener();
    }

    /**
     * This will generate a new addition question.
     */
    public void generateAddition() {
        math = new Math(level);
        math.generateSum();
        results = math.getNumbers();
    }

    /**
     * Checks if the answer is correct
     * and generate new question.
     */
    private void checkAnswer() {
        //To create delay so that the
        //user knows correct or wrong.
        final android.os.Handler handler = new android.os.Handler();
        try {
            userInput = Integer.valueOf(String.valueOf(addInput.getText()));
        } catch (NumberFormatException ex) {
            displayAddition.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    newQuestion();
                }
            }, 300);
            return;
        }
        if (results[2] == userInput) {
            displayAddition.setText("CORRECT");
            correct++;
            additionDisplayCorrect.setText("Correct: " + String.valueOf(correct));
            score++;
        } else {
            displayAddition.setText("WRONG");
            wrong++;
            additionDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        }

        //Create delay so user knows if its right or wrong.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                newQuestion();
            }
        }, 300);


    }

    /**
     * Generates new Question and resets
     * user input.
     */
    private void newQuestion() {
        if (score == 2) {
            level++;
        }

        if (score == 4) {
            level++;
        }

        if (score == 6) {
            level++;
        }

        if (score == 8) {
            level++;
        }

        generateAddition();
        displayAddition.setText(results[0] + " + " + results[1] + " =  ?");
        addInput.setText("");
    }

    /**
     * Action Listener for our check button
     * that will run through the check.
     */
    public void onClickCheckButtonListener() {
        checkButton = (Button) findViewById(R.id.checkButtonActivity);
        checkButton.setText("Check");
        checkButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        checkAnswer();
                    }
                }
        );
    }
}
