package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1931Test {

    @Test
    void testCase1_basicExample() throws IOException {
        String input = """
                11
                1 4
                3 5
                0 6
                5 7
                3 9
                5 9
                6 10
                8 11
                8 12
                2 14
                12 16
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase2_sameStartEnd() throws IOException {
        String input = """
                3
                1 1
                2 2
                3 3
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase3_overlapping() throws IOException {
        String input = """
                4
                1 2
                2 3
                3 4
                4 5
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase4_singleMeeting() throws IOException {
        String input = """
                1
                0 10
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase5_noOverlap() throws IOException {
        String input = """
                3
                1 3
                5 7
                9 11
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase6_complexCase() throws IOException {
        String input = """
                5
                6 7
                6 6
                5 6
                5 5
                7 7
                """;
        String expected = "5";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase7_longMeetingVsShort() throws IOException {
        String input = """
                3
                1 10
                2 3
                4 5
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase8_sameEndTime() throws IOException {
        String input = """
                4
                1 5
                2 5
                3 5
                4 5
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase9_zeroStartTime() throws IOException {
        String input = """
                3
                0 0
                0 1
                1 2
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }

    @Test
    void testCase10_reverseOrder() throws IOException {
        String input = """
                4
                8 10
                6 8
                4 6
                2 4
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1931.solve(input).strip());
    }
}