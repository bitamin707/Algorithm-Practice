package baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("동전 0")
class BOJ11047Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                10 4200
                1
                5
                10
                50
                100
                500
                1000
                5000
                10000
                50000
                """;

        String expected = "6"; // 1000원 4개, 100원 2개
        assertEquals(expected, BOJ_11047.solve(input));
    }

    @Test
    void testCase2_exactMatchLargestCoin() throws IOException {
        String input = """
                3 100
                1
                5
                100
                """;

        String expected = "1"; // 100원 1개
        assertEquals(expected, BOJ_11047.solve(input));
    }

    @Test
    void testCase3_useMultipleCoinTypes() throws IOException {
        String input = """
                4 4720
                1
                50
                100
                500
                """;

        String expected = "31"; // 500원 9개, 100원 2개, 50원 0개, 1원 20개 → 총 13개
        assertEquals(expected, BOJ_11047.solve(input));
    }
}
