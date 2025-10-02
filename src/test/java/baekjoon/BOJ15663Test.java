package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ15663Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                3 1
                4 4 2
                """;
        String expected = """
                2
                4
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                4 2
                9 7 9 1
                """;
        String expected = """
                1 7
                1 9
                7 1
                7 9
                9 1
                9 7
                9 9
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }

    @Test
    void testCase3_noDuplicate() throws IOException {
        String input = """
                3 2
                1 2 3
                """;
        String expected = """
                1 2
                1 3
                2 1
                2 3
                3 1
                3 2
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }

    @Test
    void testCase4_allSameNumbers() throws IOException {
        String input = """
                3 2
                5 5 5
                """;
        String expected = """
                5 5
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }

    @Test
    void testCase5_fullLength() throws IOException {
        String input = """
                3 3
                3 1 2
                """;
        String expected = """
                1 2 3
                1 3 2
                2 1 3
                2 3 1
                3 1 2
                3 2 1
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }

    @Test
    void testCase6_duplicateWithDifferent() throws IOException {
        String input = """
                4 3
                2 2 1 3
                """;
        String expected = """
                1 2 2
                1 2 3
                1 3 2
                2 1 2
                2 1 3
                2 2 1
                2 2 3
                2 3 1
                2 3 2
                3 1 2
                3 2 1
                3 2 2
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }

    @Test
    void testCase7_singleElement() throws IOException {
        String input = """
                1 1
                7
                """;
        String expected = """
                7
                """;
        assertEquals(expected, BOJ_15663.solve(input));
    }
}