package org.example.fundamental.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void add_whenPositiveNumbers() {
        // positive case
        int positiveResult = calculatorService.add(5, 10);
        assertEquals(15, positiveResult);
    }

    @Test
    void add_whenNegativeNumbers() {
        // negative case
        int negativeResult = calculatorService.add(-10, 5);
        assertEquals(-5, negativeResult);
    }

    @Test
    void add_whenZeroNumber() {

        int sameResult = calculatorService.add(10, 0);
        assertEquals(10, sameResult);
    }



    @Test
    void isEven_whenEvenNumber() {

        // even number case
        boolean even = calculatorService.isEven(4);
        assertTrue(even);
    }

    @Test
    void isEven_whenOddNumber() {
        // odd number case
        boolean odd = calculatorService.isEven(5);
        assertFalse(odd);
    }
}