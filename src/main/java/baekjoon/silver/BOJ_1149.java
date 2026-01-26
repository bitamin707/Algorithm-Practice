package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: RGB거리
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1149
 *
 * 문제 :
 *      - N개의 집을 빨강(R), 초록(G), 파랑(B) 중 하나의 색으로 칠하기
 *      - 인접한 집은 같은 색이면 안됨
 *      - 모든 집을 칠하는 비용의 최솟값 구하기
 *
 * 입력 :
 *      - 첫째 줄: 집의 수 N (2 ≤ N ≤ 1,000)
 *      - 둘째 줄~N개 줄: 각 집을 R, G, B로 칠하는 비용 (1 ≤ 비용 ≤ 1,000)
 *
 * 출력 :
 *      - 모든 집을 칠하는 비용의 최솟값
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 문제
 *      - dp[i][j] = i번째 집을 j색으로 칠했을 때, 1~i번째 집을 칠하는 최소 비용
 *      - dp[i][R] = min(dp[i-1][G], dp[i-1][B]) + cost[i][R]
 *      - dp[i][G] = min(dp[i-1][R], dp[i-1][B]) + cost[i][G]
 *      - dp[i][B] = min(dp[i-1][R], dp[i-1][G]) + cost[i][B]
 *      - 최종 답: min(dp[N][R], dp[N][G], dp[N][B])
 */

public class BOJ_1149 {
    static int[][] matrix;
    static int[][] dp;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];

        int result = Math.min(calculate(N - 1, 0), Math.min(calculate(N - 1, 1), calculate(N - 1, 2)));

        System.out.println(result);
        return String.valueOf(result);
    }

    private static int calculate(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == 0) {
                dp[n][0] = Math.min(calculate(n - 1, 1), calculate(n - 1, 2)) + matrix[n][0];
            } else if (color == 1) {
                dp[n][1] = Math.min(calculate(n - 1, 0), calculate(n - 1, 2)) + matrix[n][1];
            } else if (color == 2) {
                dp[n][2] = Math.min(calculate(n - 1, 0), calculate(n - 1, 1)) + matrix[n][2];
            }
        }
        return dp[n][color];
    }

    public static void main(String[] args) {
    }
}
