package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PG12906Test {

    @Test
    void testSample(){
        int[] input = {1,1,3,3,0,1,1};
        int[] expected = {1,3,0,1};
        assertArrayEquals(expected, new PG_12906().solution(input));
    }

    @Test
    void testSample2(){
        int[] input = {4,4,4,3,3};
        int[] expected = {4,3};
        assertArrayEquals(expected, new PG_12906().solution(input));
    }
}