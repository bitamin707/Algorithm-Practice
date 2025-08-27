package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ9461Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                2
                6
                12
                """;
        String expected = """
                3
                16
                """.strip();
        assertEquals(expected, BOJ_9461.solve(input).strip());
    }

    @Test
    void testCase2_smallValues() throws IOException {
        String input = """
                5
                1
                2
                3
                4
                5
                """;
        String expected = """
                1
                1
                1
                2
                2
                """.strip();
        assertEquals(expected, BOJ_9461.solve(input).strip());
    }

    @Test
    void testCase3_first10Values() throws IOException {
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
                1
                1
                2
                2
                3
                4
                5
                7
                9
                """.strip();
        assertEquals(expected, BOJ_9461.solve(input).strip());
    }

    @Test
    void testCase4_mediumValues() throws IOException {
        String input = """
                4
                15
                20
                25
                30
                """;
        String expected = """
                37
                151
                616
                2513
                """.strip();
        assertEquals(expected, BOJ_9461.solve(input).strip());
    }

    @Test
    void testCase5_largeValues() throws IOException {
        String input = """
                3
                50
                60
                70
                """;
        String expected = """
                696081
                11584946
                192809420
                """.strip();
        assertEquals(expected, BOJ_9461.solve(input).strip());
    }

    @Test
    void testCase6_sequentialValues() throws IOException {
        String input = """
                6
                11
                12
                13
                14
                15
                16
                """;
        String expected = """
                12
                16
                21
                28
                37
                49
                """.strip();
        assertEquals(expected, BOJ_9461.solve(input).strip());
    }
}