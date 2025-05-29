package programmers;

import java.io.*;
import java.util.*;

/**
 * 제목: 크레인 인형뽑기 게임
 * 난이도: Level 1
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64061
 *
 * 문제 : 2차원 배열 형태의 게임에서 크레인을 이용해 인형을 집어올리고, 같은 인형이 연속되면 터지는 과정을 구현
 *
 * 입력 :
 *      - board는 5 이상 30 이하의 크기를 가진 2차원 배열입니다.
 *      - board의 각 칸에는 0 또는 1 이상 100 이하의 숫자가 들어있습니다. (0은 빈 칸)
 *      - moves는 1 이상 1000 이하의 길이를 가지며, 크레인의 움직임이 담긴 배열입니다.
 *
 * 출력 :
 *      - 크레인으로 인형을 뽑아 터뜨려 사라진 인형의 개수를 return 합니다.
 *
 * 입출력 예 :
 *      - board :
 *           [[0,0,0,0,0],
 *           [0,0,1,0,3],
 *           [0,2,5,0,1],
 *           [4,2,4,4,2],
 *           [3,5,1,3,1]]
 *      - moves : [1,5,3,5,1,2,1,4]
 *      - return : 4
 *
 * 입출력 예 설명 :
 *      - 순서대로 인형을 뽑아 바구니에 넣으면 [4, 3, 1, 1]이 되고 1이 두 개 터짐 → [4, 3]
 *      - 이후 다시 3이 뽑혀서 3이 두 개가 되어 터짐 → [4]
 *      - 총 2쌍(4개)의 인형이 터졌으므로 return 값은 4입니다.
 *
 * 문제 풀이 :
 *      - moves 배열을 순차적으로 처리하면서 각 move가 가리키는 열(move -1)에서
 *      - 위에서부터 처음으로 0이 아닌 값을 찾아 바구니(stack)에 넣는다.
 *      - 바구니에 인형이 연속 두 번 들어오면(= 직전에 넣은 인형과 같다면) 두 인형을 제거하고 정답에 +2 한다.
 *      - 꺼낸 자리는 0으로 바꾼다.
 *      - 최종적으로 사라진 인형의 총 개수를 return 한다.
 *
 */

public class PG_64061 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                int getNum = board[j][col];
                if(getNum != 0) {
                    board[j][col] = 0;
                    if(!stack.isEmpty() && stack.peek() == getNum) {
                        stack.pop();
                        answer += 2;

                    } else {
                        stack.push(getNum);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
