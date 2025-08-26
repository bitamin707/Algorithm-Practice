package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1012Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                2
                10 8 17
                0 0
                1 0
                1 1
                4 2
                4 3
                4 5
                2 4
                3 4
                7 4
                8 4
                9 4
                7 5
                8 5
                9 5
                7 6
                8 6
                9 6
                10 10 1
                5 5
                """;
        String expected = """
                5
                1
                """.strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }

    @Test
    void testCase1_example2() throws IOException {
        String input = """
                1
                   5 3 6
                   0 2
                   1 2
                   2 2
                   3 2
                   4 2
                   4 0
                """;
        String expected = """
                2
                """.strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }

    @Test
    void testCase2_singleGroup() throws IOException {
        String input = """
                1
                3 3 4
                0 0
                0 1
                1 0
                1 1
                """;
        String expected = "1".strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }

    @Test
    void testCase3_separatedGroups() throws IOException {
        String input = """
                1
                5 5 6
                0 0
                0 1
                2 2
                2 3
                4 4
                3 4
                """;
        String expected = "3".strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }

    @Test
    void testCase4_singleCabbage() throws IOException {
        String input = """
                1
                2 2 1
                1 1
                """;
        String expected = "1".strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }

    @Test
    void testCase5_allSeparated() throws IOException {
        String input = """
                1
                3 3 4
                0 0
                0 2
                2 0
                2 2
                """;
        String expected = "4".strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }

    @Test
    void testCase6_lineShape() throws IOException {
        String input = """
                1
                5 1 5
                0 0
                1 0
                2 0
                3 0
                4 0
                """;
        String expected = "1".strip();
        assertEquals(expected, BOJ_1012.solve(input).strip());
    }
}