package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PG43165Test {

    @Test
    void testCase1_example() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        assertEquals(expected, PG_43165.solution(numbers, target));
    }

    @Test
    void testCase2_customCase() {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int expected = 2;
        assertEquals(expected, PG_43165.solution(numbers, target));
    }
}
