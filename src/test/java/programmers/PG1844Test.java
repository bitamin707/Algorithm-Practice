package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PG1844Test {

    @Test
    void testCase1_example() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int expected = 11;
        assertEquals(expected, PG_1844.solution(maps));
    }

    @Test
    void testCase2_blockedPath() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int expected = -1;
        assertEquals(expected, PG_1844.solution(maps));
    }
}
