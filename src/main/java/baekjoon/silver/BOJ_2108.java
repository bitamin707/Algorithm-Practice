package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 통계학
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/2108
 *
 * 문제 :
 * - N개의 수가 주어졌을 때, 네 가지 통계값을 구하시오.
 * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값 (소수점 이하 첫째 자리에서 반올림)
 * 2. 중앙값 : N개의 수들을 크기 순서대로 나열했을 경우 그 중앙에 위치하는 값
 * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값 (여러 개 있을 때 최빈값 중 두 번째로 작은 값)
 * 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 *
 * 입력 :
 * - 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. (N은 홀수)
 * - 그 다음 N개의 줄에는 정수들이 주어진다. (|정수| ≤ 4,000)
 *
 * 출력 :
 * - 첫째 줄에는 산술평균 출력
 * - 둘째 줄에는 중앙값 출력
 * - 셋째 줄에는 최빈값 출력
 * - 넷째 줄에는 범위 출력
 */

public class BOJ_2108 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            arr[i] = n;
            map.put(n, map.getOrDefault(n, 0) + 1);
            count = Math.max(count, map.get(n));
        }
        sb.append(Math.round((double) sum / N)).append("\n"); // 1.산술 평균

        Arrays.sort(arr);
        sb.append(arr[N / 2]).append("\n"); // 2.중앙값

        List<Integer> list = new ArrayList<>();
        for (int n : map.keySet()) {
            if (map.get(n) == count)
                list.add(n);
        }
        Collections.sort(list);
        sb.append(list.size() > 1 ? list.get(1) : list.get(0)).append("\n"); // 3.최빈값

        sb.append(arr[N - 1] - arr[0]).append("\n"); // 4.범위

        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
