package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2178Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                4 6
                101111
                101010
                101011
                111011
                """;
        String expected = "15".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase1_example2() throws IOException {
        String input = """
                4 6
                110110
                110110
                111111
                111101
                """;
        String expected = "9".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase1_example3() throws IOException {
        String input = """
                2 25
                1011101110111011101110111
                1110111011101110111011101
                """;
        String expected = "38".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase1_example4() throws IOException {
        String input = """
                7 7
                1011111
                1110001
                1000001
                1000001
                1000001
                1000001
                1111111
                """;
        String expected = "13".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase2_straightPath() throws IOException {
        String input = """
                2 2
                11
                11
                """;
        String expected = "3".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase3_longPath() throws IOException {
        String input = """
                3 3
                101
                111
                101
                """;
        String expected = "5".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase4_onePath() throws IOException {
        String input = """
                5 5
                10111
                10101
                10101
                10101
                11101
                """;
        String expected = "17".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase5_shortestPath() throws IOException {
        String input = """
                2 3
                111
                111
                """;
        String expected = "4".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }

    @Test
    void testCase6_zigzagPath() throws IOException {
        String input = """
                4 4
                1011
                1110
                0110
                0111
                """;
        String expected = "7".strip();
        assertEquals(expected, BOJ_2178.solve(input).strip());
    }
}