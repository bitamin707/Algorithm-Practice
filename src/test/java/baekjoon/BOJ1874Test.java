package baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("스택 수열")
class BOJ1874Test {

    @Test
    void testCase_possible() throws IOException {
        String input = "8\n4\n3\n6\n8\n7\n5\n2\n1";
        String expected = String.join("\n",
                "+", "+", "+", "+", "-", "-",
                "+", "+", "-", "+", "+", "-",
                "-", "-", "-", "-"
        );
        assertEquals(expected, BOJ_1874.solve(input));
    }

    @Test
    void testCase_impossible() throws IOException {
        String input = "5\n1\n2\n5\n3\n4";
        String expected = "NO";
        assertEquals(expected, BOJ_1874.solve(input));
    }

    @Test
    void testCase_ascending() throws IOException {
        String input = "5\n1\n2\n3\n4\n5";
        String expected = String.join("\n",
                "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"
        );
        assertEquals(expected, BOJ_1874.solve(input));
    }

    @Test
    void testCase_descending() throws IOException {
        String input = "5\n5\n4\n3\n2\n1";
        String expected = String.join("\n",
                "+", "+", "+", "+", "+", "-", "-", "-", "-", "-"
        );
        assertEquals(expected, BOJ_1874.solve(input));
    }
}