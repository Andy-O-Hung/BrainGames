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
    public void generateSum() throws Exception {
        Math mathObject = new Math(3);
        mathObject.generateSum();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first + second);
    }

    @Test
    public void generateSub() throws Exception {

        Math mathObject = new Math(3);
        mathObject.generateSub();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first - second);
    }

    @Test
    public void generateMul() throws Exception {
        Math mathObject = new Math(3);
        mathObject.generateMul();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first * second);
    }

    @Test
    public void generateDiv() throws Exception {
        Math mathObject = new Math(3);
        mathObject.generateDiv();
        int[] results = mathObject.getNumbers();
        int first = results[0];
        int second = results[1];
        int answer = results[2];
        assertEquals(answer, first / second);
    }

}