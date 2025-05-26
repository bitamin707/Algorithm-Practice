package programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class PG42584Test {

    @Test
    void testCase1() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] expected = {4, 3, 1, 1, 0};
        assertArrayEquals(expected, new PG_42584().solution(prices));
    }

    @Test
    void testCase2() {
        int[] prices = {5, 4, 3, 2, 1};
        int[] expected = {1, 1, 1, 1, 0};
        assertArrayEquals(expected, new PG_42584().solution(prices));
    }

    @Test
    void testCase3() {
        int[] prices = {1, 2, 1, 2, 1};
        int[] expected = {4, 1, 2, 1, 0};
        assertArrayEquals(expected, new PG_42584().solution(prices));
    }
}
