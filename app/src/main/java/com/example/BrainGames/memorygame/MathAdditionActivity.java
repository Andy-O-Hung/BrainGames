package com.example.BrainGames.memorygame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class MathAdditionActivity extends AppCompatActivity {
    private int additionLevel;
    private int result;
    private int[] additionFactors;
    private int correctAnswers = 0;
    private Random rand = new Random();
    private TextView displayAddition;
    private String displayString;
    private TextView addInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_addition);
        displayAddition = (TextView)findViewById(R.id.displayAdditionQuestion);
        //additionFactors = generateSum(getAdditionLevel());
        displayString = String.valueOf(additionFactors[0]) + " + " + String.valueOf(additionFactors[1]) + " = ?";
        displayAddition.setText(displayString);
        addInput = (TextView)findViewById(R.id.additionInput);
        checkAnswer();

    }

//    private int[] generateSum(int addLevel) {
//
//        int topAdd;
//        int a;
//        int b;
//        int c;
//        int[] factors = new int[3];
//
//        if(addLevel == 1)
//        {
//            topAdd = 20;
//        }
//        else if(addLevel == 2)
//        {
//            topAdd = 50;
//        }
//        else if(addLevel == 3)
//        {
//            topAdd = 120;
//        }
//        else if(addLevel == 4)
//        {
//            topAdd = 200;
//        } else  {
//            topAdd = 400;
//        }
//
//        a = rand.nextInt(topAdd) + 1;
//        b = rand.nextInt(topAdd) + 1;
//        c = a + b;
//
//        factors[0] = a;
//        factors[1] = b;
//        factors[2] = c;
//
//        return factors;
//    }

    public int getAdditionLevel() {
        if (this.correctAnswers <= 10) {
            return 1;
        }
        else if (this.correctAnswers <= 20) {
            return 2;
        }
        else if (this.correctAnswers <= 30) {
            return 3;
        }
        else if (this.correctAnswers <= 40) {
            return 4;
        } else {
            return 5;
        }
    }

    private void checkAnswer(){
        // result = Integer.parseInt(addInput.getText().toString());

    }
}
