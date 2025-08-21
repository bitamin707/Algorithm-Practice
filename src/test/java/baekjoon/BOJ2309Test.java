package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ2309Test {

    @Test
    void testCase1_example() throws IOException {
        String input = """
                20
                7
                23
                19
                10
                15
                25
                8
                13
                """;
        String expected = """
                7
                8
                10
                13
                19
                20
                23
                """.strip();
        assertEquals(expected, BOJ_2309.solve(input).strip());
    }

    @Test
    void testCase2_customCase() throws IOException {
        String input = """
                1
                2
                3
                4
                5
                6
                7
                8
                9
                """;
        String expected = """
                1
                2
                3
                4
                5
                6
                9
                """.strip();
        assertEquals(expected, BOJ_2309.solve(input).strip());
    }
}
