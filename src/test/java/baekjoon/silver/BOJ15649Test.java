package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ15649Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                3 1
                """;
        String expected = """
                1
                2
                3
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                4 2
                """;
        String expected = """
                1 2
                1 3
                1 4
                2 1
                2 3
                2 4
                3 1
                3 2
                3 4
                4 1
                4 2
                4 3
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase3_example3() throws IOException {
        String input = """
                4 4
                """;
        String expected = """
                1 2 3 4
                1 2 4 3
                1 3 2 4
                1 3 4 2
                1 4 2 3
                1 4 3 2
                2 1 3 4
                2 1 4 3
                2 3 1 4
                2 3 4 1
                2 4 1 3
                2 4 3 1
                3 1 2 4
                3 1 4 2
                3 2 1 4
                3 2 4 1
                3 4 1 2
                3 4 2 1
                4 1 2 3
                4 1 3 2
                4 2 1 3
                4 2 3 1
                4 3 1 2
                4 3 2 1
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase4_minimumCase() throws IOException {
        String input = """
                1 1
                """;
        String expected = """
                1
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase5_smallCase() throws IOException {
        String input = """
                2 1
                """;
        String expected = """
                1
                2
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase6_smallPermutation() throws IOException {
        String input = """
                2 2
                """;
        String expected = """
                1 2
                2 1
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase7_mediumCase() throws IOException {
        String input = """
                3 2
                """;
        String expected = """
                1 2
                1 3
                2 1
                2 3
                3 1
                3 2
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase8_fullPermutation() throws IOException {
        String input = """
                3 3
                """;
        String expected = """
                1 2 3
                1 3 2
                2 1 3
                2 3 1
                3 1 2
                3 2 1
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase9_maxSingleChoice() throws IOException {
        String input = """
                8 1
                """;
        String expected = """
                1
                2
                3
                4
                5
                6
                7
                8
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }

    @Test
    void testCase10_mediumPermutation() throws IOException {
        String input = """
                5 3
                """;
        String expected = """
                1 2 3
                1 2 4
                1 2 5
                1 3 2
                1 3 4
                1 3 5
                1 4 2
                1 4 3
                1 4 5
                1 5 2
                1 5 3
                1 5 4
                2 1 3
                2 1 4
                2 1 5
                2 3 1
                2 3 4
                2 3 5
                2 4 1
                2 4 3
                2 4 5
                2 5 1
                2 5 3
                2 5 4
                3 1 2
                3 1 4
                3 1 5
                3 2 1
                3 2 4
                3 2 5
                3 4 1
                3 4 2
                3 4 5
                3 5 1
                3 5 2
                3 5 4
                4 1 2
                4 1 3
                4 1 5
                4 2 1
                4 2 3
                4 2 5
                4 3 1
                4 3 2
                4 3 5
                4 5 1
                4 5 2
                4 5 3
                5 1 2
                5 1 3
                5 1 4
                5 2 1
                5 2 3
                5 2 4
                5 3 1
                5 3 2
                5 3 4
                5 4 1
                5 4 2
                5 4 3
                """;
        assertEquals(expected, BOJ_15649.solve(input).strip());
    }
}