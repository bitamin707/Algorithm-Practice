package baekjoon;

import java.io.*;

/**
 * 제목: 적록색약
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/10026
 *
 * 문제 :
 *      - N×N 그리드에 R(빨강), G(초록), B(파랑) 중 하나가 칠해져 있음
 *      - 같은 색상이 상하좌우로 인접한 경우 같은 구역에 속함
 *      - 적록색약인 사람은 R과 G를 구분하지 못함 (같은 색으로 인식)
 *      - 적록색약이 아닌 사람과 적록색약인 사람이 보는 구역의 수를 각각 구하기
 *
 * 입력 :
 *      - 첫째 줄: N (1 ≤ N ≤ 100)
 *      - 둘째 줄부터 N개 줄: 각 줄에 N개의 문자 (R, G, B)
 *
 * 출력 :
 *      - 적록색약이 아닌 사람이 본 구역의 수와 적록색약인 사람이 본 구역의 수를 공백으로 구분
 *
 * 문제 풀이 :
 *      - DFS를 사용한 연결 요소 개수 구하기
 *      - 1차: 일반인 시각으로 구역 개수 계산 (R, G, B 모두 다른 색)
 *      - 2차: 적록색약 시각으로 구역 개수 계산 (R과 G를 같은 색으로 처리)
 *      - 방법1: G를 R로 바꾸고 다시 탐색
 *      - 방법2: 탐색 조건에서 R과 G를 같은 색으로 처리
 */

public class BOJ_10026 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] matrix;
    static boolean[][] visit;
    static boolean[][] cbVisit;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];
        visit = new boolean[N][N];
        cbVisit = new boolean[N][N];
        int areaCount = 0;
        int cbAreaCount = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++)
                matrix[i][j] = str.charAt(j);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    areaCount++;
                    dfs(i, j, matrix[i][j]);
                }
                if (!cbVisit[i][j]) {
                    cbAreaCount++;
                    cbDfs(i, j, matrix[i][j]);
                }
            }
        }
        sb.append(areaCount).append(" ").append(cbAreaCount);
        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int x, int y, char color) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return;
        if (matrix[x][y] != color || visit[x][y])
            return;

        visit[x][y] = true;
        for (int i = 0; i < dx.length; i++)
            dfs(x + dx[i], y + dy[i], color);
    }

    private static void cbDfs(int x, int y, char color) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return;
        if (cbVisit[x][y])
            return;
        if (!isSameColorForColorBlind(matrix[x][y], color))
            return;

        cbVisit[x][y] = true;
        for (int i = 0; i < dx.length; i++)
            cbDfs(x + dx[i], y + dy[i], color);
    }

    private static boolean isSameColorForColorBlind(char color1, char color2) {
        if (color1 == color2)
            return true;
        return (color1 == 'R' || color1 == 'G') && (color2 == 'R' || color2 == 'G');
    }

    public static void main(String[] args) {
    }
}
