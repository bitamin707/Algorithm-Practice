package programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("더 맵게")
class PG42626Test {

    @Test
    void testCase1_basic() {
        int K = 7;
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int expected = 2;
        assertEquals(expected, new PG_42626().solution(scoville, K));
    }

    @Test
    void testCase2_impossible() {
        int K = 10;
        int[] scoville = {1, 1, 1};
        int expected = -1;
        assertEquals(expected, new PG_42626().solution(scoville, K));
    }

    @Test
    void testCase3_alreadySatisfied() {
        int K = 5;
        int[] scoville = {10, 20, 30};
        int expected = 0;
        assertEquals(expected, new PG_42626().solution(scoville, K));
    }
}