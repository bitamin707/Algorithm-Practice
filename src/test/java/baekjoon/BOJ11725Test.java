package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11725Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                7
                1 6
                6 3
                3 5
                4 1
                2 4
                4 7
                """;
        String expected = """
                4
                6
                1
                3
                1
                4
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                12
                1 2
                1 3
                2 4
                3 5
                3 6
                4 7
                4 8
                5 9
                5 10
                6 11
                6 12
                """;
        String expected = """
                1
                1
                2
                3
                3
                4
                4
                5
                5
                6
                6
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase3_minimumTree() throws IOException {
        String input = """
                2
                1 2
                """;
        String expected = """
                1
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase4_linearTree() throws IOException {
        String input = """
                5
                1 2
                2 3
                3 4
                4 5
                """;
        String expected = """
                1
                2
                3
                4
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase5_starTree() throws IOException {
        String input = """
                5
                1 2
                1 3
                1 4
                1 5
                """;
        String expected = """
                1
                1
                1
                1
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase6_unorderedEdges() throws IOException {
        String input = """
                6
                4 3
                1 2
                5 4
                3 2
                6 5
                """;
        String expected = """
                1
                2
                3
                4
                5
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase7_leftSkewedTree() throws IOException {
        String input = """
                4
                1 2
                2 3
                3 4
                """;
        String expected = """
                1
                2
                3
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase8_balancedTree() throws IOException {
        String input = """
                7
                1 2
                1 3
                2 4
                2 5
                3 6
                3 7
                """;
        String expected = """
                1
                1
                2
                2
                3
                3
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase9_complexTree() throws IOException {
        String input = """
                10
                1 2
                2 3
                3 4
                1 5
                5 6
                6 7
                1 8
                8 9
                9 10
                """;
        String expected = """
                1
                2
                3
                1
                5
                6
                1
                8
                9
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }

    @Test
    void testCase10_reverseOrderEdges() throws IOException {
        String input = """
                5
                5 4
                4 3
                3 2
                2 1
                """;
        String expected = """
                1
                2
                3
                4
                """;
        assertEquals(expected, BOJ_11725.solve(input));
    }
}