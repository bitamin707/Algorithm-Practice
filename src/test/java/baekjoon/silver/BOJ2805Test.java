package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2805Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                4 7
                20 15 10 17
                """;
        String expected = "15";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }

    @Test
    void testCase2_exactMatch() throws IOException {
        String input = """
                5 20
                4 42 40 26 46
                """;
        String expected = "36";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }

    @Test
    void testCase3_singleTree() throws IOException {
        String input = """
                1 10
                15
                """;
        String expected = "5";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }

    @Test
    void testCase4_allSameHeight() throws IOException {
        String input = """
                4 6
                10 10 10 10
                """;
        String expected = "8";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }

    @Test
    void testCase5_largeNumbers() throws IOException {
        String input = """
                3 999999999
                1000000000 1000000000 1000000000
                """;
        String expected = "666666667";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }

    @Test
    void testCase6_edgeCase() throws IOException {
        String input = """
                2 11
                10 10
                """;
        String expected = "4";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }

    @Test
    void testCase7_minimumCut() throws IOException {
        String input = """
                3 1
                1 2 2
                """;
        String expected = "1";
        assertEquals(expected, BOJ_2805.solve(input).strip());
    }
}