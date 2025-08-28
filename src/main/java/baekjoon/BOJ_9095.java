package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 1, 2, 3 더하기
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/9095
 *
 * 문제 :
 *      - 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수 구하기
 *      - 합을 나타낼 때는 수를 1개 이상 사용해야 함
 *      - 순서가 다른 경우는 서로 다른 것으로 취급 (1+2 ≠ 2+1)
 *      - 예: 4 = 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1 (총 7가지)
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스의 개수 T
 *      - 각 테스트 케이스: 정수 n (n은 양수이며 11보다 작음, 1 ≤ n ≤ 10)
 *
 * 출력 :
 *      - 각 테스트 케이스마다 n을 1, 2, 3의 합으로 나타내는 방법의 수 출력
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 문제
 *      - 점화식: dp[n] = dp[n-1] + dp[n-2] + dp[n-3] (n ≥ 4)
 *      - 초기값: dp[1]=1, dp[2]=2, dp[3]=4
 *      - n에서 1을 뺀 경우 + n에서 2를 뺀 경우 + n에서 3을 뺀 경우의 합
 *      - 알고리즘: DP, 조합론
 */

public class BOJ_9095 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            int[] dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            if (num >= 4)
                for (int j = 4; j <= num; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }

            sb.append(dp[num]).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}