package baekjoon.gold;

import java.io.*;

/**
 * 제목: LCS (Longest Common Subsequence)
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/9251
 *
 * 문제 :
 *      - LCS(최장 공통 부분 수열) 문제는 두 수열이 주어졌을 때,
 *        모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
 *      - 부분 수열은 연속적일 필요가 없음
 *      - 예: ACAYKP와 CAPCAK의 LCS는 ACAK (길이 4)
 *
 * 입력 :
 *      - 첫째 줄: 첫 번째 문자열
 *      - 둘째 줄: 두 번째 문자열
 *      - 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자
 *
 * 출력 :
 *      - 첫째 줄: 입력으로 주어진 두 문자열의 LCS의 길이
 *
 * 문제 풀이 :
 *      - 2차원 DP를 사용하는 전형적인 LCS 문제
 *      - dp[i][j] = 첫 번째 문자열의 i번째까지, 두 번째 문자열의 j번째까지의 LCS 길이
 *      - 점화식:
 *        * str1[i-1] == str2[j-1]인 경우: dp[i][j] = dp[i-1][j-1] + 1
 *          (문자가 같으면 이전 LCS 길이 + 1)
 *        * str1[i-1] != str2[j-1]인 경우: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 *          (문자가 다르면 위쪽 또는 왼쪽 중 최댓값)
 */

public class BOJ_9251 {
    static char[] arrStr1, arrStr2;
    static int[][] dp;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        arrStr1 = new char[str1.length()];
        arrStr2 = new char[str2.length()];
        dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length(); i++)
            arrStr1[i] = str1.charAt(i);
        for (int i = 0; i < str2.length(); i++)
            arrStr2[i] = str2.charAt(i);

        int result = longestCommonSubsequence();
        System.out.println(result);
        return String.valueOf(result);
    }

    private static int longestCommonSubsequence() {
        for (int i = 1; i <= arrStr1.length; i++) {
            for (int j = 1; j <= arrStr2.length; j++) {
                if (arrStr1[i - 1] == arrStr2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[arrStr1.length][arrStr2.length];
    }

    public static void main(String[] args) {
    }
}