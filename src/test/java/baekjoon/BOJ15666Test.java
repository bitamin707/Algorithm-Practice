package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ15666Test {

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
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                4 2
                9 7 9 1
                """;
        String expected = """
                1 1
                1 7
                1 9
                7 7
                7 9
                9 9
                """;
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }

    @Test
    void testCase2_example3() throws IOException {
        String input = """
                4 4
                1 1 2 2
                """;
        String expected = """
                1 1 1 1
                1 1 1 2
                1 1 2 2
                1 2 2 2
                2 2 2 2
                """;
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }

    @Test
    void testCase3_noDuplicate() throws IOException {
        String input = """
                3 2
                1 2 3
                """;
        String expected = """
                1 1
                1 2
                1 3
                2 2
                2 3
                3 3
                """;
        assertEquals(expected, BOJ_15666.solve(input).strip());
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
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }

    @Test
    void testCase5_fullLength() throws IOException {
        String input = """
                3 3
                3 1 2
                """;
        String expected = """
                1 1 1
                1 1 2
                1 1 3
                1 2 2
                1 2 3
                1 3 3
                2 2 2
                2 2 3
                2 3 3
                3 3 3
                """;
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }

    @Test
    void testCase6_duplicateValues() throws IOException {
        String input = """
                4 3
                2 2 1 3
                """;
        String expected = """
                1 1 1
                1 1 2
                1 1 3
                1 2 2
                1 2 3
                1 3 3
                2 2 2
                2 2 3
                2 3 3
                3 3 3
                """;
        assertEquals(expected, BOJ_15666.solve(input).strip());
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
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }

    @Test
    void testCase8_largeNumbers() throws IOException {
        String input = """
                4 2
                1000 2000 1000 3000
                """;
        String expected = """
                1000 1000
                1000 2000
                1000 3000
                2000 2000
                2000 3000
                3000 3000
                """;
        assertEquals(expected, BOJ_15666.solve(input).strip());
    }
}