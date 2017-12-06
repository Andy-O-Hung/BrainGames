package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * The activity of our math combination game.
 */
public class  MathCombinationActivity extends AppCompatActivity {
    /** Initialize the check button. */
    private Button checkButton;

    /** Initialize the display question.  */
    private TextView displayCombination;

    /** Initialize the user's input. */
    private int userInput;

    /** Initialize the input. */
    private EditText combInput;

    /** Initialize the math. */
    private Math math;

    /** Initialize the results. */
    private int[] results;

    /** Initialize the level to 1. */
    private int level = 1;

    /** Initialize the score to 0. */
    private int score = 0;

    /** Initialize the stopWatchTextView object for "correct". */
    private TextView combinationDisplayCorrect;

    /** Initialize the amount of answers correct to 0. */
    private int correct = 0;

    /** Initialize the TextView object for "wrong". */
    private TextView combinationDisplayWrong;

    /** Initialize the amount of wrong answers to 0. */
    private int wrong = 0;

//    /** Initialize the random number generator for the combination function */
//    private int value = 0;

    /** Initialize the randomizer.*/
    private Random rand = new Random();

    /** Initialize label string.*/
    private String label = "";


    /**
     * Initializes all the components of our combination
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_combination);

        //Initialize what the texts display
        displayCombination = (TextView) findViewById(R.id.combinationQuestionLayout);
        generateCombination();
        displayCombination.setText(results[0] + label + results[1] + " =  ?");
        combInput = (EditText) findViewById(R.id.combinationInput);
        combInput.setText("");
        combinationDisplayCorrect = (TextView) findViewById(R.id.combinationDisplayCorrectActivity);
        combinationDisplayCorrect.setText("Correct: " + String.valueOf(correct));
        combinationDisplayWrong = (TextView) findViewById(R.id.combinationDisplayWrongActivity);
        combinationDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
        onClickCheckButtonListener();
    }
    /**
     * This will generate a new multiplication question.
     */
    public void generateCombination() {
        math = new Math(level);
        int value = rand.nextInt(4);

        if (value == 0) {
            math.generateMul();
            label = " * ";
        } else if (value == 1) {
            math.generateDiv();
            label = " / ";
        } else if (value == 2) {
            math.generateSub();
            label = " - ";
        } else if (value == 3) {
            math.generateSum();
            label = " + ";
        }

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
            userInput = Integer.parseInt(String.valueOf(combInput.getText()));
        } catch (NumberFormatException ex) {
            displayCombination.setText("ENTER A INTEGER!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    newQuestion();
                }
            }, 300);
            return;
        }
        if (results[2] == userInput) {
            displayCombination.setText("CORRECT");
            correct++;
            combinationDisplayCorrect.setText("Correct: " + String.valueOf(correct));
            score++;
        } else {
            displayCombination.setText("WRONG");
            wrong++;
            combinationDisplayWrong.setText("Wrong: " + String.valueOf(wrong));
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

        generateCombination();
        displayCombination.setText(results[0] + label + results[1] + " =  ?");
        combInput.setText("");
    }

    /**
     * Action Listener for our check button
     * that will run through the check.
     */
    public void onClickCheckButtonListener() {
        checkButton = (Button) findViewById(R.id.combinationCheckButtonActivity);
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
