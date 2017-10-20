package com.example.BrainGames.BrainGamesComposition;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andy Hung on 10/17/2017.
 */
public class MathTest {
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