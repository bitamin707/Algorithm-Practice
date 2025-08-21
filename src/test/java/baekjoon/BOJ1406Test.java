package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1406Test {

    @Test
    void testCase1_basicOperations() throws IOException {
        String input = """
                abcd
                3
                P x
                L
                P y
                """;
        String expected = "abcdyx"; // 과정: "abcd" → "abcdx" → 커서 왼쪽 → "abcdyx"
        assertEquals(expected, BOJ_1406.solve(input));
    }

    @Test
    void testCase2_deleteOperation() throws IOException {
        String input = """
                abc
                3
                L
                L
                B
                """;
        String expected = "bc"; // "abc" → 커서 왼쪽 2번 → 'a' 삭제 → "bc"
        assertEquals(expected, BOJ_1406.solve(input));
    }

    @Test
    void testCase3_cursorAtEdges() throws IOException {
        String input = """
                hello
                4
                L
                L
                L
                P z
                """;
        String expected = "hezllo"; // "hello" → 커서 3칸 왼쪽 → 'z' 추가
        assertEquals(expected, BOJ_1406.solve(input));
    }

    @Test
    void testCase4_multipleInsertions() throws IOException {
        String input = """
                a
                5
                P b
                P c
                P d
                L
                P e
                """;
        String expected = "abced"; // "a" → "ab" → "abc" → "abcd" → 커서 왼쪽 → "abcde"
        assertEquals(expected, BOJ_1406.solve(input));
    }
}
