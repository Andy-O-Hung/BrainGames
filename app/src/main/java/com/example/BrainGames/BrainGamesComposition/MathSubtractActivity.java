package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the class that will run the subtraction game.
 */
public class MathSubtractActivity extends AppCompatActivity {

    /** Initialize the check button object. */
    private static Button checkButton;

    /** Initialize the TextView object for
     * displaying the question. */
    private TextView displaySubtraction;

    /** Initialize the user input. */
    private int userInput;

    /** Initialize the EditText object for
     * the user to input an answer. */
    private EditText subInput;

    /** Initialize the math object. */
    private Math math;

    /** Initialize the results. */
    private int[] results;

    /** Initialize the level to 1. */
    private int level = 1;

    /** Initialize the score to 0. */
    private int score = 0;

    /** Initialize the TextView object that will
     * display the amount of correct questions. */
    private TextView subtractionDisplayCorrect;

    /** Initialize the amount of correct
     * answers. */
    private int correct = 0;

    /** Initialize the TextView object for showing
     * the amount of wrong questions. */
    private TextView subtractionDisplayWrong;

    /** Initialize the amount of wrong questions to 0. */
    private int wrong = 0;

    /**
     * Initializes all the components of our color memory
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_subtract);

        //Initialize the display of the text
        displaySubtraction = (TextView) findViewById(R.id.displaySubtractionQuestion);
        generateSubtraction();
        displaySubtraction.setText(results[0] + " - " + results[1] + " =  ?");
        subInput = (EditText) findViewById(R.id.inputSubtraction);
        subInput.setText("");
        subtractionDisplayCorrect = (TextView) findViewById(R.id.subtractionDisplayCorrectActivity);
        subtractionDisplayCorrect.setText("Correct: " + String.valueOf(correct));
        subtractionDisplayWrong = (TextView) findViewById(R.id.subtractionDisplayWrongActivity);
        subtractionDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        onClickCheckButtonListener();
    }

    /**
     * Generates a new subtraction question.
     */
    public void generateSubtraction() {
        math = new Math(level);
        math.generateSub();
        results = math.getNumbers();
    }

    /**
     * Action listener for the check button that will
     * call the checkAnswer method.
     */
    public void onClickCheckButtonListener() {
        checkButton = (Button) findViewById(R.id.checkSubAnswerButton);
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

    /**
     * Checks if the input from the user is correct, adjusts
     * the correct counter and wrong counter, calls new question.
     */
    private void checkAnswer() {
        //To create delay so that the
        //user knows correct or wrong.
        final android.os.Handler handler = new android.os.Handler();
        try {
            userInput = Integer.valueOf(String.valueOf(subInput.getText()));
        } catch (NumberFormatException ex) {
            displaySubtraction.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    newQuestion();
                }
            }, 300);
            return;
        }
        if (results[2] == userInput) {
            displaySubtraction.setText("CORRECT");
            correct++;
            subtractionDisplayCorrect.setText("Correct: " + String.valueOf(correct));
            score++;
        } else {
            displaySubtraction.setText("WRONG");
            wrong++;
            subtractionDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        }

        //Create delay so user knows if its right or wrong.
        //Then generates a new question.
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

        Math newMath = new Math(level);
        newMath.generateSub();
        results = newMath.getNumbers();
        displaySubtraction.setText(results[0] + " - " + results[1] + " =  ?");
        subInput.setText("");
    }
}
