package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ7562Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3
                8
                0 0
                7 0
                100
                0 0
                30 50
                10
                1 1
                1 1
                """;
        String expected = "5\n28\n0";
        assertEquals(expected, BOJ_7562.solve(input).strip());
    }

    @Test
    void testCase2_minimum_board() throws IOException {
        String input = """
                1
                4
                0 0
                3 3
                """;
        String expected = "4";
        assertEquals(expected, BOJ_7562.solve(input).strip());
    }

    @Test
    void testCase3_adjacent() throws IOException {
        String input = """
                1
                8
                0 0
                1 2
                """;
        String expected = "1";
        assertEquals(expected, BOJ_7562.solve(input).strip());
    }
}