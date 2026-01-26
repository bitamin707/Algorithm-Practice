package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ15654Test {

    @Test
    void testCase1_example1() throws IOException {
        String input = """
                3 1
                4 5 2
                """;
        String expected = """
                2
                4
                5
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase2_example2() throws IOException {
        String input = """
                4 2
                9 8 7 1
                """;
        String expected = """
                1 7
                1 8
                1 9
                7 1
                7 8
                7 9
                8 1
                8 7
                8 9
                9 1
                9 7
                9 8
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase3_example3() throws IOException {
        String input = """
                4 4
                1231 1232 1233 1234
                """;
        String expected = """
                1231 1232 1233 1234
                1231 1232 1234 1233
                1231 1233 1232 1234
                1231 1233 1234 1232
                1231 1234 1232 1233
                1231 1234 1233 1232
                1232 1231 1233 1234
                1232 1231 1234 1233
                1232 1233 1231 1234
                1232 1233 1234 1231
                1232 1234 1231 1233
                1232 1234 1233 1231
                1233 1231 1232 1234
                1233 1231 1234 1232
                1233 1232 1231 1234
                1233 1232 1234 1231
                1233 1234 1231 1232
                1233 1234 1232 1231
                1234 1231 1232 1233
                1234 1231 1233 1232
                1234 1232 1231 1233
                1234 1232 1233 1231
                1234 1233 1231 1232
                1234 1233 1232 1231
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase4_minimumCase() throws IOException {
        String input = """
                1 1
                10
                """;
        String expected = """
                10
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase5_twoElements() throws IOException {
        String input = """
                2 1
                5 3
                """;
        String expected = """
                3
                5
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase6_twoTwo() throws IOException {
        String input = """
                2 2
                10 20
                """;
        String expected = """
                10 20
                20 10
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase7_unsortedInput() throws IOException {
        String input = """
                3 2
                30 10 20
                """;
        String expected = """
                10 20
                10 30
                20 10
                20 30
                30 10
                30 20
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase8_largeNumbers() throws IOException {
        String input = """
                3 2
                9999 1000 5000
                """;
        String expected = """
                1000 5000
                1000 9999
                5000 1000
                5000 9999
                9999 1000
                9999 5000
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase9_maxSize() throws IOException {
        String input = """
                8 1
                8 7 6 5 4 3 2 1
                """;
        String expected = """
                1
                2
                3
                4
                5
                6
                7
                8
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }

    @Test
    void testCase10_threeTwo() throws IOException {
        String input = """
                3 3
                100 200 300
                """;
        String expected = """
                100 200 300
                100 300 200
                200 100 300
                200 300 100
                300 100 200
                300 200 100
                """;
        assertEquals(expected, BOJ_15654.solve(input).strip());
    }
}