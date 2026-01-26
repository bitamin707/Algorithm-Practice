package baekjoon.silver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1018Test {

    @Test
    void testCase_minimalExample() throws IOException {
        String input =
                "8 8\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBBBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW";
        int expected = 1; // 한 칸만 고치면 됨
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_allBlack() throws IOException {
        String input =
                "10 13\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBB";
        int expected = 32; // 한 영역 최소 32칸 칠해야 체스판 만들 수 있음
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_checkerBoard() throws IOException {
        String input =
                "8 8\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB";
        int expected = 0; // 이미 완벽한 체스판
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_largeBoard() throws IOException {
        String input =
                "10 10\n" +
                        "BWBWBWBWBW\n" +
                        "WBWBWBWBWB\n" +
                        "BWBWBWBWBW\n" +
                        "WBWBWBWBWB\n" +
                        "BWBWBWBWBW\n" +
                        "WBWBWBWBWB\n" +
                        "BWBWBWBWBW\n" +
                        "WBWBWBWBWB\n" +
                        "BWBWBWBWBW\n" +
                        "WBWBWBWBWB";
        int expected = 0; // 완벽한 체스패턴이 다수 포함
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_exampleInput2() throws IOException {
        String input =
                "10 13\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "WWWWWWWWWWBWB\n" +
                        "WWWWWWWWWWBWB";
        int expected = 12;
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_exampleInput3() throws IOException {
        String input =
                "8 8\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB";
        int expected = 0;
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_exampleInput4() throws IOException {
        String input =
                "9 23\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBW";
        int expected = 31;
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_exampleInput5() throws IOException {
        String input =
                "10 10\n" +
                        "BBBBBBBBBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBBBBBBBBB";
        int expected = 0;
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_exampleInput6() throws IOException {
        String input =
                "8 8\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBBBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWWWB\n" +
                        "BWBWBWBW";
        int expected = 2;
        assertEquals(expected, BOJ_1018.solve(input));
    }

    @Test
    void testCase_exampleInput7() throws IOException {
        String input =
                "11 12\n" +
                        "BWWBWWBWWBWW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBWWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW";
        int expected = 15;
        assertEquals(expected, BOJ_1018.solve(input));
    }
}