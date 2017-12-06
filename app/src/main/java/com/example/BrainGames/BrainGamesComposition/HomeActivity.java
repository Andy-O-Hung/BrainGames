package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        splashScreenLauncher splashLauncher = new splashScreenLauncher();
        splashLauncher.start();
    }

    private class splashScreenLauncher extends Thread{
        public void run(){
            try{
                sleep(4500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            HomeActivity.this.finish();
        }
    }
}