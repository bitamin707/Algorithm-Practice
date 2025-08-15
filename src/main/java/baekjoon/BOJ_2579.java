package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 계단 오르기
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/2579
 *
 * 문제 : 계단 아래 시작점에서 계단 꼭대기까지 올라가려고 한다.
 *       계단에는 점수가 있고, 밟은 계단 점수의 합이 최대가 되도록 한다.
 *       단, 계단 오르는 규칙은 다음과 같다:
 *         1) 한 번에 한 계단 또는 두 계단씩 오를 수 있다.
 *         2) 연속된 세 계단을 모두 밟을 수 없다. (즉, 세 계단 연속으로 밟는 것은 금지)
 *         3) 마지막 계단은 반드시 밟아야 한다.
 *
 * 입력 :
 *      - 첫째 줄에 계단의 개수 N (1 ≤ N ≤ 300)
 *      - 둘째 줄부터 N개의 줄에 각 계단의 점수 (1 ≤ 점수 ≤ 10,000)가 순서대로 주어진다.
 *
 * 출력 :
 *      - 얻을 수 있는 점수의 최댓값을 출력한다.
 *
 * 문제 풀이 :
 *      - DP를 사용하여 각 계단까지의 최대 점수를 구한다.
 *      - dp[i] = i번째 계단까지의 최대 점수
 */

public class BOJ_2579 {

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] score = new int[T + 1];
        int[] dp = new int[T + 1];

        for (int i = 1; i <= T; i++)
            score[i] = Integer.parseInt(br.readLine());

        dp[1] = score[1];
        if (T == 1)
            return String.valueOf(dp[T]);

        dp[2] = score[1] + score[2];
        if (T == 2)
            return String.valueOf(dp[T]);

        for(int i = 3; i <= T; i++) {
            // i번째 계단을 밟을 때, (i-2에서 오는 경우) vs (i-3에서 i-1을 밟고 오는 경우)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }
        System.out.println(dp[T]);
        return String.valueOf(dp[T]);
    }

    public static void main(String[] args) {
    }
}
