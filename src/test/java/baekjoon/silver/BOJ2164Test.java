package baekjoon.silver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("카드2")
class BOJ2164Test {

    @Test
    void testCard2_case1() {
        int input = 6;
        int expected = 4;
        assertEquals(expected, BOJ_2164.solve(input));
    }

    @Test
    void testCard2_case2() {
        int input = 1;
        int expected = 1;
        assertEquals(expected, BOJ_2164.solve(input));
    }

    @Test
    void testCard2_case3() {
        int input = 10;
        int expected = 4;
        assertEquals(expected, BOJ_2164.solve(input));
    }
}