package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11403Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3
                0 1 0
                0 0 1
                1 0 0
                """;
        String expected = """
                1 1 1
                1 1 1
                1 1 1""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase2_noConnections() throws IOException {
        String input = """
                3
                0 0 0
                0 0 0
                0 0 0
                """;
        String expected = """
                0 0 0
                0 0 0
                0 0 0""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase3_directOnly() throws IOException {
        String input = """
                4
                0 1 1 1
                0 0 0 0
                0 0 0 0
                0 0 0 0
                """;
        String expected = """
                0 1 1 1
                0 0 0 0
                0 0 0 0
                0 0 0 0""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase4_fullCycle() throws IOException {
        String input = """
                4
                0 1 0 0
                0 0 1 0
                0 0 0 1
                1 0 0 0
                """;
        String expected = """
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 1 1""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase5_singleNode() throws IOException {
        String input = """
                1
                0
                """;
        String expected = "0";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase6_twoNodes() throws IOException {
        String input = """
                2
                0 1
                0 0
                """;
        String expected = """
                0 1
                0 0""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase7_stronglyConnected() throws IOException {
        String input = """
                5
                0 1 0 1 0
                0 0 1 0 0
                0 0 0 0 1
                0 0 1 0 0
                1 0 0 0 0
                """;
        String expected = """
                1 1 1 1 1
                1 1 1 1 1
                1 1 1 1 1
                1 1 1 1 1
                1 1 1 1 1""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase8_disconnectedComponents() throws IOException {
        String input = """
                4
                0 1 0 0
                0 0 0 0
                0 0 0 1
                0 0 0 0
                """;
        String expected = """
                0 1 0 0
                0 0 0 0
                0 0 0 1
                0 0 0 0""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase9_partialCycle() throws IOException {
        String input = """
                4
                0 1 0 0
                0 0 1 0
                1 0 0 1
                0 0 0 0
                """;
        String expected = """
                1 1 1 1
                1 1 1 1
                1 1 1 1
                0 0 0 0""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }

    @Test
    void testCase10_starGraph() throws IOException {
        String input = """
                5
                0 1 1 1 1
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
                """;
        String expected = """
                0 1 1 1 1
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0""";
        assertEquals(expected, BOJ_11403.solve(input).strip());
    }
}