package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ14940Test {

    @Test
    void testCase1_basicExample() throws IOException {
        String input = """
                15 15
                2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
                1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
                1 1 1 1 1 1 1 1 1 1 0 1 0 0 1
                1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
                """;
        String expected = """
                0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
                1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
                2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
                3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
                4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
                5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
                6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
                7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
                8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
                9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
                10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
                11 12 13 14 15 16 17 18 19 20 0 0 0 0 25
                12 13 14 15 16 17 18 19 20 21 0 29 28 27 26
                13 14 15 16 17 18 19 20 21 22 0 30 0 0 27
                14 15 16 17 18 19 20 21 22 23 0 31 30 29 28""";
        assertEquals(expected, BOJ_14940.solve(input).strip());
    }

    @Test
    void testCase2_simpleGrid() throws IOException {
        String input = """
                3 3
                1 1 1
                1 2 1
                1 1 1
                """;
        String expected = """
                2 1 2
                1 0 1
                2 1 2""";
        assertEquals(expected, BOJ_14940.solve(input).strip());
    }

    @Test
    void testCase3_withObstacles() throws IOException {
        String input = """
                4 4
                1 0 1 1
                1 0 2 1
                1 0 1 1
                1 1 1 1
                """;
        String expected = """
                7 0 1 2
                6 0 0 1
                5 0 1 2
                4 3 2 3""";
        assertEquals(expected, BOJ_14940.solve(input).strip());
    }

    @Test
    void testCase4_unreachableArea() throws IOException {
        String input = """
                3 4
                1 0 0 1
                2 0 0 1
                1 0 0 1
                """;
        String expected = """
                1 0 0 -1
                0 0 0 -1
                1 0 0 -1""";
        assertEquals(expected, BOJ_14940.solve(input).strip());
    }

    @Test
    void testCase5_cornerTarget() throws IOException {
        String input = """
                2 2
                2 1
                1 1
                """;
        String expected = """
                0 1
                1 2""";
        assertEquals(expected, BOJ_14940.solve(input).strip());
    }

    @Test
    void testCase6_isolatedTarget() throws IOException {
        String input = """
                3 3
                1 0 1
                0 2 0
                1 0 1
                """;
        String expected = """
                -1 0 -1
                0 0 0
                -1 0 -1""";
        assertEquals(expected, BOJ_14940.solve(input).strip());
    }
}