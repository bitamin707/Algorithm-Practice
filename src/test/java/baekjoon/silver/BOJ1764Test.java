package baekjoon.silver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1764Test {

    @Test
    void testCase1_basicOverlap() throws IOException {
        String input = """
            3 4
            ohhenrie
            charlie
            baesangwook
            obama
            baesangwook
            ohhenrie
            clinton
            """;

        String expected = """
            2
            baesangwook
            ohhenrie
            """;

        assertEquals(expected, BOJ_1764.solve(input));
    }

    @Test
    void testCase2_noOverlap() throws IOException {
        String input = """
            2 2
            alice
            bob
            carol
            dave
            """;

        String expected = """
        0
        """;

        assertEquals(expected, BOJ_1764.solve(input));
    }

    @Test
    void testCase3_allOverlap() throws IOException {
        String input = """
            3 3
            kim
            lee
            park
            kim
            lee
            park
            """;

        String expected = """
            3
            kim
            lee
            park
            """;

        assertEquals(expected, BOJ_1764.solve(input));
    }
}
