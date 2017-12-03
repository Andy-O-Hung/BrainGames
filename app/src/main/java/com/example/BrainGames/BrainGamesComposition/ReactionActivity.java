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

    private TextView stopWatchTextView;

    private Button startButton, resetButton, reactionButton;

    private long millisecondTime, startTime, timeBuff, updateTime = 0L;

    private Handler handler;

    private int seconds, minutes, milliSeconds;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);

        reactionButton = (Button) findViewById(R.id.reactionLayoutButton);
        reactionButton.setBackgroundColor(Color.RED);
        reactionButton.setEnabled(false);

        resetButton = (Button) findViewById(R.id.reactionResetLayoutButton);

        startButton = (Button) findViewById(R.id.reactionStartLayoutButton);

        stopWatchTextView = (TextView) findViewById(R.id.stopWatchTextViewLayout);
        stopWatchTextView.setText("");

        handler = new Handler();

        onClickReactionButtonListener();
        onClickResetButtonListener();
        onClickStartButtonListener();

        resetButton.setEnabled(false);


    //THIS BRACKET ENDS THE onCreate METHOD!!!!!!!!!!!!!!
    }

    public void onClickReactionButtonListener() {
        reactionButton = (Button) findViewById(R.id.reactionLayoutButton);
        reactionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        stopStopWatch();
                        resetButton.setEnabled(true);

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
                        reactionButton.setEnabled(false);
                        reactionButton.setBackgroundColor(Color.RED);
                        startButton.setEnabled(true);
                        resetButton.setEnabled(false);
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

    public void countDownTimer() {
        int randomTime = 1 + new Random().nextInt(4);
        final CountDownTimer countDownTimer = new CountDownTimer(randomTime * 1000, 1000) {
            @Override
            public void onTick(final long millis) {

            }

            @Override
            public void onFinish() {
                stopWatchTextView.setText("Finish");
                reactionButton.setBackgroundColor(Color.GREEN);
                reactionButton.setEnabled(true);
                startStopWatch();

                //maybe for 2x2?
                int pickRandom = new Random().nextInt(4);
            }
        }.start();
    }

    public void stopStopWatch() {
                timeBuff += millisecondTime;

                handler.removeCallbacks(runnable);
    }

    public void startStopWatch() {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                //resetButton.setEnabled(false);
    }

    public void resetStopWatch() {
                millisecondTime = 0L;
                startTime = 0L;
                timeBuff = 0L;
                updateTime = 0L;
                seconds = 0;
                minutes = 0;
                milliSeconds = 0;

                stopWatchTextView.setText("00:00:00");
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
