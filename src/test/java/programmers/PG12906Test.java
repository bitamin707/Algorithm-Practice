package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("같은 숫자는 싫어")
class PG12906Test {

    @Test
    void testSample(){
        int[] input = {1,1,3,3,0,1,1};
        int[] expected = {1,3,0,1};
        Assertions.assertArrayEquals(expected, new PG_12906().solution(input));
    }

    @Test
    void testSample2(){
        int[] input = {4,4,4,3,3};
        int[] expected = {4,3};
        assertArrayEquals(expected, new PG_12906().solution(input));
    }
}