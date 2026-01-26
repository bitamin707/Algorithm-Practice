package baekjoon.bronze;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ14626Test {

    @Test
    void testCase4() throws IOException {
        String input = "9788968322*73";
        int expected = 2;
        assertEquals(expected, BOJ_14626.solve(input));
    }
}
