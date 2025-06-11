package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1620Test {

    @Test
    void testCase1() throws IOException {
        String input = """
                26 5
                Bulbasaur
                Ivysaur
                Venusaur
                Charmander
                Charmeleon
                Charizard
                Squirtle
                Wartortle
                Blastoise
                Caterpie
                Metapod
                Butterfree
                Weedle
                Kakuna
                Beedrill
                Pidgey
                Pidgeotto
                Pidgeot
                Rattata
                Raticate
                Spearow
                Fearow
                Ekans
                Arbok
                Pikachu
                Raichu
                25
                Raichu
                3
                Pidgey
                Kakuna
                """;

        String expected = """
                Pikachu
                26
                Venusaur
                16
                14
                """;

        assertEquals(expected, BOJ_1620.solve(input));
    }
}
