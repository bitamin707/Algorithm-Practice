package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 테트로미노
 * 난이도: 골드 4
 * 링크: https://www.acmicpc.net/problem/14500
 *
 * 문제 :
 *      - N×M 종이 위에 테트로미노 하나를 놓아서 놓인 칸에 쓰인 수들의 합을 최대로 하기
 *      - 테트로미노: 정사각형 4개를 이어 붙인 폴리오미노 (총 5가지 종류)
 *      - 테트로미노는 회전이나 대칭을 시켜도 됨
 *      - 5가지 테트로미노: I, O, T, S, L 모양
 *
 * 입력 :
 *      - 첫째 줄: 종이의 세로 크기 N과 가로 크기 M (4 ≤ N, M ≤ 500)
 *      - 둘째 줄부터 N개 줄: 종이에 쓰여 있는 수 (각 수는 1,000 이하의 자연수)
 *
 * 출력 :
 *      - 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값
 *
 * 문제 풀이 :
 *      - DFS + 백트래킹: ㅗ 모양을 제외한 나머지는 깊이 4의 DFS로 탐색 가능
 *      - ㅗ 모양 처리: 한 점에서 상하좌우 4방향 중 3방향을 선택하는 모든 경우
 */

public class BOJ_14500 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = Integer.MIN_VALUE;
    static int[][] matrix;
    static boolean[][] visit;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, matrix[i][j], 1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
        return String.valueOf(max);
    }

    private static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length)
                continue;
            if (visit[nx][ny])
                continue;

            visit[nx][ny] = true;

            if (count == 2) {
                // ㅗ 테트로미노 검증을 위해 2번째 칸에서 탐색 진행
                dfs(x, y, sum + matrix[nx][ny], count + 1);
            }

            dfs(nx, ny, sum + matrix[nx][ny], count + 1);

            visit[nx][ny] = false;
        }
    }

    public static void main(String[] args) {
    }
}