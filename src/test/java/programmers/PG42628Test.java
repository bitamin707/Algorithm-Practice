package programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("이중우선순위큐")
class PG42628Test {

    @Test
    void testCase1_basic() {
        String[] input = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] expected = {0, 0};
        assertArrayEquals(expected, new PG_42628().solution(input));
    }

    @Test
    void testCase2_mixed() {
        String[] input = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] expected = {333, -45};
        assertArrayEquals(expected, new PG_42628().solution(input));
    }

}