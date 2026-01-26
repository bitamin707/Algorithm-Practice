package baekjoon.silver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

@DisplayName("계단 오르기")
class BOJ2579Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                6
                10
                20
                15
                25
                10
                20
                """;
        String expected = "75"; // 최적 경로: 10 + 20 + 25 + 20
        assertEquals(expected, BOJ_2579.solve(input));
    }

    @Test
    void testCase2_singleStep() throws IOException {
        String input = """
                1
                50
                """;
        String expected = "50"; // 계단 하나만 있는 경우
        assertEquals(expected, BOJ_2579.solve(input));
    }

    @Test
    void testCase3_twoSteps() throws IOException {
        String input = """
                2
                30
                40
                """;
        String expected = "70"; // 두 계단 모두 밟기
        assertEquals(expected, BOJ_2579.solve(input));
    }

    @Test
    void testCase4_edgeCase() throws IOException {
        String input = """
                3
                10
                20
                30
                """;
        String expected = "50"; // 20 + 30 경로가 최대
        assertEquals(expected, BOJ_2579.solve(input));
    }
}
