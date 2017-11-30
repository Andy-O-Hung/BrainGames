package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MathDivisionActivity extends AppCompatActivity {

    /** Initialize.  */
    private TextView displayDivision;

    /** Initialize the math object. */
    private Math math;

    /** Initialize the level to 1. */
    private int level = 1;

    /** Initialize the results. */
    private int[] results;

    private Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_division);
        displayDivision = (TextView) findViewById(R.id.displayDivisionQuestion);
        generateDivision();
        displayDivision.setText(results[0] + " / " + results[1] + " = " + results[2]);
        onClickChangeButtonListener();
    }

    public void generateDivision() {
        math = new Math(level);
        math.generateDiv();
        results = math.getNumbers();
        displayDivision.setText(results[0] + " / " + results[1] + " = " + results[2]);
    }

    public void onClickChangeButtonListener() {
        changeButton = (Button) findViewById(R.id.divisionChangeQuestionActivity);
        changeButton.setText("Change");
        changeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        level++;
                        generateDivision();
                    }
                }
        );
    }
}
