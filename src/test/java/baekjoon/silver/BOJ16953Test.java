package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ16953Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                2 162
                """;
        String expected = "5";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase2_example2_impossible() throws IOException {
        String input = """
                4 42
                """;
        String expected = "-1";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase3_example3() throws IOException {
        String input = """
                100 40021
                """;
        String expected = "5";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase4_onlyMultiply() throws IOException {
        String input = """
                1 8
                """;
        String expected = "4";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase5_onlyAppendOne() throws IOException {
        String input = """
                1 1111
                """;
        String expected = "4";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase6_mixedOperations() throws IOException {
        String input = """
                3 96
                """;
        String expected = "6";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase7_impossibleEvenToOdd() throws IOException {
        String input = """
                2 5
                """;
        String expected = "-1";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase8_directAppend() throws IOException {
        String input = """
                5 51
                """;
        String expected = "2";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase9_impossibleLargeNumber() throws IOException {
        String input = """
                1 1000000000
                """;
        String expected = "-1";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }

    @Test
    void testCase10_sameDigit() throws IOException {
        String input = """
                7 71
                """;
        String expected = "2";
        assertEquals(expected, BOJ_16953.solve(input).strip());
    }
}