package com.example.BrainGames.BrainGamesComposition;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class LetterMemoryActivity extends AppCompatActivity {

    private TextView displayLetterMemory, displayLetterStreak, displayLetterFails;

    private EditText userInput;

    private Button checkButton;

    private String[] userInputStorage;

    private String[] computerGenerated;

    private int level = 1;

    private int scoreCorrect = 0;

    private int scoreWrong = 0;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_memory);

        displayLetterMemory = (TextView) findViewById(R.id.letterMemoryTextViewLayout);

        displayLetterStreak = (TextView) findViewById(R.id.letterScoreLayout);
        displayLetterStreak.setText("Streak: " + String.valueOf(scoreCorrect));

        displayLetterFails = (TextView) findViewById(R.id.letterIncorrectLayout);
        displayLetterFails.setText("Fails: " + String.valueOf(scoreWrong));

        userInput = (EditText) findViewById(R.id.letterInputLayout);

        checkButton = (Button) findViewById(R.id.letterCheckLayoutButton);

        generateQuestion();
        printQuestion();
        onClickCheckButtonListener();
    }

    public void generateQuestion() {
        computerGenerated = new String[level];
        for (int x = 0; x < level; x++) {
            int rand = 97 + new Random().nextInt(26);
            char charLetter = (char) rand;
            computerGenerated[x] = String.valueOf(charLetter);
        }

    }

    public void printQuestion() {
        String memorize = "";
        for (int x = 0; x < computerGenerated.length; x++) {
            memorize = memorize + computerGenerated[x];
        }
        displayLetterMemory.setText(memorize);

        final android.os.Handler handler = new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayLetterMemory.setText("");
            }
        }, 3000);
    }

    public boolean checkUserInput() {
        int counter = 0;
        for (int x = 0; x < computerGenerated.length; x++) {
            if (userInputStorage[x].equalsIgnoreCase(computerGenerated[x])) {
                counter++;
            }
        }
        return counter == computerGenerated.length;
    }

    public void onClickCheckButtonListener() {
        checkButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                         if ((userInput.length() > computerGenerated.length) || (userInput.length() < computerGenerated.length)) {
                             displayLetterMemory.setText("INCORRECT");
                             level = 1;
                             generateQuestion();
                             final android.os.Handler handler = new android.os.Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     printQuestion();
                                 }
                             }, 500);
                             userInput.setText("");
                             scoreWrong++;
                             displayLetterFails.setText("Fails: " + String.valueOf(scoreWrong));

                         } else {
                             String tempUserInput = String.valueOf(userInput.getText());
                             userInputStorage = new String[computerGenerated.length];
                             for (int x = 0; x < tempUserInput.length(); x++) {
                                 userInputStorage[x] = String.valueOf(tempUserInput.charAt(x));
                             }
                             if (checkUserInput()) {
                                 level++;
                                 displayLetterMemory.setText("CORRECT");
                                 generateQuestion();
                                 final android.os.Handler handler = new android.os.Handler();
                                 handler.postDelayed(new Runnable() {
                                     @Override
                                     public void run() {
                                         printQuestion();
                                     }
                                 }, 500);

                                 userInput.setText("");
                                 scoreCorrect++;
                                 displayLetterStreak.setText("Streak: " + String.valueOf(scoreCorrect));
                             } else {
                                 displayLetterMemory.setText("INCORRECT");
                                 level = 1;
                                 generateQuestion();
                                 final android.os.Handler handler = new android.os.Handler();
                                 handler.postDelayed(new Runnable() {
                                     @Override
                                     public void run() {
                                         printQuestion();
                                     }
                                 }, 500);
                                 userInput.setText("");
                                 scoreWrong++;
                                 displayLetterFails.setText("Fails: " + String.valueOf(scoreWrong));
                             }

                         }


                    }
                }
        );
    }
}
