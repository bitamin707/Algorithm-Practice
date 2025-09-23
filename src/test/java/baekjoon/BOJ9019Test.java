package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ9019Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                3
                1234 3412
                1000 1
                1 16
                """;
        String expected = """
                LL
                L
                DDDD
                """;
        assertEquals(expected, BOJ_9019.solve(input).strip());
    }

    @Test
    void testCase2_sameNumber() throws IOException {
        String input = """
                1
                1234 1234
                """;
        String expected = "";
        assertEquals(expected, BOJ_9019.solve(input).strip());
    }

    @Test
    void testCase3_singleOperations() throws IOException {
        String input = """
                4
                1 2
                1 0
                1234 2468
                1234 4123
                """;
        String expected = """
                D
                S
                D
                R
                """;
        assertEquals(expected, BOJ_9019.solve(input).strip());
    }

    @Test
    void testCase4_boundaryValues() throws IOException {
        String input = """
                3
                0 9999
                9999 0
                5000 0
                """;
        String expected = """
                S
                D
                D
                """;
        assertEquals(expected, BOJ_9019.solve(input).strip());
    }

    @Test
    void testCase5_complexRotation() throws IOException {
        String input = """
                2
                1000 1
                1 1000
                """;
        String expected = """
                L
                LLL
                """;
        assertEquals(expected, BOJ_9019.solve(input).strip());
    }

    @Test
    void testCase6_multipleD_operations() throws IOException {
        String input = """
                2
                1 8
                2 8
                """;
        String expected = """
                DDD
                DD
                """;
        assertEquals(expected, BOJ_9019.solve(input).strip());
    }
}