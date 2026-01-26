package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2630Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                8
                1 1 0 0 0 0 1 1
                1 1 0 0 0 0 1 1
                0 0 0 0 1 1 0 0
                0 0 0 0 1 1 0 0
                1 0 0 0 1 1 1 1
                0 1 0 0 1 1 1 1
                0 0 1 1 1 1 1 1
                0 0 1 1 1 1 1 1
                """;
        String expected = """
                9
                7
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }

    @Test
    void testCase2_allWhite() throws IOException {
        String input = """
                2
                0 0
                0 0
                """;
        String expected = """
                1
                0
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }

    @Test
    void testCase3_allBlue() throws IOException {
        String input = """
                4
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 1 1
                """;
        String expected = """
                0
                1
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }

    @Test
    void testCase4_mixed2x2() throws IOException {
        String input = """
                2
                0 1
                1 0
                """;
        String expected = """
                2
                2
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }

    @Test
    void testCase5_mixed4x4() throws IOException {
        String input = """
                4
                0 0 1 1
                0 0 1 1
                1 1 0 0
                1 1 0 0
                """;
        String expected = """
                2
                2
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }

    @Test
    void testCase6_singleCell() throws IOException {
        String input = """
                1
                1
                """;
        String expected = """
                0
                1
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }

    @Test
    void testCase7_complexDivision() throws IOException {
        String input = """
                4
                1 1 0 1
                1 1 0 1
                0 0 1 1
                0 0 1 1
                """;
        String expected = """
                3
                4
                """.strip();
        assertEquals(expected, BOJ_2630.solve(input).strip());
    }
}