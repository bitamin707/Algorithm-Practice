package baekjoon.silver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class BOJ24444Test {
    @Test
    void testCase1_example() throws IOException {
        String input = """
            5 5 1
            1 4
            1 2
            2 3
            2 4
            3 4
            """;
        String expected = """
            1
            2
            4
            3
            0
            """;
        assertEquals(expected.strip(), BOJ_24444.solve(input).strip());
    }

    @Test
    void testCase2_disconnected() throws IOException {
        String input = """
            3 1 1
            1 2
            """;
        String expected = """
            1
            2
            0
            """;
        assertEquals(expected.strip(), BOJ_24444.solve(input).strip());
    }

    @Test
    void testCase3_singleNode() throws IOException {
        String input = """
            1 0 1
            """;
        String expected = "1";
        assertEquals(expected.strip(), BOJ_24444.solve(input).strip());
    }

    @Test
    void testCase4_lineGraph() throws IOException {
        String input = """
            4 3 4
            1 2
            2 3
            3 4
            """;
        String expected = """
            4
            3
            2
            1
            """;
        assertEquals(expected.strip(), BOJ_24444.solve(input).strip());
    }
}