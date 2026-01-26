package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11727Test {

    @Test
    void testCase1_baseCase1() throws IOException {
        String input = "2";
        String expected = "3".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase2_baseCase2() throws IOException {
        String input = "8";
        String expected = "171".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase3_smallValue() throws IOException {
        String input = "1";
        String expected = "1".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase4_earlyValues() throws IOException {
        String input = "3";
        String expected = "5".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase5_mediumValue() throws IOException {
        String input = "4";
        String expected = "11".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase6_sequence() throws IOException {
        String input = "5";
        String expected = "21".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase7_largerValue() throws IOException {
        String input = "6";
        String expected = "43".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase8_doubleDigit() throws IOException {
        String input = "10";
        String expected = "683".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase9_modular() throws IOException {
        String input = "12";
        String expected = "2731".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }

    @Test
    void testCase10_maxValue() throws IOException {
        String input = "1000";
        String expected = "7326".strip();
        assertEquals(expected, BOJ_11727.solve(input).strip());
    }
}