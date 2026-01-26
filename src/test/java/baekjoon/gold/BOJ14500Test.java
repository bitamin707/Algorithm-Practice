package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ14500Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                5 5
                1 2 3 4 5
                5 4 3 2 1
                2 3 4 5 6
                6 5 4 3 2
                1 2 1 2 1
                """;
        String expected = "19";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase1_example2() throws IOException {
        String input = """
                4 5
                1 2 3 4 5
                1 2 3 4 5
                1 2 3 4 5
                1 2 3 4 5
                """;
        String expected = "20";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase1_example3() throws IOException {
        String input = """
                4 10
                1 2 1 2 1 2 1 2 1 2
                2 1 2 1 2 1 2 1 2 1
                1 2 1 2 1 2 1 2 1 2
                2 1 2 1 2 1 2 1 2 1
                """;
        String expected = "7";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase2_minimumSize() throws IOException {
        String input = """
                4 4
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 1 1
                """;
        String expected = "4";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase3_straightLine() throws IOException {
        String input = """
                4 6
                1 2 3 4 5 6
                1 1 1 1 1 1
                1 1 1 1 1 1
                1 1 1 1 1 1
                """;
        String expected = "18";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase4_Tshape() throws IOException {
        String input = """
                4 4
                1 1 1 1
                1 5 5 1
                1 5 1 1
                1 1 1 1
                """;
        String expected = "16";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase5_maxValues() throws IOException {
        String input = """
                4 4
                1000 1000 1000 1000
                1000 1000 1000 1000
                1000 1000 1000 1000
                1000 1000 1000 1000
                """;
        String expected = "4000";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase6_Lshape() throws IOException {
        String input = """
                4 4
                10 1 1 1
                10 1 1 1
                10 1 1 1
                10 10 1 1
                """;
        String expected = "40";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }

    @Test
    void testCase7_Oshape() throws IOException {
        String input = """
                4 4
                1 1 1 1
                1 10 10 1
                1 10 10 1
                1 1 1 1
                """;
        String expected = "40";
        assertEquals(expected, BOJ_14500.solve(input).strip());
    }
}