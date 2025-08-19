package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2606Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                7
                6
                1 2
                2 3
                1 5
                5 2
                5 6
                4 7
                """;
        String expected = "4"; // 감염되는 컴퓨터: 2,3,5,6
        assertEquals(expected, BOJ_2606.solve(input));
    }

    @Test
    void testCase2_noConnections() throws IOException {
        String input = """
                5
                0
                """;
        String expected = "0"; // 연결이 없으므로 1번만 감염
        assertEquals(expected, BOJ_2606.solve(input));
    }

    @Test
    void testCase3_allConnected() throws IOException {
        String input = """
                4
                6
                1 2
                1 3
                1 4
                2 3
                2 4
                3 4
                """;
        String expected = "3"; // 모든 컴퓨터 감염 (1번 제외)
        assertEquals(expected, BOJ_2606.solve(input));
    }

    @Test
    void testCase4_disconnectedGraph() throws IOException {
        String input = """
                6
                2
                2 3
                4 5
                """;
        String expected = "0"; // 1번이 고립 → 감염 확산 없음
        assertEquals(expected, BOJ_2606.solve(input));
    }
}
