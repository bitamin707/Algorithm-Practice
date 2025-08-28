package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ9095Test {

    @Test
    void testCase1_problemExample() throws IOException {
        String input = """
                3
                4
                7
                10
                """;
        String expected = """
                7
                44
                274
                """.strip();
        assertEquals(expected, BOJ_9095.solve(input).strip());
    }

    @Test
    void testCase2_smallValues() throws IOException {
        String input = """
                3
                1
                2
                3
                """;
        String expected = """
                1
                2
                4
                """.strip();
        assertEquals(expected, BOJ_9095.solve(input).strip());
    }

    @Test
    void testCase3_mediumValues() throws IOException {
        String input = """
                3
                5
                6
                8
                """;
        String expected = """
                13
                24
                81
                """.strip();
        assertEquals(expected, BOJ_9095.solve(input).strip());
    }

    @Test
    void testCase4_allValues() throws IOException {
        String input = """
                10
                1
                2
                3
                4
                5
                6
                7
                8
                9
                10
                """;
        String expected = """
                1
                2
                4
                7
                13
                24
                44
                81
                149
                274
                """.strip();
        assertEquals(expected, BOJ_9095.solve(input).strip());
    }

    @Test
    void testCase5_singleCase() throws IOException {
        String input = """
                1
                9
                """;
        String expected = "149".strip();
        assertEquals(expected, BOJ_9095.solve(input).strip());
    }

    @Test
    void testCase6_maxValue() throws IOException {
        String input = """
                1
                10
                """;
        String expected = "274".strip();
        assertEquals(expected, BOJ_9095.solve(input).strip());
    }
}