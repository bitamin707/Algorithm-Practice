package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11660Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                4 3
                1 2 3 4
                2 3 4 5
                3 4 5 6
                4 5 6 7
                2 2 3 4
                3 4 3 4
                1 1 4 4
                """;
        String expected = """
                27
                6
                64
                """;
        assertEquals(expected.strip(), BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase1_example2() throws IOException {
        String input = """
                2 4
                1 2
                3 4
                1 1 1 1
                1 2 1 2
                2 1 2 1
                2 2 2 2
                """;
        String expected = """
                1
                2
                3
                4
                """;
        assertEquals(expected.strip(), BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase2_singleCell() throws IOException {
        String input = """
                1 1
                100
                1 1 1 1
                """;
        String expected = "100";
        assertEquals(expected, BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase3_fullRange() throws IOException {
        String input = """
                3 1
                1 2 3
                4 5 6
                7 8 9
                1 1 3 3
                """;
        String expected = "45";
        assertEquals(expected, BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase4_singleRow() throws IOException {
        String input = """
                3 1
                1 2 3
                4 5 6
                7 8 9
                2 1 2 3
                """;
        String expected = "15";
        assertEquals(expected, BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase5_singleColumn() throws IOException {
        String input = """
                3 1
                1 2 3
                4 5 6
                7 8 9
                1 2 3 2
                """;
        String expected = "15";
        assertEquals(expected, BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase6_multipleQueries() throws IOException {
        String input = """
                2 3
                1 2
                3 4
                1 1 1 1
                2 2 2 2
                1 1 2 2
                """;
        String expected = """
                1
                4
                10
                """;
        assertEquals(expected.strip(), BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase7_largeValues() throws IOException {
        String input = """
                2 2
                1000 1000
                1000 1000
                1 1 2 2
                1 1 1 2
                """;
        String expected = """
                4000
                2000
                """;
        assertEquals(expected.strip(), BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase8_partialRanges() throws IOException {
        String input = """
                4 4
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 2 2
                2 2 3 3
                1 1 4 4
                3 3 4 4
                """;
        String expected = """
                4
                4
                16
                4
                """;
        assertEquals(expected.strip(), BOJ_11660.solve(input).strip());
    }

    @Test
    void testCase9_cornerCases() throws IOException {
        String input = """
                5 3
                1 0 0 0 1
                0 1 0 1 0
                0 0 1 0 0
                0 1 0 1 0
                1 0 0 0 1
                1 1 5 5
                2 2 4 4
                3 3 3 3
                """;
        String expected = """
                9
                5
                1
                """;
        assertEquals(expected.strip(), BOJ_11660.solve(input).strip());
    }
}