package baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

@DisplayName("1로 만들기")
class BOJ1463Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                2
                """;
        String expected = "1"; // 2 → 1 (나누기 2)
        assertEquals(expected, BOJ_1463.solve(input));
    }

    @Test
    void testCase2_smallNumber() throws IOException {
        String input = """
                10
                """;
        String expected = "3"; // 10 → 9 → 3 → 1
        assertEquals(expected, BOJ_1463.solve(input));
    }

    @Test
    void testCase3_largeNumber() throws IOException {
        String input = """
                1
                """;
        String expected = "0"; // 이미 1이므로 연산 없음
        assertEquals(expected, BOJ_1463.solve(input));
    }
}
