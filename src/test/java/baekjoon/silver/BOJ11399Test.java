package baekjoon.silver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ11399Test {
    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                5
                3 1 4 3 2
                """;
        String expected = "32"; // 정렬 후 [1,2,3,3,4] → 누적합 = 1 + (1+2) + (1+2+3) + (1+2+3+3) + (1+2+3+3+4) = 32
        assertEquals(expected, BOJ_11399.solve(input));
    }

    @Test
    void testCase2_alreadySorted() throws IOException {
        String input = """
                3
                1 2 3
                """;
        String expected = "10"; // 1 + 3 + 6 = 10
        assertEquals(expected, BOJ_11399.solve(input));
    }

    @Test
    void testCase3_allSameTime() throws IOException {
        String input = """
                4
                5 5 5 5
                """;
        String expected = "50"; // 5 + 10 + 15 + 20 = 50
        assertEquals(expected, BOJ_11399.solve(input));
    }
}