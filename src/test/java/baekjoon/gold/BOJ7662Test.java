package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ7662Test {

    @Test
    void testCase1_basicExample1() throws IOException {
        String input = """
                2
                7
                I 16
                I -5643
                D -1
                D 1
                D 1
                I 123
                D -1
                9
                I -45
                I 653
                D 1
                I -642
                I 45
                I 97
                D 1
                D -1
                I 333
                """;
        String expected = "EMPTY\n" +
                "333 -45";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase2_basicExample2() throws IOException {
        String input = """
                1
                10
                I 7
                I 5
                I -5
                I -3
                I 7
                D -1
                D 1
                D 1
                I 5
                D -1
                """;
        String expected = "5 5";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase3_multipleTestCases() throws IOException {
        String input = """
                2
                7
                I 16
                I -5643
                D -1
                D 1
                D 1
                I 123
                D -1
                10
                I 7
                I 5
                I -5
                I -3
                I 7
                D -1
                D 1
                D 1
                I 5
                D -1
                """;
        String expected = """
                EMPTY
                5 5""";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase4_singleElement() throws IOException {
        String input = """
                1
                1
                I 42
                """;
        String expected = "42 42";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase5_onlyInsertions() throws IOException {
        String input = """
                1
                5
                I 1
                I 2
                I 3
                I 4
                I 5
                """;
        String expected = "5 1";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase6_emptyAfterDeletions() throws IOException {
        String input = """
                1
                4
                I 10
                I 20
                D 1
                D -1
                """;
        String expected = "EMPTY";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase7_duplicateValues() throws IOException {
        String input = """
                1
                6
                I 1
                I 1
                I 2
                I 2
                D 1
                D -1
                """;
        String expected = "2 1";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase8_deleteFromEmpty() throws IOException {
        String input = """
                1
                3
                D 1
                D -1
                I 100
                """;
        String expected = "100 100";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase9_negativeNumbers() throws IOException {
        String input = """
                1
                4
                I -10
                I -5
                I -1
                D -1
                """;
        String expected = "-1 -5";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase10_mixedOperations() throws IOException {
        String input = """
                1
                8
                I 3
                I 1
                I 4
                D 1
                I 2
                D -1
                I 5
                D 1
                """;
        String expected = "3 2";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase11_largeNumbers() throws IOException {
        String input = """
                1
                4
                I 1000000
                I -1000000
                I 0
                D -1
                """;
        String expected = "1000000 0";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }

    @Test
    void testCase12_alternatingOperations() throws IOException {
        String input = """
                1
                6
                I 10
                D 1
                I 20
                D -1
                I 30
                I 40
                """;
        String expected = "40 30";
        assertEquals(expected, BOJ_7662.solve(input).strip());
    }
}