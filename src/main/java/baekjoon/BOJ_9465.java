package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 스티커
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/9465
 *
 * 문제 :
 *      - 2행 n열로 배치된 스티커가 있다
 *      - 한 스티커를 떼면 상하좌우 인접한 스티커는 모두 사용할 수 없다
 *      - 각 스티커에는 점수가 있으며, 점수의 합이 최대가 되도록 스티커를 떼어야 한다
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스 개수 T
 *      - 각 테스트 케이스마다:
 *        * 첫째 줄: n (1 ≤ n ≤ 100,000)
 *        * 둘째 줄: 첫 번째 행의 스티커 점수 n개
 *        * 셋째 줄: 두 번째 행의 스티커 점수 n개
 *      - 각 스티커의 점수는 0 이상 100 이하의 정수
 *
 * 출력 :
 *      - 각 테스트 케이스마다 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값 출력
 *
 * 문제 풀이 :
 *      - DP를 활용한 문제
 *      - dp[i][j] = i번째 행, j번째 열까지 고려했을 때 얻을 수 있는 최대 점수
 *      - 현재 스티커를 선택하면 대각선 방향이나 2칸 이전 대각선에서 올 수 있다
 *      - 점화식: dp[i][j] = max(dp[반대행][j-1], dp[반대행][j-2]) + arr[i][j]
 */

public class BOJ_9465 {
    static int[][] matrix;
    static int[][] dp;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            matrix = new int[2][N + 1];
            dp = new int[2][N + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++)
                    matrix[j][k] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = matrix[0][1];
            dp[1][1] = matrix[1][1];

            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + matrix[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + matrix[1][j];
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
