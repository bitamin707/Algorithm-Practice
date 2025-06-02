package baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static baekjoon.BOJ_10816.solve;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("숫자 카드 2")
class BOJ10816Test {

    @Test
    void testCase1_basic() throws IOException {
        String input = "10\n6 3 2 10 10 10 -10 -10 7 3\n8\n10 9 -5 2 3 4 5 -10";
        String expected = "3 0 0 1 2 0 0 2";
        assertEquals(expected, solve(input));
    }

    @Test
    void testCase2_allNegative() throws IOException {
        String input = "5\n-1 -2 -3 -4 -5\n5\n-1 -2 -3 -4 -5";
        String expected = "1 1 1 1 1";
        assertEquals(expected, solve(input));
    }

    @Test
    void testCase3_allSame() throws IOException {
        String input = "5\n1 1 1 1 1\n3\n1 2 3";
        String expected = "5 0 0";
        assertEquals(expected, solve(input));
    }
}