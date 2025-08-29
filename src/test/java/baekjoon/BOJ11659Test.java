package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11659Test {

    @Test
    void testCase1_problemExample() throws IOException {
        String input = """
                5 3
                5 4 3 2 1
                1 3
                2 4
                5 5
                """;
        String expected = """
                12
                9
                1
                """.strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }

    @Test
    void testCase2_singleElement() throws IOException {
        String input = """
                1 2
                10
                1 1
                1 1
                """;
        String expected = """
                10
                10
                """.strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }

    @Test
    void testCase3_wholeArray() throws IOException {
        String input = """
                5 1
                1 2 3 4 5
                1 5
                """;
        String expected = "15".strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }

    @Test
    void testCase4_multipleQueries() throws IOException {
        String input = """
                5 4
                1 2 3 4 5
                1 1
                1 5
                2 4
                3 3
                """;
        String expected = """
                1
                15
                9
                3
                """.strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }

    @Test
    void testCase5_consecutiveElements() throws IOException {
        String input = """
                4 3
                10 20 30 40
                1 2
                2 3
                3 4
                """;
        String expected = """
                30
                50
                70
                """.strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }

    @Test
    void testCase6_overlappingRanges() throws IOException {
        String input = """
                6 5
                1 1 1 1 1 1
                1 3
                2 4
                3 5
                4 6
                1 6
                """;
        String expected = """
                3
                3
                3
                3
                6
                """.strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }

    @Test
    void testCase7_largeNumbers() throws IOException {
        String input = """
                3 2
                1000 1000 1000
                1 2
                2 3
                """;
        String expected = """
                2000
                2000
                """.strip();
        assertEquals(expected, BOJ_11659.solve(input).strip());
    }
}