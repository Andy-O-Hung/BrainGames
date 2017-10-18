package com.example.BrainGames.memorygame;

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
        //additionFactors = generateSum(getAdditionLevel());
        //displayString = String.valueOf(additionFactors[0]) + " + " + String.valueOf(additionFactors[1]) + " = ?";
        //displayAddition.setText(displayString);
        generateAddition();
        displayAddition.setText(results[0] + " + " + results[1] + " =  ?");
        addInput = (EditText) findViewById(R.id.additionInput);
        OnClickCheckButtonListener();
    }

    public void generateAddition(){
        math = new Math(level);
        math.generateSum();
        results = math.getNumbers();
    }

    private void checkAnswer(){
        userInput = Integer.valueOf(String.valueOf(addInput.getText()));
        if(results[2] == userInput){
            displayAddition.setText("CORRECT");
        }
        else{
            displayAddition.setText("WRONG");
        }

    }
    public void OnClickCheckButtonListener(){
        checkButton = (Button) findViewById(R.id.checkButtonActivity);
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
