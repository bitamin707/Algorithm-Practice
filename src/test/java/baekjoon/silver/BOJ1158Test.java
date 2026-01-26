package baekjoon.silver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class BOJ1158Test {

    @Test
    void testCase1_example() throws IOException {
        String input = "7 3";
        String expected = "<3, 6, 2, 7, 5, 1, 4>".strip();
        assertEquals(expected, BOJ_1158.solve(input).strip());
    }

    @Test
    void testCase2_customCase() throws IOException {
        String input = "5 2";
        String expected = "<2, 4, 1, 5, 3>".strip();
        assertEquals(expected, BOJ_1158.solve(input).strip());
    }
}
