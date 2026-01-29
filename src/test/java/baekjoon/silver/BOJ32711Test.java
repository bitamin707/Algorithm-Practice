package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ32711Test {
    @Test
    void testCase1_example() throws IOException {
        String input = """
                5
                1 2 1 2 1
                """;
        String expected = "1";
        assertEquals(expected.strip(), BOJ_32711.solve(input).strip());
    }

    @Test
    void testCase2_example() throws IOException {
        String input = """
                6
                1 2 4 4 2 1
                """;
        String expected = "0";
        assertEquals(expected.strip(), BOJ_32711.solve(input).strip());
    }

    @Test
    void testCase3_example() throws IOException {
        String input = """
                7
                1 2 4 3 2 2 2
                """;
        String expected = "1";
        assertEquals(expected.strip(), BOJ_32711.solve(input).strip());
    }

    @Test
    void testCase4_singleOdd() throws IOException {
        String input = """
                1
                7
                """;
        String expected = "1";
        assertEquals(expected.strip(), BOJ_32711.solve(input).strip());
    }

    @Test
    void testCase5_edgeCase() throws IOException {
        String input = """
                3
                2 1 2
                """;
        String expected = "1";
        assertEquals(expected.strip(), BOJ_32711.solve(input).strip());
    }
}