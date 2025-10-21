package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 정수 삼각형
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1932
 *
 * 문제 :
 *      - 정수 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중 최댓값 찾기
 *      - 아래층으로 내려갈 때는 대각선 왼쪽 또는 대각선 오른쪽만 선택 가능
 *      - 즉, [i][j]에서 [i+1][j] 또는 [i+1][j+1]로만 이동 가능
 *
 * 입력 :
 *      - 첫째 줄: 삼각형의 크기 n (1 ≤ n ≤ 500)
 *      - 둘째 줄~n+1번째 줄: 정수 삼각형 (0 ≤ 수 ≤ 9999)
 *
 * 출력 :
 *      - 합이 최대가 되는 경로의 합
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 문제
 *      - dp[i][j] = [i][j]에서 시작하여 바닥까지 내려갈 때의 최대 합
 */

public class BOJ_1932 {
    static int[][] matrix;
    static int[][] dp;
    static boolean[][] visit;
    static int N;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        dp = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                if (st.hasMoreTokens())
                    matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = solve(0, 0);

        System.out.println(result);
        return String.valueOf(result);
    }

    private static int solve(int x, int y) {
        if (x == N - 1)
            return matrix[x][y];

        if (visit[x][y])
            return dp[x][y];

        visit[x][y] = true;

        int left = solve(x + 1, y);
        int right = solve(x + 1, y + 1);

        dp[x][y] = matrix[x][y] + Math.max(left, right);
        return dp[x][y];
    }

    public static void main(String[] args) {
    }
}
