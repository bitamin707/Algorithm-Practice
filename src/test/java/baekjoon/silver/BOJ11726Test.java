package baekjoon.silver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class BOJ11726Test {

    @Test
    void testCase1_problemExample1() throws IOException {
        String input = "2";
        String expected = "2".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase2_problemExample2() throws IOException {
        String input = "9";
        String expected = "55".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase3_smallValues() throws IOException {
        String input = "1";
        String expected = "1".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase4_baseCase() throws IOException {
        String input = "3";
        String expected = "3".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase5_mediumValues() throws IOException {
        String input = "4";
        String expected = "5".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase6_fibonacci() throws IOException {
        String input = "8";
        String expected = "34".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase7_largeValue() throws IOException {
        String input = "10";
        String expected = "89".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase8_modular() throws IOException {
        String input = "20";
        String expected = "939".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }

    @Test
    void testCase9_maxValue() throws IOException {
        String input = "1000";
        String expected = "1115".strip();
        assertEquals(expected, BOJ_11726.solve(input).strip());
    }
}