package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest implements Notation {

    @Test
    void testCorrect() throws Exception {
        ReversePolishNotation notation = new ReversePolishNotation();
        Double res = notation.getResult("825*+132*+4-/");
        assertEquals(6, res);
    }

    @Test
    void testMuchNumber() throws Exception {
        ReversePolishNotation notation = new ReversePolishNotation();
        assertThrows(Exception.class, () -> {
            Double res = notation.getResult("532++73");
        });
    }

    @Test
    void testDivisionByZero() throws Exception {
        ReversePolishNotation notation = new ReversePolishNotation();
        assertThrows(Exception.class, () -> {
            Double res = notation.getResult("825*+132*+7-/");
        });
    }

    @Test
    void testEmptyStack() throws Exception {
        ReversePolishNotation notation = new ReversePolishNotation();
        assertThrows(Exception.class, () -> {
            Double res = notation.getResult("532++73++++");
        });
    }
}