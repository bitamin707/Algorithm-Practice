package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2504Test {
    @Test
    void testCase1_example1() throws IOException {
        String input = "(()[[]])([])";
        String expected = "28";
        assertEquals(expected, BOJ_2504.solve(input).strip());
    }

    @Test
    void testCase2_invalid() throws IOException {
        String input = "[][]((]";
        String expected = "0";
        assertEquals(expected, BOJ_2504.solve(input).strip());
    }

    @Test
    void testCase3_simple() throws IOException {
        String input = "()[]";
        String expected = "5";
        assertEquals(expected, BOJ_2504.solve(input).strip());
    }

    @Test
    void testCase4_nested() throws IOException {
        String input = "[([])]";
        String expected = "18";
        assertEquals(expected, BOJ_2504.solve(input).strip());
    }

    @Test
    void testCase5_edge() throws IOException {
        String input = "(((())))";
        String expected = "16";
        assertEquals(expected, BOJ_2504.solve(input).strip());
    }
}