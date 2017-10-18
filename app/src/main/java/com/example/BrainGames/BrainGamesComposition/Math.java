package com.example.BrainGames.BrainGamesComposition;

import java.util.Random;

/**
 * Created by Andy Hung on 10/15/2017.
 */

public class Math {


    private int level;


    private int[] numbers;


    public Math(int level){

        this.level = level;
    }

    public int[] getNumbers(){
        int[] tempNumbers = numbers;
        return tempNumbers;
    }

    public void generateSum() {
        //private Random rand = new Random();
        numbers = new int[3];
        if ( level == 1){

            for (int x = 0; x < 2; x++){
                //randOne = new Random();
                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 2){


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 2; x++){

                numbers[x] = -99 + new Random().nextInt(100);
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 4){


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 2; x++){

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] + numbers[1];
        }


    }

    public void generateSub() {
        //private Random rand = new Random();
        numbers = new int[3];
        if ( level == 1){

            for (int x = 0; x < 2; x++){

                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 2){


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 2; x++){

                numbers[x] = -99 + new Random().nextInt(199);
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 4){


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 2; x++){

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] - numbers[1];
        }


    }

    public void generateMul() {
        //private Random rand = new Random();
        numbers = new int[3];
        if ( level == 1){

            for (int x = 0; x < 2; x++){

                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 2){


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 2; x++){

                numbers[x] = -99 + new Random().nextInt(199);
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 4){


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 2; x++){

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] * numbers[1];
        }


    }

    public void generateDiv() {
        //private Random rand = new Random();
        numbers = new int[3];
        if ( level == 1){

            for (int x = 0; x < 2; x++){

                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 2){


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 2; x++){

                numbers[x] = -99 + new Random().nextInt(199);
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 4){


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 2; x++){

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] / numbers[1];
        }


    }
}
