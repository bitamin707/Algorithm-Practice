package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ34927Test {
    @Test
    void testCase1_example1() throws IOException {
        String input = """
                3
                10 5 6
                """;
        String expected = "2";
        assertEquals(expected, BOJ_34927.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                10
                10 1 9 2 8 3 7 4 6 5
                """;
        String expected = "4";
        assertEquals(expected, BOJ_34927.solve(input).strip());
    }

    @Test
    void testCase3_allSameWeights() throws IOException {
        String input = """
                5
                1 1 1 1 1
                """;
        String expected = "2";
        assertEquals(expected, BOJ_34927.solve(input).strip());
    }

    @Test
    void testCase4_powerOfTwo() throws IOException {
        String input = """
                5
                1 2 4 8 16
                """;
        String expected = "5";
        assertEquals(expected, BOJ_34927.solve(input).strip());
    }

    @Test
    void testCase5_minimumN() throws IOException {
        String input = """
                2
                1 100
                """;
        String expected = "2";
        assertEquals(expected, BOJ_34927.solve(input).strip());
    }

    @Test
    void testCase6_heavyFirst() throws IOException {
        String input = """
                4
                100 1 1 1
                """;
        String expected = "3";
        assertEquals(expected, BOJ_34927.solve(input).strip());
    }
}