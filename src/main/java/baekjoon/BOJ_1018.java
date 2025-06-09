package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 체스판 다시 칠하기
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/1018
 *
 * 문제 : M×N 보드에서 8×8 크기의 체스판을 잘라낸 뒤 흰색(W)과 검정색(B)이 번갈아 나오는 체스판으로 만들기 위해
 *       최소 몇 개의 칸을 다시 칠해야 하는지를 구하는 문제
 *
 * 입력 :
 *      - 첫째 줄에 N과 M이 주어진다. (8 ≤ N, M ≤ 50)
 *      - 둘째 줄부터 N개의 줄에 보드의 각 행이 문자열로 주어진다.
 *      - 각 문자는 'W' 또는 'B'로 이루어져 있다.
 *
 * 출력 :
 *      - 보드에서 8×8 크기를 잘라 만들 수 있는 체스판 중 다시 칠해야 하는 칸의 개수의 최솟값을 출력한다.
 *
 * 문제 풀이 :
 *      - 보드의 모든 가능한 8x8 부분 보드를 순회하면서 검사
 *      - 각 8x8 보드에 대해 시작 색이 'W' 또는 'B'인 두 경우 모두 고려
 *          - (i + j) % 2 == 0인 위치는 시작 색
 *          - (i + j) % 2 == 1인 위치는 반대 색
 *      - 현재 보드 상태와 비교하여 바꿔야 할 칸 수 계산
 *      - 두 경우 중 더 적은 값을 선택
 *      - 전체 보드에서 가능한 모든 8x8에 대해 위 과정을 반복하고, 그 중 최소값을 반환
 */

public class BOJ_1018 {

    public static int solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < board.length - 7; i++) {
            for (int j = 0; j < board[0].length - 7; j++) {
                minCount = Math.min(minCount, CheckBoard(board, i, j));
            }
        }

        // System.out.print(minCount);
        return minCount;
    }

    private static int CheckBoard(char[][] board, int minRow, int minCol) {
        int whiteStart = 0, blackStart = 0;

        for (int i = minRow; i < minRow + 8; i++) {
            for (int j = minCol; j < minCol + 8; j++) {
                char c = board[i][j];
                if ((i + j) % 2 == 0) {
                    if (c != 'W') whiteStart++;
                    if (c != 'B') blackStart++;
                } else {
                    if (c != 'W') blackStart++;
                    if (c != 'B') whiteStart++;
                }
            }
        }
        return Math.min(whiteStart, blackStart);
    }

    public static void main(String[] args) {
    }
}
