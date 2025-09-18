package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ10026Test {

    @Test
    void testCase1_basicExample() throws IOException {
        String input = """
                5
                RRRBB
                GGBBB
                BBBRR
                BBRRR
                RRRRR
                """;
        String expected = "4 3";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase2_singleColor() throws IOException {
        String input = """
                3
                RRR
                RRR
                RRR
                """;
        String expected = "1 1";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase3_verticalStripes() throws IOException {
        String input = """
                3
                RGB
                RGB
                RGB
                """;
        String expected = "3 2";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase4_onlyBlue() throws IOException {
        String input = """
                2
                BB
                BB
                """;
        String expected = "1 1";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase5_checkerboard() throws IOException {
        String input = """
                4
                RGRG
                GRGR
                RGRG
                GRGR
                """;
        String expected = "16 1";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase6_separateRegions() throws IOException {
        String input = """
                3
                RBG
                BBB
                GBR
                """;
        String expected = "5 5";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase7_connectedRG() throws IOException {
        String input = """
                4
                RRRR
                RGGG
                RGGG
                RRRR
                """;
        String expected = "2 1";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase8_singleCell() throws IOException {
        String input = """
                1
                R
                """;
        String expected = "1 1";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase9_horizontalStripes() throws IOException {
        String input = """
                3
                RRR
                BBB
                GGG
                """;
        String expected = "3 3";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase10_isolatedColors() throws IOException {
        String input = """
                3
                RBB
                BRB
                BBR
                """;
        String expected = "5 5";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase11_mixedPattern() throws IOException {
        String input = """
                4
                RRGG
                RRGG
                BBBB
                RRRR
                """;
        String expected = "4 3";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }

    @Test
    void testCase12_smallRGSeparated() throws IOException {
        String input = """
                2
                RG
                GR
                """;
        String expected = "4 1";
        assertEquals(expected, BOJ_10026.solve(input).strip());
    }
}