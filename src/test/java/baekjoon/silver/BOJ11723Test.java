package baekjoon.silver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ11723Test {

    @Test
    void testCase1() throws IOException {
        String input = """
                26
                add 1
                add 2
                check 1
                check 2
                check 3
                remove 2
                check 1
                check 2
                toggle 3
                check 1
                check 2
                check 3
                check 4
                all
                check 10
                check 20
                toggle 10
                remove 20
                check 10
                check 20
                empty
                check 1
                toggle 1
                check 1
                toggle 1
                check 1
                """;

        String expected = """
                1
                1
                0
                1
                0
                1
                0
                1
                0
                1
                1
                0
                0
                0
                1
                0
                """;

        assertEquals(expected, BOJ_11723.solve(input));
    }

    @Test
    void testCase2_allEmptyToggle() throws IOException {
        String input = """
                6
                all
                toggle 1
                toggle 1
                empty
                check 1
                check 20
                """;
        String expected = """
                0
                0
                """;
        assertEquals(expected, BOJ_11723.solve(input));
    }

    @Test
    void testCase3_basicAddRemove() throws IOException {
        String input = """
                4
                add 5
                check 5
                remove 5
                check 5
                
                """;
        String expected = """
                1
                0
                """;
        assertEquals(expected, BOJ_11723.solve(input));
    }
}
