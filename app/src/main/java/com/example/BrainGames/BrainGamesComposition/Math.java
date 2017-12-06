package com.example.BrainGames.BrainGamesComposition;

import java.util.Random;

/**
 * The math class, math model for our math games.
 */
public class Math {

    /** Initialize the level. */
    private int level;

    /** Initialize the numbers. */
    private int[] numbers;

    /**
     * Math Constructor that will generate the question
     * based on the level.
     * @param level the difficulty of the question.
     */
    public Math(final int level) {

        this.level = level;
    }

    /**
     * Get the math objects numbers and answer.
     * @return returns a copy of the math objects numbers.
     */
    public int[] getNumbers() {
        int[] tempNumbers = numbers;
        return tempNumbers;
    }

    /**
     * Generates addition questions.
     */
    public void generateSum() {

        numbers = new int[3];
        if (level == 1) {

            for (int x = 0; x < 2; x++) {
                //randOne = new Random();
                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        if (level == 2) {


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] + numbers[1];
        }

        if (level == 3) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -99 + new Random().nextInt(199);
            }
            numbers[2] = numbers[0] + numbers[1];
        }

        if (level == 4) {


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] + numbers[1];
        }

        if (level == 5) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] + numbers[1];
        }


    }

    /**
     * Generates subtraction questions.
     */
    public void generateSub() {

        numbers = new int[3];
        if (level == 1) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        if (level == 2) {


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] - numbers[1];
        }

        if (level == 3) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -99 + new Random().nextInt(199);
            }
            numbers[2] = numbers[0] - numbers[1];
        }

        if (level == 4) {


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] - numbers[1];
        }

        if (level == 5) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] - numbers[1];
        }


    }

    /**
     * Generates multiplication questions.
     */
    public void generateMul() {

        numbers = new int[3];
        if (level == 1) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -9 + new Random().nextInt(19);
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        if (level == 2) {


            numbers[0] = -9 + new Random().nextInt(19);

            numbers[1] = -99 + new Random().nextInt(199);
            numbers[2] = numbers[0] * numbers[1];
        }

        if (level == 3) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -99 + new Random().nextInt(199);
            }
            numbers[2] = numbers[0] * numbers[1];
        }

        if (level == 4) {


            numbers[0] = -99 + new Random().nextInt(199);

            numbers[1] = -999 + new Random().nextInt(1999);
            numbers[2] = numbers[0] * numbers[1];
        }

        if (level >= 5) {

            for (int x = 0; x < 2; x++) {

                numbers[x] = -999 + new Random().nextInt(1999);
            }
            numbers[2] = numbers[0] * numbers[1];
        }


    }

    /**
     * Generates division questions.
     */
    public void generateDiv() {

        numbers = new int[3];
        boolean isDivisible = false;

        if (level == 1) {

            while (!isDivisible) {
                for (int x = 0; x < 2; x++) {
                    numbers[x] = -9 + new Random().nextInt(19);
                }
                if (numbers[0] != 0 && numbers[0] != 1 && numbers[1] != 0 && numbers[1] != 1
                        &&
                        numbers[0] != numbers[1] && numbers[0] % numbers[1] == 0) {
                    isDivisible = true;
                }
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if (level == 2) {

            while (!isDivisible) {
                numbers[0] = -9 + new Random().nextInt(19);
                numbers[1] = -99 + new Random().nextInt(199);

                if (numbers[0] != 0 && numbers[0] != 1 && numbers[1] != 0 && numbers[1] != 1
                        &&
                        numbers[0] != numbers[1] && numbers[0] % numbers[1] == 0) {
                    isDivisible = true;
                }
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if (level == 3) {

            while (!isDivisible) {
                for (int x = 0; x < 2; x++) {
                    numbers[x] = -99 + new Random().nextInt(199);
                }

                if (numbers[0] != 0 && numbers[0] != 1 && numbers[1] != 0 && numbers[1] != 1
                        &&
                         numbers[0] != numbers[1] && numbers[0] % numbers[1] == 0) {
                    isDivisible = true;
                }
            }
            numbers[2] = numbers[0] / numbers[1];

        }

        if (level == 4) {

            while (!isDivisible) {
                numbers[0] = -99 + new Random().nextInt(199);
                numbers[1] = -999 + new Random().nextInt(1999);

                if (numbers[0] != 0 && numbers[0] != 1 && numbers[1] != 0 && numbers[1] != 1
                        &&
                        numbers[0] != numbers[1] && numbers[0] % numbers[1] == 0) {
                    isDivisible = true;
                }
            }
            numbers[2] = numbers[0] / numbers[1];
        }

        if (level >= 5) {

            while (!isDivisible) {
                for (int x = 0; x < 2; x++) {
                    numbers[x] = -999 + new Random().nextInt(1999);
                }
                if (numbers[0] != 0 && numbers[0] != 1 && numbers[1] != 0 && numbers[1] != 1
                        &&
                        numbers[0] != numbers[1] && numbers[0] % numbers[1] == 0) {
                    isDivisible = true;
                }
            }
            numbers[2] = numbers[0] / numbers[1];
        }
    }
}
