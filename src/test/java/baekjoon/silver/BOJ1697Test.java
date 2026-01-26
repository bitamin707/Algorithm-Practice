package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1697Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                5 17
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase2_samePosition() throws IOException {
        String input = """
                5 5
                """;
        String expected = "0";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase3_backwardMove() throws IOException {
        String input = """
                10 3
                """;
        String expected = "7";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase4_teleportOptimal() throws IOException {
        String input = """
                1 8
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase5_simpleForward() throws IOException {
        String input = """
                3 6
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase6_edgeCase() throws IOException {
        String input = """
                0 1
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase7_largeNumbers() throws IOException {
        String input = """
                100000 99999
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }

    @Test
    void testCase8_teleportChain() throws IOException {
        String input = """
                2 16
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1697.solve(input).strip());
    }
}