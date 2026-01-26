package baekjoon.silver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class BOJ1927Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
            9
            0
            12345678
            1
            2
            0
            0
            0
            0
            32
            """;
        String expected = """
            0
            1
            2
            12345678
            0
            """.strip();
        assertEquals(expected, BOJ_1927.solve(input).strip());
    }

    @Test
    void testCase2_emptyHeap() throws IOException {
        String input = """
            3
            0
            0
            0
            """;
        String expected = """
            0
            0
            0
            """.strip();
        assertEquals(expected, BOJ_1927.solve(input).strip());
    }

    @Test
    void testCase3_onlyInsert() throws IOException {
        String input = """
            3
            5
            3
            1
            """;
        String expected = "";
        assertEquals(expected, BOJ_1927.solve(input).strip());
    }

    @Test
    void testCase4_insertAndPop() throws IOException {
        String input = """
            7
            3
            1
            5
            0
            2
            0
            0
            """;
        String expected = """
            1
            2
            3
            """.strip();
        assertEquals(expected, BOJ_1927.solve(input).strip());
    }

    @Test
    void testCase5_maxValue() throws IOException {
        String input = """
            4
            2147483647
            1000000000
            0
            0
            """;
        String expected = """
            1000000000
            2147483647
            """.strip();
        assertEquals(expected, BOJ_1927.solve(input).strip());
    }

    @Test
    void testCase6_singleElement() throws IOException {
        String input = """
            2
            100
            0
            """;
        String expected = "100";
        assertEquals(expected, BOJ_1927.solve(input).strip());
    }
}