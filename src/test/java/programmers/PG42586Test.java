package programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("기능개발")
class PG42586Test {

    @Test
    void testFeatureDevelopment_case1() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] expected = {2, 1};
        assertArrayEquals(expected, new PG_42586().solution(progresses, speeds));
    }

    @Test
    void testFeatureDevelopment_case2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] expected = {1, 3, 2};
        assertArrayEquals(expected, new PG_42586().solution(progresses, speeds));
    }

    @Test
    void testFeatureDevelopment_case3() {
        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 30, 5};
        int[] expected = {3, 3};
        assertArrayEquals(expected, new PG_42586().solution(progresses, speeds));
    }
}