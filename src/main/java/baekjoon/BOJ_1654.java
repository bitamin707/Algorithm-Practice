package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 랜선 자르기
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/1654
 *
 * 문제 :
 *      - K개의 서로 다른 길이의 랜선을 가지고 있고, N개의 같은 길이 랜선을 만들어야 함
 *      - 기존 랜선을 잘라서 사용 (랜선을 붙일 수 없음)
 *      - N개를 만들 수 있는 랜선의 최대 길이를 구하는 문제
 *      - N개보다 많이 만드는 것도 N개를 만드는 것에 포함됨
 *
 * 입력 :
 *      - 첫째 줄: 가지고 있는 랜선의 개수 K(1≤K≤10,000), 필요한 랜선의 개수 N(1≤N≤1,000,000)
 *      - 둘째 줄부터 K줄: 각 랜선의 길이 (1이상 2^31-1이하 자연수)
 *      - 항상 K ≤ N 이며, K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없음
 *
 * 출력 :
 *      - N개를 만들 수 있는 랜선의 최대 길이 (센티미터 단위의 정수)
 *
 * 문제 풀이 :
 *      - 이분 탐색을 활용한 문제
 *      - 탐색 범위: 1부터 가장 긴 랜선의 길이까지
 *      - mid 길이로 잘랐을 때 나오는 랜선의 개수를 계산
 *      - 개수가 N개 이상이면 더 긴 길이로 시도, N개 미만이면 더 짧은 길이로 시도
 *      - N개 이상의 경우에도 최대값을 갱신하며 계속 탐색해야 함
 */

public class BOJ_1654 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int maxLength = 0;

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, num);
            arr[i] = num;
        }

        long result = binarySearch(arr, N, maxLength);

        System.out.println(result);
        return String.valueOf(result);
    }

    private static long binarySearch(int[] arr, int n, long max) {
        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int length : arr)
                count += length / mid;

            if (count >= n) {
                result = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}