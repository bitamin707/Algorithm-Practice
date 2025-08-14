package baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

@DisplayName("피보나치 함수")
class BOJ1003Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                3
                0
                1
                3
                """;
        String expected = """
                1 0
                0 1
                1 2
                """.strip();
        assertEquals(expected, BOJ_1003.solve(input).strip());
    }

    @Test
    void testCase2_largerNumbers() throws IOException {
        String input = """
                2
                6
                22
                """;
        String expected = """
                5 8
                10946 17711
                """.strip();
        assertEquals(expected, BOJ_1003.solve(input).strip());
    }

    @Test
    void testCase3_edgeCases() throws IOException {
        String input = """
                2
                0
                40
                """;
        String expected = """
                1 0
                63245986 102334155
                """.strip();
        assertEquals(expected, BOJ_1003.solve(input).strip());
    }
}
