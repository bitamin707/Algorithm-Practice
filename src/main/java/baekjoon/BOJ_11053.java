package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 가장 긴 증가하는 부분 수열
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/11053
 *
 * 문제 :
 *      - 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열(LIS)을 구하기
 *      - 부분 수열: 원래 수열에서 일부 원소들을 순서대로 선택한 수열
 *      - 증가하는: 선택된 원소들이 순서대로 증가해야 함
 *      - 예: {10, 20, 10, 30, 20, 50} → {10, 20, 30, 50} (길이 4)
 *
 * 입력 :
 *      - 첫째 줄: 수열 A의 크기 N (1 ≤ N ≤ 1,000)
 *      - 둘째 줄: 수열 A를 이루고 있는 Ai (1 ≤ Ai ≤ 1,000)
 *
 * 출력 :
 *      - 첫째 줄: 수열 A의 가장 긴 증가하는 부분 수열의 길이
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 사용
 *      - dp[i] = i번째 원소를 마지막으로 하는 LIS의 길이
 *      - 점화식: dp[i] = max(dp[j] + 1) (j < i이고 arr[j] < arr[i]인 모든 j)
 *      - 초기값: dp[i] = 1 (모든 원소는 혼자서도 길이 1의 LIS)
 */

public class BOJ_11053 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = dp[0];
        for (int n : dp)
            max = Math.max(max, n);
        System.out.println(max);
        return String.valueOf(max);
    }

    public static void main(String[] args) {
    }
}
