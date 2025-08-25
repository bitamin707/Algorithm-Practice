package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11286Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                18
                1
                -1
                0
                0
                0
                1
                1
                -1
                -1
                2
                -2
                0
                0
                0
                0
                0
                0
                0
                """;
        String expected = """
                -1
                1
                0
                -1
                -1
                1
                1
                -2
                2
                0
                """.strip();
        assertEquals(expected, BOJ_11286.solve(input).strip());
    }

    @Test
    void testCase2_emptyHeap() throws IOException {
        String input = """
                3
                0
                1
                0
                """;
        String expected = """
                0
                1
                """.strip();
        assertEquals(expected, BOJ_11286.solve(input).strip());
    }

    @Test
    void testCase3_sameAbsoluteValue() throws IOException {
        String input = """
                7
                3
                -3
                0
                0
                -2
                2
                0
                """;
        String expected = """
                -3
                3
                -2
                """.strip();
        assertEquals(expected, BOJ_11286.solve(input).strip());
    }

    @Test
    void testCase4_singleElement() throws IOException {
        String input = """
                2
                5
                0
                """;
        String expected = """
                5
                """.strip();
        assertEquals(expected, BOJ_11286.solve(input).strip());
    }

    @Test
    void testCase5_largeValues() throws IOException {
        String input = """
                6
                1000000
                -1000000
                0
                999999
                -999999
                0
                """;
        String expected = """
                -1000000
                -999999
                """.strip();
        assertEquals(expected, BOJ_11286.solve(input).strip());
    }
}