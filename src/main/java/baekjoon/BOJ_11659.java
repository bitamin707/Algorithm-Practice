package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 구간 합 구하기 4
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/11659
 *
 * 문제 :
 *      - 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지의 합을 구하는 프로그램
 *      - M개의 구간에 대해 각각 구간 합을 구해야 함
 *      - 단순 반복문으로는 시간 초과 발생 (O(NM) → 최대 10^10)
 *
 * 입력 :
 *      - 첫째 줄: 수의 개수 N, 합을 구해야 하는 횟수 M (1 ≤ N, M ≤ 100,000)
 *      - 둘째 줄: N개의 수 (1,000보다 작거나 같은 자연수)
 *      - 셋째 줄부터 M개 줄: 구간 i, j (1 ≤ i ≤ j ≤ N)
 *
 * 출력 :
 *      - 총 M개의 줄에 각 구간의 합을 출력
 *
 * 문제 풀이 :
 *      - 누적 합(Prefix Sum) 알고리즘 사용
 *      - prefixSum[i] = 1번째부터 i번째까지의 합
 *      - 구간 [i, j]의 합 = prefixSum[j] - prefixSum[i-1]
 *      - 시간 복잡도: O(N + M) (전처리 O(N) + 쿼리 처리 O(1) × M)
 *      - 알고리즘: 누적 합, DP
 */

public class BOJ_11659 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefixSum = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            prefixSum[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
