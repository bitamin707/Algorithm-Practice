package baekjoon.silver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1260Test {

    @Test
    void testCase1_basicGraph() throws IOException {
        String input = """
            4 5 1
            1 2
            1 3
            1 4
            2 4
            3 4
            """;

        String expected = """
            1 2 4 3
            1 2 3 4
            """;

        assertEquals(expected, BOJ_1260.solve(input));
    }

    @Test
    void testCase2_disconnected() throws IOException {
        String input = """
            5 3 1
            1 2
            2 3
            4 5
            """;

        String expected = """
            1 2 3
            1 2 3
            """;

        assertEquals(expected, BOJ_1260.solve(input));
    }

    @Test
    void testCase3_singleNode() throws IOException {
        String input = """
            1 0 1
            """;

        String expected = """
            1
            1
            """;

        assertEquals(expected, BOJ_1260.solve(input));
    }
}
