package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ21736Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                3 5
                OOOPO
                OIOOX
                OOOXP
                """;
        String expected = "1";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase2_noFriends() throws IOException {
        String input = """
                3 3
                OXO
                XIP
                OXO
                """;
        String expected = "TT";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase3_multipleFriends() throws IOException {
        String input = """
                4 4
                PPOO
                POOO
                OOIO
                OOPP
                """;
        String expected = "3";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase4_allConnected() throws IOException {
        String input = """
                2 3
                IPP
                OOO
                """;
        String expected = "2";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase5_isolatedFriend() throws IOException {
        String input = """
                3 4
                IOOO
                XXXX
                OOPP
                """;
        String expected = "TT";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase6_singleCell() throws IOException {
        String input = """
                1 1
                I
                """;
        String expected = "TT";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase7_complexPath() throws IOException {
        String input = """
                5 5
                XPXPX
                XOXOX
                POXOP
                XOXOX
                XPXIX
                """;
        String expected = "2";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }

    @Test
    void testCase8_largeMaze() throws IOException {
        String input = """
                4 6
                PPOOOX
                OOOXOX
                OXIOOX
                PPOOOX
                """;
        String expected = "4";
        assertEquals(expected, BOJ_21736.solve(input).strip());
    }
}