package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ12865Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                4 7
                6 13
                4 8
                3 6
                5 12
                """;
        String expected = "14";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase2_singleItem() throws IOException {
        String input = """
                1 10
                5 100
                """;
        String expected = "100";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase3_cannotFitAny() throws IOException {
        String input = """
                3 5
                6 10
                7 20
                8 30
                """;
        String expected = "0";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase4_allItemsFit() throws IOException {
        String input = """
                3 10
                2 5
                3 7
                4 10
                """;
        String expected = "22";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase5_chooseOne() throws IOException {
        String input = """
                3 5
                5 10
                5 20
                5 15
                """;
        String expected = "20";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase6_exactWeight() throws IOException {
        String input = """
                2 10
                10 50
                5 30
                """;
        String expected = "50";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase7_multipleOptions() throws IOException {
        String input = """
                5 15
                12 4
                1 2
                4 10
                1 1
                2 2
                """;
        String expected = "15";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase8_zeroValue() throws IOException {
        String input = """
                3 10
                5 0
                3 10
                4 8
                """;
        String expected = "18";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase9_largeWeight() throws IOException {
        String input = """
                2 100
                50 100
                50 100
                """;
        String expected = "200";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase10_optimalChoice() throws IOException {
        String input = """
                6 10
                5 50
                4 40
                6 30
                3 10
                3 20
                2 15
                """;
        String expected = "90";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }

    @Test
    void testCase11_smallWeight() throws IOException {
        String input = """
                4 1
                1 10
                1 20
                1 30
                1 40
                """;
        String expected = "40";
        assertEquals(expected, BOJ_12865.solve(input).strip());
    }
}