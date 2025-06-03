package baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("좌표 압축")
class BOJ18870Test {

    @Test
    void testCase1_basic() throws IOException {
        String input = "5\n2 4 -10 4 -9";
        String expected = "2 3 0 3 1";
        assertEquals(expected, BOJ_18870.solve(input));
    }

    @Test
    void testCase2_duplicates() throws IOException {
        String input = "6\n1000 999 1000 999 1000 999";
        String expected = "1 0 1 0 1 0";
        assertEquals(expected, BOJ_18870.solve(input));
    }
}