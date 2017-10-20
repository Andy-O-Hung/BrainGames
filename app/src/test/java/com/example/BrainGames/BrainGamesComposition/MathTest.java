package com.example.BrainGames.BrainGamesComposition;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for our math model.
 */
public class MathTest {

    /**
     * Tests if getting the numbers array works.
     * @throws Exception
     */
    @Test
    public void getNumbers() throws Exception {
        Math mathObject = new Math(1);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        //Log.d("getNumbersTest", "getNumbers: " + results[0] + results[1] + results[2]);
        assertEquals(answer, first + second);
    }

    /**
     * Tests if generating a level one addition question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSumLevelOne() throws Exception {
        Math mathObject = new Math(1);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first + second);
    }

    /**
     * Tests if generating a level two addition question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSumLevelTwo() throws Exception {
        Math mathObject = new Math(2);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first + second);
    }

    /**
     * Tests if generating a level three addition question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSumLevelThree() throws Exception {
        Math mathObject = new Math(3);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first + second);
    }

    /**
     * Tests if generating a level four addition question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSumLevelFour() throws Exception {
        Math mathObject = new Math(4);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first + second);
    }

    /**
     * Tests if generating a level five addition question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSumLevelFive() throws Exception {
        Math mathObject = new Math(5);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first + second);
    }

    /**
     * Tests if generating a level one subtraction question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSubLevelOne() throws Exception {

        Math mathObject = new Math(1);
        mathObject.generateSub();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first - second);
    }

    /**
     * Tests if generating a level two subtraction question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSubLevelTwo() throws Exception {

        Math mathObject = new Math(2);
        mathObject.generateSub();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first - second);
    }

    /**
     * Tests if generating a level three subtraction question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSubLevelThree() throws Exception {

        Math mathObject = new Math(3);
        mathObject.generateSub();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first - second);
    }

    /**
     * Tests if generating a level four subtraction question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSubLevelFour() throws Exception {

        Math mathObject = new Math(4);
        mathObject.generateSub();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first - second);
    }

    /**
     * Tests if generating a level five subtraction question
     * works.
     * @throws Exception
     */
    @Test
    public void generateSubLevelFive() throws Exception {

        Math mathObject = new Math(5);
        mathObject.generateSub();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first - second);
    }

    /**
     * Tests if generating a level one multiplication question
     * works.
     * @throws Exception
     */
    @Test
    public void generateMulLevelOne() throws Exception {
        Math mathObject = new Math(1);
        mathObject.generateMul();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first * second);
    }

    /**
     * Tests if generating a level two multiplication question
     * works.
     * @throws Exception
     */
    @Test
    public void generateMulLevelTwo() throws Exception {
        Math mathObject = new Math(2);
        mathObject.generateMul();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first * second);
    }

    /**
     * Tests if generating a level three multiplication question
     * works.
     * @throws Exception
     */
    @Test
    public void generateMulLevelThree() throws Exception {
        Math mathObject = new Math(3);
        mathObject.generateMul();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first * second);
    }

    /**
     * Tests if generating a level four multiplication question
     * works.
     * @throws Exception
     */
    @Test
    public void generateMulLevelFour() throws Exception {
        Math mathObject = new Math(4);
        mathObject.generateMul();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first * second);
    }

    /**
     * Tests if generating a level five multiplication question
     * works.
     * @throws Exception
     */
    @Test
    public void generateMulLevelFive() throws Exception {
        Math mathObject = new Math(5);
        mathObject.generateMul();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first * second);
    }

    /**
     * Tests if generating a level one division question
     * works.
     * @throws Exception
     */
    @Test
    public void generateDivLevelOne() throws Exception {
        Math mathObject = new Math(1);
        mathObject.generateDiv();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first / second);
    }

    /**
     * Tests if generating a level two division question
     * works.
     * @throws Exception
     */
    @Test
    public void generateDivLevelTwo() throws Exception {
        Math mathObject = new Math(2);
        mathObject.generateDiv();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first / second);
    }

    /**
     * Tests if generating a level three division question
     * works.
     * @throws Exception
     */
    @Test
    public void generateDivLevelThree() throws Exception {
        Math mathObject = new Math(3);
        mathObject.generateDiv();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first / second);
    }

    /**
     * Tests if generating a level four division question
     * works.
     * @throws Exception
     */
    @Test
    public void generateDivLevelFour() throws Exception {
        Math mathObject = new Math(4);
        mathObject.generateDiv();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first / second);
    }

    /**
     * Tests if generating a level five division question
     * works.
     * @throws Exception
     */
    @Test
    public void generateDivLevelFive() throws Exception {
        Math mathObject = new Math(5);
        mathObject.generateDiv();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first / second);
    }
}