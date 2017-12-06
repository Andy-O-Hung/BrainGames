package com.example.BrainGames.BrainGamesComposition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * The activity for our splash screen.
 */
public class HomeActivity extends AppCompatActivity {

    /**
     * Initializes all the components of our splash screen
     * game activity.
     * @param savedInstanceState Android save instance.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        SplashScreenLauncher splashLauncher = new SplashScreenLauncher();
        splashLauncher.start();
    }

    /**
     * Creates a delay before switching activities.
     */
    private class SplashScreenLauncher extends Thread {

        /**
         * The delay code.
         */
        public void run() {
            try {
                sleep(4500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            HomeActivity.this.finish();
        }
    }
}