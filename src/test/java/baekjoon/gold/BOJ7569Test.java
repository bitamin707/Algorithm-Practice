package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ7569Test {

    @Test
    void testCase1_basicExample() throws IOException {
        String input = """
                5 3 1
                0 -1 0 0 0
                -1 -1 0 1 1
                0 0 0 1 1
                """;
        String expected = "-1";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase2_multipleLayersExample() throws IOException {
        String input = """
                5 3 2
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
                0 0 1 0 0
                0 0 0 0 0
                """;
        String expected = "4";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase3_alreadyAllRipe() throws IOException {
        String input = """
                2 2 2
                1 1
                1 1
                1 1
                1 1
                """;
        String expected = "0";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase4_singleLayer() throws IOException {
        String input = """
                3 3 1
                1 0 0
                0 0 0
                0 0 0
                """;
        String expected = "4";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase5_withEmptySpaces() throws IOException {
        String input = """
                3 3 1
                1 -1 0
                0 -1 0
                0 0 0
                """;
        String expected = "4";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase6_impossibleCase() throws IOException {
        String input = """
                3 3 1
                1 -1 0
                -1 -1 -1
                0 0 0
                """;
        String expected = "-1";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase7_multipleRipeTomatoes() throws IOException {
        String input = """
                4 3 2
                1 0 0 0
                0 0 0 0
                0 0 0 1
                0 0 0 0
                1 0 0 0
                0 0 0 0
                """;
        String expected = "3";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase8_verticalPropagation() throws IOException {
        String input = """
                2 2 3
                0 0
                0 0
                0 0
                0 0
                1 0
                0 0
                """;
        String expected = "3";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase9_smallBox() throws IOException {
        String input = """
                2 2 1
                0 1
                1 0
                """;
        String expected = "1";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase10_onlyEmptySpaces() throws IOException {
        String input = """
                2 2 1
                -1 -1
                -1 -1
                """;
        String expected = "0";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase11_mixedWithEmpty() throws IOException {
        String input = """
                3 2 2
                0 0 0
                1 -1 0
                0 0 0
                0 -1 0
                """;
        String expected = "3";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }

    @Test
    void testCase12_largerBox() throws IOException {
        String input = """
                4 4 1
                0 0 0 0
                0 1 1 0
                0 1 1 0
                0 0 0 0
                """;
        String expected = "2";
        assertEquals(expected, BOJ_7569.solve(input).strip());
    }
}