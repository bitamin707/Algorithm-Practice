package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1932Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                5
                7
                3 8
                8 1 0
                2 7 4 4
                4 5 2 6 5
                """;
        String expected = "30";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase2_singleNode() throws IOException {
        String input = """
                1
                10
                """;
        String expected = "10";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase3_twoLevels() throws IOException {
        String input = """
                2
                5
                1 3
                """;
        String expected = "8";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase4_allZeros() throws IOException {
        String input = """
                3
                0
                0 0
                0 0 0
                """;
        String expected = "0";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase5_leftPath() throws IOException {
        String input = """
                4
                1
                10 1
                1 1 1
                1 1 1 1
                """;
        String expected = "13";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase6_rightPath() throws IOException {
        String input = """
                4
                1
                1 10
                1 1 1
                1 1 1 1
                """;
        String expected = "13";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase7_maxValues() throws IOException {
        String input = """
                3
                9999
                9999 9999
                9999 9999 9999
                """;
        String expected = "29997";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase8_greedyFails() throws IOException {
        String input = """
                4
                1
                2 3
                1 1 1
                100 1 1 1
                """;
        String expected = "104";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase9_increasingValues() throws IOException {
        String input = """
                3
                1
                2 3
                4 5 6
                """;
        String expected = "10";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }

    @Test
    void testCase10_zigzag() throws IOException {
        String input = """
                5
                5
                9 1
                1 9 1
                9 1 9 1
                1 9 1 9 1
                """;
        String expected = "41";
        assertEquals(expected, BOJ_1932.solve(input).strip());
    }
}