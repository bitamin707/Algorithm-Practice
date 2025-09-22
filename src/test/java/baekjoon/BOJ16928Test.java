package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ16928Test {

    @Test
    void testCase1_basicExample() throws IOException {
        String input = """
                3 7
                32 62
                42 68
                12 98
                95 13
                97 25
                93 37
                79 27
                75 19
                49 47
                67 17
                """;
        String expected = "3";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase2_noLadderOrSnake() throws IOException {
        String input = """
                0 0
                """;
        String expected = "17";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase3_oneLadderToEnd() throws IOException {
        String input = """
                1 0
                10 100
                """;
        String expected = "2";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase4_onlySnakes() throws IOException {
        String input = """
                0 1
                50 10
                """;
        String expected = "17";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase5_multipleLadders() throws IOException {
        String input = """
                3 0
                10 30
                40 60
                70 90
                """;
        String expected = "8";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase6_snakeAtEnd() throws IOException {
        String input = """
                0 1
                99 50
                """;
        String expected = "17";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase7_mixedShort() throws IOException {
        String input = """
                1 1
                5 20
                15 5
                """;
        String expected = "15";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase8_earlyLadder() throws IOException {
        String input = """
                1 0
                2 99
                """;
        String expected = "2";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase9_consecutiveLadders() throws IOException {
        String input = """
                2 0
                20 40
                41 80
                """;
        String expected = "9";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase10_snakeThenLadder() throws IOException {
        String input = """
                1 1
                10 90
                95 50
                """;
        String expected = "9";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase11_nearEnd() throws IOException {
        String input = """
                1 0
                95 100
                """;
        String expected = "16";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }

    @Test
    void testCase12_simpleLadder() throws IOException {
        String input = """
                1 0
                50 80
                """;
        String expected = "11";
        assertEquals(expected, BOJ_16928.solve(input).strip());
    }
}