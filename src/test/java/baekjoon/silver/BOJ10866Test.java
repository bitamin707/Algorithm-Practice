package baekjoon.silver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("덱")
class BOJ10866Test {
    @Test
    void sampleTest() throws IOException {
        String input = """
                15
                push_back 1
                push_front 2
                front
                back
                size
                empty
                pop_front
                pop_back
                pop_front
                size
                empty
                pop_back
                push_front 3
                empty
                front
                """;
        String expectedOutput = """
                2
                1
                2
                0
                2
                1
                -1
                0
                1
                -1
                0
                3
                """;
        assertEquals(expectedOutput, BOJ_10866.solve(input));
    }

    @Test
    void sampleTest2() throws IOException {
        String input = """
                22
                front
                back
                pop_front
                pop_back
                push_front 1
                front
                pop_back
                push_back 2
                back
                pop_front
                push_front 10
                push_front 333
                front
                back
                pop_back
                pop_back
                push_back 20
                push_back 1234
                front
                back
                pop_back
                pop_back
                """;
        String expectedOutput = """
                -1
                -1
                -1
                -1
                1
                1
                2
                2
                333
                10
                10
                333
                20
                1234
                1234
                20
                """;
        assertEquals(expectedOutput, BOJ_10866.solve(input));
    }
}