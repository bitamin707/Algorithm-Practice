package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ17626Test {

    @Test
    void testCase1_perfectSquares() throws IOException {
        String input = "1";
        String expected = "1".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase2_perfectSquares() throws IOException {
        String input = "4";
        String expected = "1".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase3_twoSquares() throws IOException {
        String input = "5";
        String expected = "2".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase4_problemExample1() throws IOException {
        String input = "26";
        String expected = "2".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase5_threeSquares() throws IOException {
        String input = "3";
        String expected = "3".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase6_fourSquares() throws IOException {
        String input = "7";
        String expected = "4".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase7_largerNumber() throws IOException {
        String input = "100";
        String expected = "1".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase8_mediumNumber() throws IOException {
        String input = "12";
        String expected = "3".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase9_anotherExample() throws IOException {
        String input = "13";
        String expected = "2".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }

    @Test
    void testCase10_maxRange() throws IOException {
        String input = "50000";
        String expected = "2".strip();
        assertEquals(expected, BOJ_17626.solve(input).strip());
    }
}