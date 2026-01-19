package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ11000Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3
                1 3
                2 4
                3 5
                """;
        // 1~3시 수업 중 3시에 시작하는 수업 가능 -> 강의실 1: (1-3, 3-5), 강의실 2: (2-4)
        String expected = "2";
        assertEquals(expected, BOJ_11000.solve(input).strip());
    }

    @Test
    void testCase2_all_overlap() throws IOException {
        String input = """
                3
                1 10
                2 10
                3 10
                """;
        // 시작 시간이 다 다르고 종료 시간 전이므로 3개 모두 다른 강의실 필요
        String expected = "3";
        assertEquals(expected, BOJ_11000.solve(input).strip());
    }

    @Test
    void testCase3_sequential() throws IOException {
        String input = """
                4
                1 2
                2 3
                3 4
                4 5
                """;
        // 끝나는 시간과 동시에 시작 가능하므로 강의실 1개로 충분
        String expected = "1";
        assertEquals(expected, BOJ_11000.solve(input).strip());
    }

    @Test
    void testCase4_unsorted_input() throws IOException {
        String input = """
                3
                9 10
                1 5
                5 9
                """;
        // 입력이 순서대로 들어오지 않아도 정렬을 통해 1개로 처리 가능해야 함
        String expected = "1";
        assertEquals(expected, BOJ_11000.solve(input).strip());
    }
}