package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ9251Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                ACAYKP
                CAPCAK
                """;
        String expected = "4";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase2_identicalStrings() throws IOException {
        String input = """
                ABCDEF
                ABCDEF
                """;
        String expected = "6";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase3_noCommonSubsequence() throws IOException {
        String input = """
                ABC
                DEF
                """;
        String expected = "0";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase4_singleCharacterMatch() throws IOException {
        String input = """
                ABCD
                EFGA
                """;
        String expected = "1";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase5_oneCharacterStrings() throws IOException {
        String input = """
                A
                A
                """;
        String expected = "1";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase6_differentLengths() throws IOException {
        String input = """
                ABCDEFG
                BDF
                """;
        String expected = "3";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase7_reverseStrings() throws IOException {
        String input = """
                ABCDE
                EDCBA
                """;
        String expected = "1";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase8_repeatingCharacters() throws IOException {
        String input = """
                AAAA
                AA
                """;
        String expected = "2";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase9_complexPattern() throws IOException {
        String input = """
                AGGTAB
                GXTXAYB
                """;
        String expected = "4";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase10_longCommonSubsequence() throws IOException {
        String input = """
                ABCDGH
                AEDFHR
                """;
        String expected = "3";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase11_partialOverlap() throws IOException {
        String input = """
                XMJYAUZ
                MZJAWXU
                """;
        String expected = "4";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }

    @Test
    void testCase12_allSameCharacter() throws IOException {
        String input = """
                AAA
                AAA
                """;
        String expected = "3";
        assertEquals(expected, BOJ_9251.solve(input).strip());
    }
}