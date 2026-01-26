package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1149Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3
                26 40 83
                49 60 57
                13 89 99
                """;
        String expected = "96";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase1_example2() throws IOException {
        String input = """
                3
                1 100 100
                100 1 100
                100 100 1
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase1_example3() throws IOException {
        String input = """
                3
                1 100 100
                100 100 100
                1 100 100
                """;
        String expected = "102";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase1_example4() throws IOException {
        String input = """
                6
                30 19 5
                64 77 64
                15 19 97
                4 71 57
                90 86 84
                93 32 91
                """;
        String expected = "208";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase1_example5() throws IOException {
        String input = """
                8
                71 39 44
                32 83 55
                51 37 63
                89 29 100
                83 58 11
                65 13 15
                47 25 29
                60 66 19
                """;
        String expected = "253";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase2_twoHouses() throws IOException {
        String input = """
                2
                1 100 100
                100 1 100
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase3_allSameCost() throws IOException {
        String input = """
                3
                10 10 10
                10 10 10
                10 10 10
                """;
        String expected = "30";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase4_increasingCost() throws IOException {
        String input = """
                4
                1 2 3
                4 5 6
                7 8 9
                10 11 12
                """;
        String expected = "24";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase5_maxCost() throws IOException {
        String input = """
                3
                1000 1000 1000
                1000 1000 1000
                1000 1000 1000
                """;
        String expected = "3000";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase6_extremeDifference() throws IOException {
        String input = """
                4
                1 1000 1000
                1000 1 1000
                1000 1000 1
                1 1000 1000
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase7_fiveHouses() throws IOException {
        String input = """
                5
                10 20 30
                20 30 10
                30 10 20
                10 20 30
                20 30 10
                """;
        String expected = "50";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }

    @Test
    void testCase8_greedyNotOptimal() throws IOException {
        String input = """
                3
                10 50 50
                50 10 50
                100 100 1
                """;
        String expected = "21";
        assertEquals(expected, BOJ_1149.solve(input).strip());
    }
}