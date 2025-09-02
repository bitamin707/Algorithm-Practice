package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: Four Squares
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/17626
 *
 * 문제 :
 *      - 자연수 n을 최소 개수의 제곱수 합으로 표현하는 프로그램
 *      - 라그랑주의 네 제곱수 정리: 모든 자연수는 4개 이하의 제곱수의 합으로 표현 가능
 *      - 예: 26 = 5² + 1² (2개) 또는 26 = 4² + 3² + 1² (3개) → 최소 2개
 *      - 15663 = 125² + 6² + 1² + 1² (4개)
 *      - 11339 = 105² + 15² + 8² + 5² (4개)
 *
 * 입력 :
 *      - 첫째 줄: 자연수 n (1 ≤ n ≤ 50,000)
 *
 * 출력 :
 *      - n을 최소 개수의 제곱수 합으로 나타낼 때의 제곱수 개수
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 문제
 *      - dp[i] = i를 제곱수의 합으로 나타낼 때 필요한 최소 개수
 *      - 점화식: dp[i] = min(dp[i], dp[i - j²] + 1) (j² ≤ i인 모든 j)
 *      - 초기화: dp[0] = 0, dp[i] = 4 (최악의 경우)
 *      - 알고리즘: DP, 수학 (라그랑주 정리)
 */

public class BOJ_17626 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int num = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++)
                num = Math.min(num, dp[i - j * j] + 1);

            dp[i] = num;
        }

        System.out.println(dp[n]);
        return String.valueOf(dp[n]);
    }

    public static void main(String[] args) {
    }
}
