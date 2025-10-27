package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 구간 합 구하기 5
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/11660
 *
 * 문제 :
 *      - N×N 크기의 표에 수가 채워져 있다
 *      - (x1, y1)부터 (x2, y2)까지의 합을 M번 구해야 한다
 *      - (x, y)는 x행 y열을 의미한다
 *
 * 입력 :
 *      - 첫째 줄: 표의 크기 N, 합을 구해야 하는 횟수 M (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
 *      - 둘째 줄부터 N개의 줄: 표에 채워져 있는 수 (1행부터 차례대로)
 *      - 다음 M개의 줄: 네 개의 정수 x1, y1, x2, y2 (x1 ≤ x2, y1 ≤ y2)
 *      - 표의 각 수는 1,000 이하의 자연수
 *
 * 출력 :
 *      - M개의 줄에 걸쳐 (x1, y1)부터 (x2, y2)까지의 합 출력
 *
 * 문제 풀이 :
 *      - 2차원 누적 합(Prefix Sum) 활용
 *      - prefixSum[i][j] = (1,1)부터 (i,j)까지의 합
 *      - 누적 합 계산: prefixSum[i][j] = prefixSum[i][j-1] + arr[i][j]
 *      - 구간 합 계산: prefixSum[x2][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1][y2] - prefixSum[x1][y1-1]
 */

public class BOJ_11660 {
    static int[][] dp;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(solve(x1, y1, x2, y2)).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    private static int solve(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            sum += dp[i][y2] - dp[i][y1 - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
