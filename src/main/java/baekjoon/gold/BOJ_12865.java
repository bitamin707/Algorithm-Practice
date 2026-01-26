package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 평범한 배낭
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/12865
 *
 * 문제 :
 *      - N개의 물건이 있고, 각 물건은 무게 W와 가치 V를 가진다
 *      - 최대 K만큼의 무게만을 넣을 수 있는 배낭이 있다
 *      - 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 구하라
 *      - 각 물건은 쪼갤 수 없다 (넣거나 안 넣거나 두 가지 선택만 가능)
 *
 * 입력 :
 *      - 첫째 줄: 물품의 수 N (1 ≤ N ≤ 100), 버틸 수 있는 무게 K (1 ≤ K ≤ 100,000)
 *      - 둘째 줄부터 N개의 줄: 각 물건의 무게 W (1 ≤ W ≤ 100,000)와 가치 V (0 ≤ V ≤ 1,000)
 *
 * 출력 :
 *      - 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력
 *
 * 문제 풀이 :
 *      - 전형적인 0-1 배낭 문제 (Knapsack Problem)
 *      - 2차원 DP: dp[i][j] = i번째 물건까지 고려하고 배낭 용량이 j일 때 최대 가치
 *      - 점화식:
 *        * 물건을 넣을 수 없는 경우 (w > j): dp[i][j] = dp[i-1][j]
 *        * 물건을 넣을 수 있는 경우 (w ≤ j):
 *          dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
 *          (넣지 않는 경우 vs 넣는 경우 중 최대값)
 *
 */

public class BOJ_12865 {
    static Integer[][] dp;
    static int[] w, v;


    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new Integer[N][K + 1];
        w = new int[N];
        v = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int result = knapsack(N - 1, K);
        System.out.println(result);
        return String.valueOf(result);
    }

    private static int knapsack(int i, int k) {
        if (i < 0) return 0;

        if (dp[i][k] == null) {
            if (w[i] > k) dp[i][k] = knapsack(i - 1, k);
            else dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - w[i]) + v[i]);
        }

        return dp[i][k];
    }

    public static void main(String[] args) {
    }
}
