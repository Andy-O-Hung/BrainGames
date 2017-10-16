package com.example.BrainGames.memorygame;

import java.util.Random;

/**
 * Created by Andy Hung on 10/15/2017.
 */

public class Math {


    private int level;


    private int[] numbers;

    private Random randOne;

    private Random randTwo;
    public Math(int operation, int level){

        this.level = level;
    }

    public int[] getNumbers(){
        return numbers;
    }

    public int[] generateSum() {
        //private Random rand = new Random();
        numbers = new int[2];
        if ( level == 1){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(9 + 1 -9) - 9;
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 2){

            randOne = new Random();
            numbers[0] = randOne.nextInt(9 + 1 -9) - 9;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(99 + 1 -99) -99;
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(99 + 1 -99) - 99;
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 4){

            randOne = new Random();
            numbers[0] = randOne.nextInt(99 + 1 -99) - 99;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(999 + 1 -999) -999;
            numbers[2] = numbers[0] + numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(999 + 1 -999) - 999;
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        return numbers;
    }

    public int[] generateSub() {
        //private Random rand = new Random();
        numbers = new int[2];
        if ( level == 1){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(9 + 1 -9) - 9;
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 2){

            randOne = new Random();
            numbers[0] = randOne.nextInt(9 + 1 -9) - 9;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(99 + 1 -99) -99;
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(99 + 1 -99) - 99;
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 4){

            randOne = new Random();
            numbers[0] = randOne.nextInt(99 + 1 -99) - 99;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(999 + 1 -999) -999;
            numbers[2] = numbers[0] - numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(999 + 1 -999) - 999;
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        return numbers;
    }

    public int[] generateMul() {
        //private Random rand = new Random();
        numbers = new int[2];
        if ( level == 1){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(9 + 1 -9) - 9;
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 2){

            randOne = new Random();
            numbers[0] = randOne.nextInt(9 + 1 -9) - 9;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(99 + 1 -99) -99;
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(99 + 1 -99) - 99;
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 4){

            randOne = new Random();
            numbers[0] = randOne.nextInt(99 + 1 -99) - 99;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(999 + 1 -999) -999;
            numbers[2] = numbers[0] * numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(999 + 1 -999) - 999;
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        return numbers;
    }

    public int[] generateDiv() {
        //private Random rand = new Random();
        numbers = new int[2];
        if ( level == 1){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(9 + 1 -9) - 9;
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 2){

            randOne = new Random();
            numbers[0] = randOne.nextInt(9 + 1 -9) - 9;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(99 + 1 -99) -99;
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 3){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(99 + 1 -99) - 99;
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 4){

            randOne = new Random();
            numbers[0] = randOne.nextInt(99 + 1 -99) - 99;
            randTwo = new Random();
            numbers[1] = randTwo.nextInt(999 + 1 -999) -999;
            numbers[2] = numbers[0] / numbers[1];
        }

        if ( level == 5){

            for (int x = 0; x < 1; x++){
                randOne = new Random();
                numbers[x] = randOne.nextInt(999 + 1 -999) - 999;
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        return numbers;
    }
}
