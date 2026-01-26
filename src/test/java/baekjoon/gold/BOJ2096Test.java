package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2096Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3
                1 2 3
                4 5 6
                4 9 0
                """;
        String expected = "18 6";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase1_example2() throws IOException {
        String input = """
                3
                0 0 0
                0 0 0
                0 0 0
                """;
        String expected = "0 0";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase2_singleRow() throws IOException {
        String input = """
                1
                5 3 7
                """;
        String expected = "7 3";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase3_twoRows() throws IOException {
        String input = """
                2
                1 2 3
                4 5 6
                """;
        String expected = "9 5";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase4_allSameValues() throws IOException {
        String input = """
                4
                5 5 5
                5 5 5
                5 5 5
                5 5 5
                """;
        String expected = "20 20";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase5_zigzagPattern() throws IOException {
        String input = """
                3
                9 0 0
                0 9 0
                0 0 9
                """;
        String expected = "27 0";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase6_minMaxAtEdges() throws IOException {
        String input = """
                3
                9 5 1
                5 5 5
                1 5 9
                """;
        String expected = "23 7";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase7_withZeros() throws IOException {
        String input = """
                4
                1 0 1
                0 1 0
                1 0 1
                0 1 0
                """;
        String expected = "4 0";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase8_increasingValues() throws IOException {
        String input = """
                5
                1 2 3
                2 3 4
                3 4 5
                4 5 6
                5 6 7
                """;
        String expected = "25 15";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase9_leftPathOnly() throws IOException {
        String input = """
                3
                9 0 0
                9 0 0
                9 0 0
                """;
        String expected = "27 0";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }

    @Test
    void testCase10_complexPath() throws IOException {
        String input = """
                5
                1 5 9
                2 4 8
                3 3 7
                4 2 6
                5 1 5
                """;
        String expected = "35 9";
        assertEquals(expected, BOJ_2096.solve(input).strip());
    }
}