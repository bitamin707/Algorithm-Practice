package baekjoon.silver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class BOJ9375Test {

    @Test
    void testCase1_problemExample1() throws IOException {
        String input = """
                2
                3
                hat headgear
                sunglasses eyewear
                turban headgear
                3
                mask face
                sunglasses face
                makeup face
                """;
        String expected = """
                5
                3
                """.strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }

    @Test
    void testCase2_noClothes() throws IOException {
        String input = """
                1
                0
                """;
        String expected = "0".strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }

    @Test
    void testCase3_singleType() throws IOException {
        String input = """
                2
                1
                shirt top
                2
                pants bottom
                shorts bottom
                """;
        String expected = """
                1
                2
                """.strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }

    @Test
    void testCase4_multipleTypes() throws IOException {
        String input = """
                1
                5
                shirt top
                tshirt top
                pants bottom
                skirt bottom
                sneakers shoes
                """;
        String expected = "17".strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }

    @Test
    void testCase5_manyTypes() throws IOException {
        String input = """
                1
                4
                hat headgear
                coat outerwear
                pants bottom
                shoes footwear
                """;
        String expected = "15".strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }

    @Test
    void testCase6_duplicateTypes() throws IOException {
        String input = """
                1
                6
                item1 type1
                item2 type1
                item3 type1
                item4 type2
                item5 type2
                item6 type3
                """;
        String expected = "23".strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }

    @Test
    void testCase7_maxCase() throws IOException {
        String input = """
                1
                3
                a type1
                b type2
                c type3
                """;
        String expected = "7".strip();
        assertEquals(expected, BOJ_9375.solve(input).strip());
    }
}