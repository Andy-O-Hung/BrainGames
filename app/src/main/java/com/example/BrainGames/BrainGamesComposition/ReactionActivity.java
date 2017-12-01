package com.example.BrainGames.BrainGamesComposition;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ReactionActivity extends AppCompatActivity {

    TextView textView ;

    Button start, pause, reset, testB ;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);

        testB = (Button) findViewById(R.id. reactionTestActivity);
        testB.setBackgroundColor(Color.RED);
        testB.setEnabled(false);

        //starts the stopwatch
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                StartTime = SystemClock.uptimeMillis();
//                handler.postDelayed(runnable, 0);
//
//                reset.setEnabled(false);
//
//            }
//        });

        //stops the stopwatch
//        pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                TimeBuff += MillisecondTime;
//
//                handler.removeCallbacks(runnable);
//
//                //reset.setEnabled(true);
//
//            }
//        });

        //resets the stopwatch
//        reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                MillisecondTime = 0L ;
//                StartTime = 0L ;
//                TimeBuff = 0L ;
//                UpdateTime = 0L ;
//                Seconds = 0 ;
//                Minutes = 0 ;
//                MilliSeconds = 0 ;
//
//                textView.setText("00:00:00");
//
//
//            }
//        });

    //THIS BRACKET ENDS THE onCreate METHOD!!!!!!!!!!!!!!
    }

    //This will be the run the stopwatch
//    public Runnable runnable = new Runnable() {
//
//        public void run() {
//
//            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
//
//            UpdateTime = TimeBuff + MillisecondTime;
//
//            Seconds = (int) (UpdateTime / 1000);
//
//            Minutes = Seconds / 60;
//
//            Seconds = Seconds % 60;
//
//            MilliSeconds = (int) (UpdateTime % 1000);
//
//            textView.setText("" + Minutes + ":"
//                    + String.format("%02d", Seconds) + ":"
//                    + String.format("%03d", MilliSeconds));
//
//            handler.postDelayed(this, 0);
//        }
//
//    };

}
