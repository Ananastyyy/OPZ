package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @Test
    void testCorrect() throws Exception {
        Double res = ReversePolishNotation.getResult("825*+132*+4-/");
        assertEquals(6, res);
    }

    @Test
    void testMuchNumber() throws Exception {
        assertThrows(Exception.class, () -> {
            Double res = ReversePolishNotation.getResult("532++73");
        });
    }

    @Test
    void testDivisionByZero() throws Exception {
        assertThrows(Exception.class, () -> {
            Double res = ReversePolishNotation.getResult("825*+132*+7-/");
        });
    }

    @Test
    void testEmptyStack() throws Exception {
        assertThrows(Exception.class, () -> {
            Double res = ReversePolishNotation.getResult("532++73++++");
        });
    }
}