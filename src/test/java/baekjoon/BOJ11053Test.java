package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11053Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                6
                10 20 10 30 20 50
                """;
        String expected = "4";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase2_singleElement() throws IOException {
        String input = """
                1
                10
                """;
        String expected = "1";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase3_strictlyIncreasing() throws IOException {
        String input = """
                5
                1 2 3 4 5
                """;
        String expected = "5";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase4_strictlyDecreasing() throws IOException {
        String input = """
                5
                5 4 3 2 1
                """;
        String expected = "1";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase5_twoElements() throws IOException {
        String input = """
                2
                1 2
                """;
        String expected = "2";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase6_twoElementsDecreasing() throws IOException {
        String input = """
                2
                2 1
                """;
        String expected = "1";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase7_allSameElements() throws IOException {
        String input = """
                4
                3 3 3 3
                """;
        String expected = "1";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase8_complexCase() throws IOException {
        String input = """
                5
                1 3 2 4 5
                """;
        String expected = "4";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase9_zigzagPattern() throws IOException {
        String input = """
                6
                1 3 2 4 3 5
                """;
        String expected = "4";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase10_largerCase() throws IOException {
        String input = """
                8
                1 5 2 3 7 4 6 8
                """;
        String expected = "5";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase11_maxValues() throws IOException {
        String input = """
                4
                1000 999 998 997
                """;
        String expected = "1";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase12_minValues() throws IOException {
        String input = """
                4
                1 2 3 4
                """;
        String expected = "4";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase13_duplicatesWithIncrease() throws IOException {
        String input = """
                7
                1 2 2 3 3 4 4
                """;
        String expected = "4";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }

    @Test
    void testCase14_longSequence() throws IOException {
        String input = """
                10
                1 10 2 9 3 8 4 7 5 6
                """;
        String expected = "5";
        assertEquals(expected, BOJ_11053.solve(input).strip());
    }
}