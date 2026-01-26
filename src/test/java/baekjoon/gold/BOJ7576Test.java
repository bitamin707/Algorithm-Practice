package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ7576Test {

    @Test
    void testCase1() throws IOException {
        String input = """
                6 4
                0 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 1
                """;
        String expected = "8";
        assertEquals(expected, BOJ_7576.solve(input).strip());
    }

    @Test
    void testCase2() throws IOException {
        String input = """
                6 4
                0 -1 0 0 0 0
                -1 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 1
                """;
        String expected = "-1";
        assertEquals(expected, BOJ_7576.solve(input).strip());
    }

    @Test
    void testCase3() throws IOException {
        String input = """
                6 4
                1 -1 0 0 0 0
                0 -1 0 0 0 0
                0 0 0 0 -1 0
                0 0 0 0 -1 1
                """;
        String expected = "6";
        assertEquals(expected, BOJ_7576.solve(input).strip());
    }

    @Test
    void testCase4() throws IOException {
        String input = """
                5 5
                -1 1 0 0 0
                0 -1 -1 -1 0
                0 -1 -1 -1 0
                0 -1 -1 -1 0
                0 0 0 0 0
                """;
        String expected = "14";
        assertEquals(expected, BOJ_7576.solve(input).strip());
    }

    @Test
    void testCase5() throws IOException {
        String input = """
                2 2
                1 -1
                -1 1
                """;
        String expected = "0";
        assertEquals(expected, BOJ_7576.solve(input).strip());
    }
}