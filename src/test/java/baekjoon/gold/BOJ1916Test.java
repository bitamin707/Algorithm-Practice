package baekjoon.gold;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1916Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                5
                8
                1 2 2
                1 3 3
                1 4 1
                1 5 10
                2 4 2
                3 4 1
                4 5 3
                3 5 1
                1 5
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase2_directPath() throws IOException {
        String input = """
                3
                2
                1 2 5
                2 3 3
                1 3
                """;
        String expected = "8";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase3_singleEdge() throws IOException {
        String input = """
                2
                1
                1 2 100
                1 2
                """;
        String expected = "100";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase4_multiplePathsSameDestination() throws IOException {
        String input = """
                4
                5
                1 2 1
                1 3 4
                2 3 2
                2 4 5
                3 4 1
                1 4
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase5_duplicateEdges() throws IOException {
        String input = """
                3
                4
                1 2 10
                1 2 5
                2 3 3
                1 3 20
                1 3
                """;
        String expected = "8";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase6_zeroCostEdge() throws IOException {
        String input = """
                3
                3
                1 2 0
                2 3 5
                1 3 10
                1 3
                """;
        String expected = "5";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase7_complexGraph() throws IOException {
        String input = """
                6
                9
                1 2 5
                1 3 4
                2 3 2
                2 4 7
                3 4 6
                3 5 11
                4 5 3
                4 6 8
                5 6 8
                1 6
                """;
        String expected = "18";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase8_longPath() throws IOException {
        String input = """
                5
                4
                1 2 1
                2 3 1
                3 4 1
                4 5 1
                1 5
                """;
        String expected = "4";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase9_triangleGraph() throws IOException {
        String input = """
                3
                3
                1 2 10
                2 3 10
                1 3 30
                1 3
                """;
        String expected = "20";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }

    @Test
    void testCase10_sameCost() throws IOException {
        String input = """
                4
                6
                1 2 5
                1 3 5
                2 4 5
                3 4 5
                2 3 5
                3 2 5
                1 4
                """;
        String expected = "10";
        assertEquals(expected, BOJ_1916.solve(input).strip());
    }
}