package baekjoon;

import java.io.*;

/**
 * 제목: 1로 만들기
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/1463
 *
 * 문제 : 정수 X가 주어졌을 때, 세 가지 연산을 사용해 1을 만드는 최소 연산 횟수를 구하는 문제.
 *       가능한 연산:
 *         1) X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *         2) X가 2로 나누어 떨어지면, 2로 나눈다.
 *         3) 1을 뺀다.
 *
 * 입력 :
 *      - 첫째 줄에 정수 X (1 ≤ X ≤ 10^6)
 *
 * 출력 :
 *      - X를 1로 만들기 위한 최소 연산 횟수를 출력한다.
 *
 * 문제 풀이 :
 *      - DP(동적 계획법) 사용
 *      - dp[i] = i를 1로 만드는 최소 연산 횟수
 */

public class BOJ_1463 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[N]);
        return String.valueOf(dp[N]);
    }

    public static void main(String[] args) {

    }
}
