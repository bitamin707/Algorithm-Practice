package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1991Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                7
                A B C
                B D .
                C E F
                E . .
                F . G
                D . .
                G . .
                """;
        String expected = """
                ABDCEFG
                DBAECFG
                DBEGFCA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase2_singleNode() throws IOException {
        String input = """
                1
                A . .
                """;
        String expected = """
                A
                A
                A
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase3_leftOnly() throws IOException {
        String input = """
                3
                A B .
                B C .
                C . .
                """;
        String expected = """
                ABC
                CBA
                CBA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase4_rightOnly() throws IOException {
        String input = """
                3
                A . B
                B . C
                C . .
                """;
        String expected = """
                ABC
                ABC
                CBA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase5_balanced() throws IOException {
        String input = """
                3
                A B C
                B . .
                C . .
                """;
        String expected = """
                ABC
                BAC
                BCA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase6_fullBinaryTree() throws IOException {
        String input = """
                7
                A B C
                B D E
                C F G
                D . .
                E . .
                F . .
                G . .
                """;
        String expected = """
                ABDECFG
                DBEAFGC
                DEBFGCA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase7_complexTree() throws IOException {
        String input = """
                5
                A B C
                B D .
                C . E
                D . .
                E . .
                """;
        String expected = """
                ABDCE
                DBACE
                DBECA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase8_zigzag() throws IOException {
        String input = """
                5
                A B .
                B . C
                C D .
                D . E
                E . .
                """;
        String expected = """
                ABCDE
                BDECA
                EDCBA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase9_allLeftChildren() throws IOException {
        String input = """
                4
                A B .
                B C .
                C D .
                D . .
                """;
        String expected = """
                ABCD
                DCBA
                DCBA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }

    @Test
    void testCase10_mixedStructure() throws IOException {
        String input = """
                6
                A B C
                B . D
                C E .
                D . .
                E F .
                F . .
                """;
        String expected = """
                ABDEFC
                ADBFEC
                DBFECA
                """;
        assertEquals(expected, BOJ_1991.solve(input));
    }
}