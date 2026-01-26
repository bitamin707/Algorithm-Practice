package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1629Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                10 11 12
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase2_powerOfTwo() throws IOException {
        String input = """
                2 10 1000
                """;
        String expected = "24";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase3_oddExponent() throws IOException {
        String input = """
                3 7 5
                """;
        String expected = "2";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase4_smallNumbers() throws IOException {
        String input = """
                5 3 7
                """;
        String expected = "6";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase5_exponentZero() throws IOException {
        String input = """
                100 0 5
                """;
        String expected = "1";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase6_exponentOne() throws IOException {
        String input = """
                7 1 10
                """;
        String expected = "7";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase7_largeExponent() throws IOException {
        String input = """
                2 31 1000000
                """;
        String expected = "147483648";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase8_resultZero() throws IOException {
        String input = """
                6 3 9
                """;
        String expected = "0";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase9_largeNumbers() throws IOException {
        String input = """
                1000000 1000 1000
                """;
        String expected = "0";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase10_primeMod() throws IOException {
        String input = """
                123 456 789
                """;
        String expected = "699";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase11_maxInput() throws IOException {
        String input = """
                2147483647 2 1000000007
                """;
        String expected = "407725480";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }

    @Test
    void testCase12_evenExponent() throws IOException {
        String input = """
                4 8 10
                """;
        String expected = "6";
        assertEquals(expected, BOJ_1629.solve(input).strip());
    }
}