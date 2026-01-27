package baekjoon.bronze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ15727Test {
    @Test
    void testCase1_example() throws IOException {
        String input = "12";
        String expected = "3";
        assertEquals(expected, BOJ_15727.solve(input).strip());
    }

    @Test
    void testCase2_edgeMin() throws IOException {
        String input = "1";
        String expected = "1";
        assertEquals(expected, BOJ_15727.solve(input).strip());
    }

    @Test
    void testCase3_exactDivide() throws IOException {
        String input = "20";
        String expected = "4";
        assertEquals(expected, BOJ_15727.solve(input).strip());
    }

    @Test
    void testCase4_edgeMax() throws IOException {
        String input = "1000000";
        String expected = "200000";
        assertEquals(expected, BOJ_15727.solve(input).strip());
    }

    @Test
    void testCase5_remainderExists() throws IOException {
        String input = "6";
        String expected = "2";
        assertEquals(expected, BOJ_15727.solve(input).strip());
    }
}