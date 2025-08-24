package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PG43162Test {

    @Test
    void testCase1_example() {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int expected = 2;
        assertEquals(expected, PG_43162.solution(n, computers));
    }

    @Test
    void testCase2_example() {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int expected = 1;
        assertEquals(expected, PG_43162.solution(n, computers));
    }

    @Test
    void testCase3_customCase_disconnected() {
        int n = 4;
        int[][] computers = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        int expected = 4; // 모든 노드가 독립적
        assertEquals(expected, PG_43162.solution(n, computers));
    }
}
