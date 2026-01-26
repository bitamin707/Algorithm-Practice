package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1080Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3 4
                0000
                0010
                0000
                1001
                1011
                1001
                """;
        String expected = "2".strip();
        assertEquals(expected, BOJ_1080.solve(input).strip());
    }

    @Test
    void testCase2_example() throws IOException {
        String input = """
                3 3
                111
                111
                111
                000
                000
                000
                """;
        String expected = "1".strip();
        assertEquals(expected, BOJ_1080.solve(input).strip());
    }

    @Test
    void testCase3_example() throws IOException {
        String input = """
                1 1
                1
                0
                """;
        String expected = "-1".strip();
        assertEquals(expected, BOJ_1080.solve(input).strip());
    }

    @Test
    void testCase4_example() throws IOException {
        String input = """
                18 3
                001
                100
                100
                000
                011
                010
                100
                100
                010
                010
                010
                110
                101
                101
                000
                110
                000
                110
                001
                100
                011
                000
                100
                010
                011
                100
                101
                101
                010
                001
                010
                010
                111
                110
                111
                001
                """;
        String expected = "7".strip();
        assertEquals(expected, BOJ_1080.solve(input).strip());
    }
}