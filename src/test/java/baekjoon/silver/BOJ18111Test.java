package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ18111Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                3 4 99
                0 0 0 0
                0 0 0 0
                0 0 0 1
                """;
        String expected = "2 0";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                3 4 1
                0 0 0 0
                0 0 0 0
                0 0 0 1
                """;
        String expected = "1 1";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase3_example3() throws IOException {
        String input = """
                3 4 0
                0 0 0 0
                0 0 0 0
                0 0 0 1
                """;
        String expected = "2 0";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase4_allSameHeight() throws IOException {
        String input = """
                2 2 10
                5 5
                5 5
                """;
        String expected = "0 5";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase5_complexCase() throws IOException {
        String input = """
                3 3 4
                0 64 64
                64 64 64
                64 64 63
                """;
        String expected = "1 64";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase6_preferHigher() throws IOException {
        String input = """
                2 2 2
                2 2
                2 1
                """;
        String expected = "1 2";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase7_singleCell() throws IOException {
        String input = """
                1 1 5
                3
                """;
        String expected = "0 3";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }

    @Test
    void testCase8_removeOnly() throws IOException {
        String input = """
                2 2 0
                2 2
                2 2
                """;
        String expected = "16 0";
        assertEquals(expected, BOJ_18111.solve(input).strip());
    }
}