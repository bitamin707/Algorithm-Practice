package baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("프린터 큐")
public class BOJ1966Test {

    @Test
    void testCase1() {
        int result = BOJ_1966.solve(1, 0, new int[]{5});
        assertEquals(1, result);
    }

    @Test
    void testCase2() {
        int result = BOJ_1966.solve(4, 2, new int[]{1, 2, 3, 4});
        assertEquals(2, result);
    }

    @Test
    void testCase3() {
        int result = BOJ_1966.solve(6, 0, new int[]{1, 1, 9, 1, 1, 1});
        assertEquals(5, result);
    }
}
