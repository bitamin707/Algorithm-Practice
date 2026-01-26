package baekjoon.bronze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2750Test {

    @Test
    void testCase1_basicCase() throws IOException {
        String input = """
                5
                5
                2
                3
                4
                1
                """;
        String expected = """
                1
                2
                3
                4
                5
                """.strip();
        assertEquals(expected, BOJ_2750.solve(input).strip());
    }

    @Test
    void testCase2_alreadySorted() throws IOException {
        String input = """
                3
                1
                2
                3
                """;
        String expected = """
                1
                2
                3
                """.strip();
        assertEquals(expected, BOJ_2750.solve(input).strip());
    }

    @Test
    void testCase3_reverseOrder() throws IOException {
        String input = """
                4
                9
                7
                5
                3
                """;
        String expected = """
                3
                5
                7
                9
                """.strip();
        assertEquals(expected, BOJ_2750.solve(input).strip());
    }

    @Test
    void testCase4_duplicates() throws IOException {
        String input = """
                6
                4
                2
                4
                2
                1
                3
                """;
        String expected = """
                1
                2
                2
                3
                4
                4
                """.strip();
        assertEquals(expected, BOJ_2750.solve(input).strip());
    }
}
