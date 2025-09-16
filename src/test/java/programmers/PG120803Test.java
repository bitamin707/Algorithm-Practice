package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PG120803Test {

    @Test
    void testCase1_example1() {
        int result = PG_120803.solution(2, 3);
        assertEquals(-1, result);
    }

    @Test
    void testCase2_example2() {
        int result = PG_120803.solution(100, 2);
        assertEquals(98, result);
    }

    @Test
    void testCase3_positiveNumbers() {
        int result = PG_120803.solution(10, 5);
        assertEquals(5, result);
    }

    @Test
    void testCase4_negativeNumbers() {
        int result = PG_120803.solution(-10, -5);
        assertEquals(-5, result);
    }

    @Test
    void testCase5_mixedNumbers() {
        int result = PG_120803.solution(-10, 5);
        assertEquals(-15, result);
    }

    @Test
    void testCase6_sameNumbers() {
        int result = PG_120803.solution(7, 7);
        assertEquals(0, result);
    }

    @Test
    void testCase7_zeroFirst() {
        int result = PG_120803.solution(0, 5);
        assertEquals(-5, result);
    }

    @Test
    void testCase8_zeroSecond() {
        int result = PG_120803.solution(5, 0);
        assertEquals(5, result);
    }

    @Test
    void testCase9_bothZero() {
        int result = PG_120803.solution(0, 0);
        assertEquals(0, result);
    }

    @Test
    void testCase10_largeNumbers() {
        int result = PG_120803.solution(50000, -50000);
        assertEquals(100000, result);
    }

    @Test
    void testCase11_minBoundary() {
        int result = PG_120803.solution(-50000, 50000);
        assertEquals(-100000, result);
    }

    @Test
    void testCase12_maxBoundary() {
        int result = PG_120803.solution(50000, 50000);
        assertEquals(0, result);
    }
}