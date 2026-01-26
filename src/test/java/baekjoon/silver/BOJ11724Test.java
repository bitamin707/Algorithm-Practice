package baekjoon.silver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ11724Test {

    @Test
    void testCase1_basicComponents() throws IOException {
        String input = """
                6 5
                1 2
                2 5
                5 1
                3 4
                4 6
                """;

        String expected = "2";
        assertEquals(expected, BOJ_11724.solve(input));
    }

    @Test
    void testCase1_basicComponents2() throws IOException {
        String input = """
                6 8
                1 2
                2 5
                5 1
                3 4
                4 6
                5 4
                2 4
                2 3
                """;

        String expected = "1";
        assertEquals(expected, BOJ_11724.solve(input));
    }

    @Test
    void testCase2_allDisconnected() throws IOException {
        String input = """
                5 0
                """;

        String expected = "5";
        assertEquals(expected, BOJ_11724.solve(input));
    }

    @Test
    void testCase3_allConnected() throws IOException {
        String input = """
                4 3
                1 2
                2 3
                3 4
                """;

        String expected = "1";
        assertEquals(expected, BOJ_11724.solve(input));
    }
}
