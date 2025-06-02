package programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("크레인 인형뽑기 게임")
class PG64061Test {
    PG_64061 solver = new PG_64061();

    @Test
    void sampleTest() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        assertEquals(4, solver.solution(board, moves));
    }

    @Test
    void emptyBoardTest() {
        int[][] board = new int[5][5];
        int[] moves = {1, 2, 3, 4, 5};
        assertEquals(0, solver.solution(board, moves));
    }
}
