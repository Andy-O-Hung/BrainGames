package com.example.BrainGames.BrainGamesComposition;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import java.util.Random;

public class ReactionActivity extends AppCompatActivity {

    private TextView stopWatchTextView, stopWatchWonView, stopWatchLoseView, remainLeft, state;

    private Button startButton, resetButton, stopButton, reactionButton0, reactionButton1,
    reactionButton2, reactionButton3;

    private long millisecondTime, startTime, timeBuff, updateTime = 0L;

    private Handler handler;

    private int seconds, minutes, milliSeconds, won = 0, lost = 0, remain = 5;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);

        reactionButton0 = (Button) findViewById(R.id.reactionLayoutButton0);
        reactionButton0.setBackgroundColor(Color.RED);
        reactionButton0.setEnabled(false);

        reactionButton1 = (Button) findViewById(R.id.reactionLayoutButton1);
        reactionButton1.setBackgroundColor(Color.RED);
        reactionButton1.setEnabled(false);

        reactionButton2 = (Button) findViewById(R.id.reactionLayoutButton2);
        reactionButton2.setBackgroundColor(Color.RED);
        reactionButton2.setEnabled(false);

        reactionButton3 = (Button) findViewById(R.id.reactionLayoutButton3);
        reactionButton3.setBackgroundColor(Color.RED);
        reactionButton3.setEnabled(false);

        resetButton = (Button) findViewById(R.id.reactionResetLayoutButton);

        startButton = (Button) findViewById(R.id.reactionStartLayoutButton);

        stopWatchTextView = (TextView) findViewById(R.id.stopWatchTextViewLayout);
        stopWatchTextView.setText("" + minutes + ":"
                + String.format("%02d", seconds) + ":"
                + String.format("%03d", milliSeconds));

        stopWatchWonView = (TextView) findViewById(R.id.reactionWonLayout);
        stopWatchWonView.setText("scored: " + String.valueOf(won));

        stopWatchLoseView = (TextView) findViewById(R.id.reactionLoseLayout);
        stopWatchLoseView.setText("missed: " + String.valueOf(lost));

        remainLeft = (TextView) findViewById(R.id.reactionRemainViewLayout);
        remainLeft.setText(String.valueOf("Remaining Clicks: " + remain));

        state = (TextView) findViewById(R.id.reactionStateLayout);
        state.setText("State: Idle");

        handler = new Handler();

        onClickReactionButtonListener();
        onClickResetButtonListener();
        onClickStartButtonListener();
        //onClickStopButtonListener();

        resetButton.setEnabled(false);


    //THIS BRACKET ENDS THE onCreate METHOD!!!!!!!!!!!!!!
    }

    public void onClickReactionButtonListener() {
        //reactionButton0 = (Button) findViewById(R.id.reactionLayoutButton0);
        reactionButton0.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        //stopStopWatch();

                        remain--;
                        remainLeft.setText("Remaining Clicks: " + String.valueOf(remain));
                        resetButton.setEnabled(true);
                        resetStopWatch();
                        reactionButton0.setBackgroundColor(Color.RED);
                        reactionButton0.setEnabled(false);
                        if (remain == 0 ){
                            if (won >= 4){
                                state.setText("State: Done! Wow your fast!");
                            }
                            else if (won < 4 && won > 1){
                                state.setText("State: Done! Your average.");
                            }
                            else {
                                state.setText("State: Done! What are you doing?");
                            }
                            return;
                        }
                        countDownTimer();
                    }
                }
        );
        reactionButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        //stopStopWatch();

                        remain--;
                        remainLeft.setText("Remaining Clicks: " + String.valueOf(remain));
                        resetButton.setEnabled(true);
                        resetStopWatch();
                        reactionButton1.setBackgroundColor(Color.RED);
                        reactionButton1.setEnabled(false);
                        if (remain == 0 ){
                            if (won >= 4){
                                state.setText("State: Done! Wow your fast!");
                            }
                            else if (won < 4 && won > 1){
                                state.setText("State: Done! Your average.");
                            }
                            else {
                                state.setText("State: Done! What are you doing?");
                            }
                            return;
                        }
                        countDownTimer();
                    }
                }
        );
        reactionButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        //stopStopWatch();

                        remain--;
                        remainLeft.setText("Remaining Clicks: " + String.valueOf(remain));
                        resetButton.setEnabled(true);
                        resetStopWatch();
                        reactionButton2.setBackgroundColor(Color.RED);
                        reactionButton2.setEnabled(false);
                        if (remain == 0 ){
                            if (won >= 4){
                                state.setText("State: Done! Wow your fast!");
                            }
                            else if (won < 4 && won > 1){
                                state.setText("State: Done! Your average.");
                            }
                            else {
                                state.setText("State: Done! What are you doing?");
                            }
                            return;
                        }
                        countDownTimer();
                    }
                }
        );
        reactionButton3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        //stopStopWatch();
                        remain--;
                        remainLeft.setText("Remaining Clicks: " + String.valueOf(remain));
                        resetButton.setEnabled(true);
                        resetStopWatch();
                        reactionButton3.setBackgroundColor(Color.RED);
                        reactionButton3.setEnabled(false);
                        if (remain == 0 ){
                            if (won >= 4){
                                state.setText("State: Done! Wow your fast!");
                            }
                            else if (won < 4 && won > 1){
                                state.setText("State: Done! Your average.");
                            }
                            else {
                                state.setText("State: Done! What are you doing?");
                            }
                            return;
                        }
                        countDownTimer();
                    }
                }
        );
    }

    public void onClickResetButtonListener() {
        resetButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        resetStopWatch();
                        reactionButton0.setEnabled(false);
                        reactionButton0.setBackgroundColor(Color.RED);
                        reactionButton1.setEnabled(false);
                        reactionButton1.setBackgroundColor(Color.RED);
                        reactionButton2.setEnabled(false);
                        reactionButton2.setBackgroundColor(Color.RED);
                        reactionButton3.setEnabled(false);
                        reactionButton3.setBackgroundColor(Color.RED);
                        startButton.setEnabled(true);
                        resetButton.setEnabled(false);
                        remain = 5;
                        remainLeft.setText("Remaining Clicks: " + String.valueOf(remain));
                        won = 0;
                        lost = 0;
                        stopWatchWonView.setText("Scored: " + String.valueOf(won));
                        stopWatchLoseView.setText("Missed: " + String.valueOf(lost));
                        state.setText("State: Idle");
                    }
                }
        );
    }

    public void onClickStartButtonListener() {
        startButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        countDownTimer();
                        startButton.setEnabled(false);

                    }
                }
        );
    }

    public void onClickStopButtonListener() {
//        stopButton.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(final View view) {
//                        stopStopWatch();
//                    }
//                }
//        );
    }

    public void countDownTimer() {
        int randomTime = 1 + new Random().nextInt(4);
        state.setText("State: Ready!");
        final CountDownTimer countDownTimer = new CountDownTimer(randomTime * 1000, 1000) {
            @Override
            public void onTick(final long millis) {

            }

            @Override
            public void onFinish() {
                int pickRandom = new Random().nextInt(4);
                if (pickRandom == 0){
                    reactionButton0.setBackgroundColor(Color.GREEN);
                    reactionButton0.setEnabled(true);
                    startStopWatch();
                }
                if (pickRandom == 1){
                    reactionButton1.setBackgroundColor(Color.GREEN);
                    reactionButton1.setEnabled(true);
                    startStopWatch();
                }
                if (pickRandom == 2){
                    reactionButton2.setBackgroundColor(Color.GREEN);
                    reactionButton2.setEnabled(true);
                    startStopWatch();
                }
                if (pickRandom == 3){
                    reactionButton3.setBackgroundColor(Color.GREEN);
                    reactionButton3.setEnabled(true);
                    startStopWatch();
                }

            }
        }.start();
    }

    public void stopStopWatch() {
                timeBuff += millisecondTime;
                handler.removeCallbacks(runnable);
                startButton.setEnabled(true);
    }

    public void startStopWatch() {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                state.setText("State: Click!");
                //resetButton.setEnabled(false);
    }

    public void resetStopWatch() {
                 if (seconds >= 1){
                     lost++;
                     stopWatchLoseView.setText("Missed: " + String.valueOf(lost));

                 }
                 else {
                       won++;
                      stopWatchWonView.setText("Scored: " + String.valueOf(won));
                    }
                millisecondTime = 0L;
                startTime = 0L;
                timeBuff = 0L;
                updateTime = 0L;
                seconds = 0;
                minutes = 0;
                milliSeconds = 0;
                stopWatchTextView.setText("00:00:00");
                handler.removeCallbacks(runnable);

    }
    //This will be the run the stopwatch
    private Runnable runnable = new Runnable() {

        public void run() {

            millisecondTime = SystemClock.uptimeMillis() - startTime;

            updateTime = timeBuff + millisecondTime;

            seconds = (int) (updateTime / 1000);

            minutes = seconds / 60;

            seconds = seconds % 60;

            milliSeconds = (int) (updateTime % 1000);

            stopWatchTextView.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliSeconds));

            handler.postDelayed(this, 0);
        }

    };

}
