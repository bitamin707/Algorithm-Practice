package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ9465Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                2
                5
                50 10 100 20 40
                30 50 70 10 60
                7
                10 30 10 50 100 20 40
                20 40 30 50 60 20 80
                """;
        String expected = """
                260
                290
                """;
        assertEquals(expected.strip(), BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase2_minN() throws IOException {
        String input = """
                1
                1
                100
                50
                """;
        String expected = "100";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase3_twoColumns() throws IOException {
        String input = """
                1
                2
                50 100
                100 50
                """;
        String expected = "200";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase4_zigzagPattern() throws IOException {
        String input = """
                1
                4
                10 20 30 40
                40 30 20 10
                """;
        String expected = "120";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase5_allSameValues() throws IOException {
        String input = """
                1
                5
                10 10 10 10 10
                10 10 10 10 10
                """;
        String expected = "50";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase6_increasingValues() throws IOException {
        String input = """
                1
                6
                1 2 3 4 5 6
                6 5 4 3 2 1
                """;
        String expected = "24";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase7_withZeros() throws IOException {
        String input = """
                1
                5
                100 0 100 0 100
                0 100 0 100 0
                """;
        String expected = "500";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }

    @Test
    void testCase8_largeGap() throws IOException {
        String input = """
                1
                3
                100 1 100
                1 100 1
                """;
        String expected = "300";
        assertEquals(expected, BOJ_9465.solve(input).strip());
    }
}