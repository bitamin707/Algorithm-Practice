package baekjoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BOJ11866Test {

    @Test
    void testSampleInput() {
        String result = BOJ_11866.solve(7, 3);
        Assertions.assertEquals("<3, 6, 2, 7, 5, 1, 4>", result);
    }
}
