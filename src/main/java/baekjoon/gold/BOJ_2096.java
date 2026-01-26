package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 내려가기
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/2096
 *
 * 문제 :
 *      - N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다
 *      - 첫 줄에서 시작해서 마지막 줄에서 끝나는 내려가기 게임
 *      - 다음 줄로 내려갈 때: 바로 아래 또는 바로 아래의 수와 붙어 있는 수로만 이동 가능
 *        * 0번 열: 0번 또는 1번 열로 이동 가능
 *        * 1번 열: 0번, 1번, 2번 열로 이동 가능
 *        * 2번 열: 1번 또는 2번 열로 이동 가능
 *      - 얻을 수 있는 최대 점수와 최소 점수를 구하라
 *
 * 입력 :
 *      - 첫째 줄: N (1 ≤ N ≤ 100,000)
 *      - 다음 N개의 줄: 각 줄마다 세 개의 정수 (0 이상 9 이하)
 *
 * 출력 :
 *      - 첫째 줄: 얻을 수 있는 최대 점수와 최소 점수를 공백으로 구분하여 출력
 *
 * 문제 풀이 :
 *      - 다이나믹 프로그래밍 (DP) 문제
 *      - 점화식:
 *        * maxDP[0] = arr[0] + max(이전maxDP[0], 이전maxDP[1])
 *        * maxDP[1] = arr[1] + max(이전maxDP[0], 이전maxDP[1], 이전maxDP[2])
 *        * maxDP[2] = arr[2] + max(이전maxDP[1], 이전maxDP[2])
 *        * minDP도 동일한 방식으로 min 사용
 */

public class BOJ_2096 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[0][i] = num;
            minDp[0][i] = num;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]) + num;
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]) + num;
                } else if (j == 2) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j - 1]) + num;
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j - 1]) + num;
                } else {
                    maxDp[i][j] = Math.max(Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j]), maxDp[i - 1][j + 1]) + num;
                    minDp[i][j] = Math.min(Math.min(minDp[i - 1][j - 1], minDp[i - 1][j]), minDp[i - 1][j + 1]) + num;
                }
            }
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[N - 1][i]);
            min = Math.min(min, minDp[N - 1][i]);
        }

        sb.append(max).append(" ").append(min);
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}

