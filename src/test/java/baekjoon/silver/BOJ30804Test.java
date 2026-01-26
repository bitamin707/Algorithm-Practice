package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ30804Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                9
                1 2 1 2 1 1 2 1 2
                """;
        String expected = "9";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                10
                1 1 2 1 5 4 5 7 9 4
                """;
        String expected = "4";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase3_singleFruit() throws IOException {
        String input = """
                1
                5
                """;
        String expected = "1";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase4_twoSameFruits() throws IOException {
        String input = """
                3
                3 3 3
                """;
        String expected = "3";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase5_alternatingTwoFruits() throws IOException {
        String input = """
                6
                1 2 1 2 1 2
                """;
        String expected = "6";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase6_threeDifferentFruits() throws IOException {
        String input = """
                5
                1 2 3 2 1
                """;
        String expected = "3";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase7_manyDifferentFruits() throws IOException {
        String input = """
                7
                1 2 3 4 5 6 7
                """;
        String expected = "2";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }

    @Test
    void testCase8_edgeCase() throws IOException {
        String input = """
                8
                1 1 1 2 2 3 3 3
                """;
        String expected = "5";
        assertEquals(expected, BOJ_30804.solve(input).strip());
    }
}