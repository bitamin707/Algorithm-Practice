package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ5525Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                1
                13
                OOIOIOIOIIOII
                """;
        String expected = "4";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase2_simple() throws IOException {
        String input = """
                1
                5
                IOIOI
                """;
        String expected = "2";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase3_noMatch() throws IOException {
        String input = """
                2
                5
                OOOOO
                """;
        String expected = "0";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase4_exactMatch() throws IOException {
        String input = """
                2
                5
                IOIOI
                """;
        String expected = "1";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase5_longPattern() throws IOException {
        String input = """
                3
                7
                IOIOIOI
                """;
        String expected = "1";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase6_multipleMatches() throws IOException {
        String input = """
                1
                11
                IOIOIOIOIOI
                """;
        String expected = "5";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase7_overlapping() throws IOException {
        String input = """
                2
                9
                IOIOIOIOI
                """;
        String expected = "3";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase8_complexPattern() throws IOException {
        String input = """
                1
                15
                OIOIOIOIIOOIOII
                """;
        String expected = "4";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase9_minimalCase() throws IOException {
        String input = """
                1
                3
                IOI
                """;
        String expected = "1";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }

    @Test
    void testCase10_interruptedPattern() throws IOException {
        String input = """
                2
                9
                IOIOOOIOI
                """;
        String expected = "0";
        assertEquals(expected, BOJ_5525.solve(input).strip());
    }
}