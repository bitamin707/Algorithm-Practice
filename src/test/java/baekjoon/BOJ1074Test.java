package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1074Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                2 3 1
                """;
        String expected = "11";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                3 7 7
                """;
        String expected = "63";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase3_n1_topLeft() throws IOException {
        String input = """
                1 0 0
                """;
        String expected = "0";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase4_n1_topRight() throws IOException {
        String input = """
                1 0 1
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase5_n1_bottomLeft() throws IOException {
        String input = """
                1 1 0
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase6_n1_bottomRight() throws IOException {
        String input = """
                1 1 1
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase7_n2_center() throws IOException {
        String input = """
                2 1 1
                """;
        String expected = "3";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase8_n2_start() throws IOException {
        String input = """
                2 0 0
                """;
        String expected = "0";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase9_n2_end() throws IOException {
        String input = """
                2 3 3
                """;
        String expected = "15";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase10_n2_thirdQuadrant() throws IOException {
        String input = """
                2 2 2
                """;
        String expected = "12";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase11_n4_position() throws IOException {
        String input = """
                4 7 7
                """;
        String expected = "63";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }

    @Test
    void testCase12_n4_lastPosition() throws IOException {
        String input = """
                4 15 15
                """;
        String expected = "255";
        assertEquals(expected, BOJ_1074.solve(input).strip());
    }
}