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

    TextView stopWatchTextView;

    Button startButton, resetButton, reactionButton;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);

        reactionButton = (Button) findViewById(R.id. reactionLayoutButton);
        reactionButton.setBackgroundColor(Color.RED);
        reactionButton.setEnabled(false);

        resetButton = (Button) findViewById(R.id. reactionResetLayoutButton);

        startButton = (Button) findViewById(R.id. reactionStartLayoutButton);

        stopWatchTextView = (TextView) findViewById(R.id. stopWatchTextViewLayout);
        stopWatchTextView.setText("");

        handler = new Handler() ;

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

    public void countDownTimer(){
        int randomTime = 1 + new Random().nextInt(4);
        final CountDownTimer countDownTimer = new CountDownTimer(randomTime * 1000,1000) {
            @Override
            public void onTick(long millis) {

            }

            @Override
            public void onFinish() {
                stopWatchTextView.setText("Finish");
                reactionButton.setBackgroundColor(Color.GREEN);
                reactionButton.setEnabled(true);
                startStopWatch();
                int pickRandom = new Random().nextInt(4);
            }
        }.start();
    }

    public void stopStopWatch(){
                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);
    }

    public void startStopWatch(){
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                //resetButton.setEnabled(false);
    }

    public void resetStopWatch(){
                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                stopWatchTextView.setText("00:00:00");
    }
    //This will be the run the stopwatch
    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            stopWatchTextView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };

}
