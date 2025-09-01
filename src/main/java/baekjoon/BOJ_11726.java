package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 2×n 타일링
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/11726
 *
 * 문제 :
 *      - 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수 구하기
 *      - 1×2 타일: 가로가 2, 세로가 1인 타일 (가로 타일)
 *      - 2×1 타일: 가로가 1, 세로가 2인 타일 (세로 타일)
 *      - 결과를 10,007로 나눈 나머지 출력
 *
 * 입력 :
 *      - 첫째 줄: n (1 ≤ n ≤ 1,000)
 *
 * 출력 :
 *      - 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 문제
 *      - 점화식: dp[n] = dp[n-1] + dp[n-2] (n ≥ 3)
 *      - 초기값: dp[1] = 1, dp[2] = 2
 *      - n번째 열을 채우는 방법: (n-1)에 세로 타일 1개 추가 + (n-2)에 가로 타일 2개 추가
 *      - 피보나치 수열과 동일한 형태 (시작값이 1, 2)
 *      - 알고리즘: DP, 피보나치 수열
 */

public class BOJ_11726 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i == 1)
                arr[i] = 1;
            else if (i == 2)
                arr[i] = 2;
            else
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[N]);
        return String.valueOf(arr[N]);
    }

    public static void main(String[] args) {
    }
}
