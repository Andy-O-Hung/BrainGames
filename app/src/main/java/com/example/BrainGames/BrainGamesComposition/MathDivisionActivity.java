package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MathDivisionActivity extends AppCompatActivity {

    /** Initialize the check button. */
    private Button checkButton;

    /** Initialize.  */
    private TextView displayDivision;

    /** Initialize the user's input. */
    private int userInput;

    /** Initialize the input object. */
    private EditText divInput;

    /** Initialize the math object. */
    private Math math;

    /** Initialize the results. */
    private int[] results;

    /** Initialize the level to 1. */
    private int level = 1;

    /** Initialize the score to 0. */
    private int score = 0;

    /** Initialize the stopWatchTextView object for "correct". */
    private TextView divisionDisplayCorrect;

    /** Initialize the amount of answers correct to 0. */
    private int correct = 0;

    /** Initialize the TextView object for "wrong". */
    private TextView divisionDisplayWrong;

    /** Initialize the amount of wrong answers to 0. */
    private int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_division);

        //Initialize what the texts display
        displayDivision = (TextView) findViewById(R.id.divisionQuestionLayout);
        generateDivision();
        displayDivision.setText(results[0] + " / " + results[1] + " =  ?");
        divInput = (EditText) findViewById(R.id.divisionInput);
        divInput.setText("");
        divisionDisplayCorrect = (TextView) findViewById(R.id.divisionDisplayCorrectActivity);
        divisionDisplayCorrect.setText("Correct: " + String.valueOf(correct));
        divisionDisplayWrong = (TextView) findViewById(R.id.divisionDisplayWrongActivity);
        divisionDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        onClickCheckButtonListener();
    }

    /**
     * This will generate a new multiplication question.
     */
    public void generateDivision() {
        math = new Math(level);
        math.generateDiv();
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
            userInput = Integer.parseInt(String.valueOf(divInput.getText()));
        } catch (NumberFormatException ex) {
            displayDivision.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    newQuestion();
                }
            }, 300);
            return;
        }
        if (results[2] == userInput) {
            displayDivision.setText("CORRECT");
            correct++;
            divisionDisplayCorrect.setText("Correct: " + String.valueOf(correct));
            score++;
        } else {
            displayDivision.setText("WRONG");
            wrong++;
            divisionDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
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

        generateDivision();
        displayDivision.setText(results[0] + " / " + results[1] + " =  ?");
        divInput.setText("");
    }

    /**
     * Action Listener for our check button
     * that will run through the check.
     */
    public void onClickCheckButtonListener() {
        checkButton = (Button) findViewById(R.id.divisionCheckButtonActivity);
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
