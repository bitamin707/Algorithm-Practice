package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ1541Test {

    @Test
    void testCase1_problemExample1() throws IOException {
        String input = "55-50+40";
        String expected = "-35".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase2_problemExample2() throws IOException {
        String input = "10+20+30+40";
        String expected = "100".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase3_problemExample3() throws IOException {
        String input = "00009-00009";
        String expected = "0".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase4_singleNumber() throws IOException {
        String input = "1";
        String expected = "1".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase5_onlyPlus() throws IOException {
        String input = "1+2";
        String expected = "3".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase6_onlyMinus() throws IOException {
        String input = "3-2";
        String expected = "1".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase7_complexCase() throws IOException {
        String input = "5-4+6-2";
        String expected = "-7".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase8_multipleMinuses() throws IOException {
        String input = "10-5+3-1+4";
        String expected = "-3".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase9_leadingZeros() throws IOException {
        String input = "001+002-003";
        String expected = "0".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }

    @Test
    void testCase10_largeNumbers() throws IOException {
        String input = "12345-6789+1000";
        String expected = "4556".strip();
        assertEquals(expected, BOJ_1541.solve(input).strip());
    }
}