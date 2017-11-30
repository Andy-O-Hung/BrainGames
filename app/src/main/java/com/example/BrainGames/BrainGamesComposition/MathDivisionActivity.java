package com.example.BrainGames.BrainGamesComposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_division);
        displayDivision = (TextView) findViewById(R.id.displayDivisionQuestion);
        generateDivision();
        displayDivision.setText(results[0] + " / " + results[1] + " = " + results[2]);
    }

    public void generateDivision() {
        math = new Math(level);
        math.generateDiv();
        results = math.getNumbers();
    }
}
