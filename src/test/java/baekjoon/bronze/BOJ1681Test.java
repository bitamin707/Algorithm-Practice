package baekjoon.bronze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1681Test {
    @Test
    void testCase1_example() throws IOException {
        String input = "10 1";
        String expected = "22";
        assertEquals(expected.strip(), BOJ_1681.solve(input).strip());
    }

    @Test
    void testCase2_noSkip() throws IOException {
        String input = "5 9";
        String expected = "5";
        assertEquals(expected.strip(), BOJ_1681.solve(input).strip());
    }

    @Test
    void testCase3_skipZero() throws IOException {
        String input = "10 0";
        String expected = "11";
        assertEquals(expected.strip(), BOJ_1681.solve(input).strip());
    }

    @Test
    void testCase4_edgeCase() throws IOException {
        String input = "1 1";
        String expected = "2";
        assertEquals(expected.strip(), BOJ_1681.solve(input).strip());
    }
}