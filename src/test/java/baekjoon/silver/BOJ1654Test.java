package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1654Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                4 11
                802
                743
                457
                539
                """;
        String expected = "200";
        assertEquals(expected, BOJ_1654.solve(input).strip());
    }

    @Test
    void testCase2_minCase() throws IOException {
        String input = """
                1 1
                10
                """;
        String expected = "10";
        assertEquals(expected, BOJ_1654.solve(input).strip());
    }

    @Test
    void testCase3_sameLength() throws IOException {
        String input = """
                3 3
                100
                100
                100
                """;
        String expected = "100";
        assertEquals(expected, BOJ_1654.solve(input).strip());
    }

    @Test
    void testCase4_edgeCase() throws IOException {
        String input = """
                2 5
                100
                200
                """;
        String expected = "50";
        assertEquals(expected, BOJ_1654.solve(input).strip());
    }

    @Test
    void testCase5_maxCase() throws IOException {
        String input = """
                1 1000000
                2147483647
                """;
        String expected = "2147";
        assertEquals(expected, BOJ_1654.solve(input).strip());
    }
}