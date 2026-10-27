
package com.example.textcounter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test2 {

    private TextMetricsCalculator calculator;

    @Before
    public void setUp() {
        calculator = new TextMetricsCalculator();
    }

    @Test
    public void countSentences_twoSentences_returnsTwo() {
        assertEquals(2, calculator.countSentences("Labas. Kaip sekasi."));
    }

    @Test
    public void countSentences_emptyText_returnsZero() {
        assertEquals(0, calculator.countSentences(""));
    }

    @Test
    public void countWords_threeWords_returnsThree() {
        assertEquals(3, calculator.countWords("Vienas du trys"));
    }

    @Test
    public void countWords_emptyText_returnsZero() {
        assertEquals(0, calculator.countWords(""));
    }

    @Test
    public void countPunctuation_commaSpaceAndPeriod_returnsThree() {
        assertEquals(3, calculator.countPunctuation("Labas, pasauli."));
    }

    @Test
    public void countPunctuation_noPunctuation_returnsZero() {
        assertEquals(0, calculator.countPunctuation("Labas"));
    }

    @Test
    public void countNumbers_twoNumberGroups_returnsTwo() {
        assertEquals(2, calculator.countNumbers("Man 12 metu ir 345 dienos"));
    }

    @Test
    public void countNumbers_noNumbers_returnsZero() {
        assertEquals(0, calculator.countNumbers("Be skaiciu"));
    }
}
