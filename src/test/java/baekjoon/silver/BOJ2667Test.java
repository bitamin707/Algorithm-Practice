package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2667Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                7
                0110100
                0110101
                1110101
                0000111
                0100000
                0111110
                0111000
                """;
        String expected = """
                3
                7
                8
                9""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase2_singleHouse() throws IOException {
        String input = """
                5
                00000
                01000
                00000
                00000
                00000
                """;
        String expected = """
                1
                1""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase3_noHouses() throws IOException {
        String input = """
                5
                00000
                00000
                00000
                00000
                00000
                """;
        String expected = "0";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase4_allHouses() throws IOException {
        String input = """
                3
                111
                111
                111
                """;
        String expected = """
                1
                9""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase5_linearComplex() throws IOException {
        String input = """
                5
                10000
                10000
                10000
                10000
                10000
                """;
        String expected = """
                1
                5""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase6_multipleSmallComplexes() throws IOException {
        String input = """
                5
                10101
                00000
                10101
                00000
                10101
                """;
        String expected = """
                6
                1
                1
                1
                1
                1
                1""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase7_sortingTest() throws IOException {
        String input = """
                6
                111000
                100000
                000110
                000100
                001100
                000000
                """;
        String expected = """
                3
                2
                3
                4""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }

    @Test
    void testCase8_complexShape() throws IOException {
        String input = """
                8
                01110000
                01010000
                01110000
                00000111
                00000101
                00000111
                00000000
                11111111
                """;
        String expected = """
                3
                5
                5
                8""";
        assertEquals(expected, BOJ_2667.solve(input).strip());
    }
}