package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2108Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                5
                1
                3
                8
                -2
                2
                """;
        String expected = "2\n2\n1\n10";
        assertEquals(expected, BOJ_2108.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                1
                4000
                """;
        String expected = "4000\n4000\n4000\n0";
        assertEquals(expected, BOJ_2108.solve(input).strip());
    }

    @Test
    void testCase3_example3() throws IOException {
        String input = """
                5
                -1
                -2
                -3
                -1
                -2
                """;
        String expected = "-2\n-2\n-1\n2";
        assertEquals(expected, BOJ_2108.solve(input).strip());
    }

    @Test
    void testCase4_modeSpecial() throws IOException {
        String input = """
                3
                0
                0
                -1
                """;
        String expected = "0\n0\n0\n1";
        assertEquals(expected, BOJ_2108.solve(input).strip());
    }

    @Test
    void testCase5_edgeCase() throws IOException {
        String input = """
                5
                -4000
                4000
                -4000
                4000
                0
                """;
        String expected = "0\n0\n4000\n8000";
        assertEquals(expected, BOJ_2108.solve(input).strip());
    }
}