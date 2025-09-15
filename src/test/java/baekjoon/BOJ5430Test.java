package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ5430Test {

    @Test
    void testCase1_basicExample() throws IOException {
        String input = """
                4
                RDD
                4
                [1,2,3,4]
                DD
                1
                [42]
                RRD
                6
                [1,1,2,3,5,8]
                D
                0
                []
                """;
        String expected = """
                [2,1]
                error
                [1,2,3,5,8]
                error""";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase2_emptyArrayReverse() throws IOException {
        String input = """
                1
                R
                0
                []
                """;
        String expected = "[]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase3_multipleReverse() throws IOException {
        String input = """
                1
                RRR
                3
                [1,2,3]
                """;
        String expected = "[3,2,1]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase4_deleteAll() throws IOException {
        String input = """
                1
                DDD
                3
                [1,2,3]
                """;
        String expected = "[]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase5_singleElementRD() throws IOException {
        String input = """
                1
                RD
                1
                [5]
                """;
        String expected = "[]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase6_noOperation() throws IOException {
        String input = """
                1
                
                3
                [1,2,3]
                """;
        String expected = "[1,2,3]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase7_complexOperation() throws IOException {
        String input = """
                1
                RDDR
                5
                [10,20,30,40,50]
                """;
        String expected = "[10,20,30]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase8_errorAfterReverse() throws IOException {
        String input = """
                1
                RDD
                1
                [1]
                """;
        String expected = "error";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase9_evenReverse() throws IOException {
        String input = """
                1
                RRRR
                4
                [1,2,3,4]
                """;
        String expected = "[1,2,3,4]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase10_deleteFromReversed() throws IOException {
        String input = """
                1
                RD
                3
                [100,99,98]
                """;
        String expected = "[99,100]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase11_largeArray() throws IOException {
        String input = """
                1
                RRDD
                6
                [1,2,3,4,5,6]
                """;
        String expected = "[3,4,5,6]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }

    @Test
    void testCase12_singleDigitNumbers() throws IOException {
        String input = """
                1
                RRD
                2
                [7,8]
                """;
        String expected = "[8]";
        assertEquals(expected, BOJ_5430.solve(input).strip());
    }
}