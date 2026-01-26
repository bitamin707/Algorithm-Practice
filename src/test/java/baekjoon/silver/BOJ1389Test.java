package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1389Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                5 5
                1 3
                1 4
                2 3
                3 4
                4 5
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase2_simpleCase() throws IOException {
        String input = """
                4 4
                1 2
                2 3
                3 4
                1 4
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase3_linearGraph() throws IOException {
        String input = """
                4 3
                1 2
                2 3
                3 4
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase4_starGraph() throws IOException {
        String input = """
                5 4
                1 2
                1 3
                1 4
                1 5
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase5_smallGraph() throws IOException {
        String input = """
                3 2
                1 2
                2 3
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase6_completeGraph() throws IOException {
        String input = """
                4 6
                1 2
                1 3
                1 4
                2 3
                2 4
                3 4
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase7_twoConnectedComponents() throws IOException {
        String input = """
                6 4
                1 2
                2 3
                4 5
                5 6
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }

    @Test
    void testCase8_minNumberPreference() throws IOException {
        String input = """
                3 3
                1 2
                2 3
                1 3
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1389.solve(input).strip());
    }
}