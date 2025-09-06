package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 나무 자르기
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/2805
 *
 * 문제 :
 *      - 상근이는 나무 M미터가 필요함
 *      - 목재절단기로 높이 H를 지정하면 H보다 큰 나무는 H 위의 부분이 잘림
 *      - H보다 낮은 나무는 잘리지 않음
 *      - 적어도 M미터의 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구해야 함
 *
 * 입력 :
 *      - 첫째 줄: 나무의 수 N(1 ≤ N ≤ 1,000,000), 가져가려는 나무의 길이 M(1 ≤ M ≤ 2,000,000,000)
 *      - 둘째 줄: 나무의 높이들 (높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0)
 *      - 나무의 높이의 합은 항상 M보다 크거나 같음 (항상 해결 가능)
 *
 * 출력 :
 *      - 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
 *
 * 문제 풀이 :
 *      - 이분 탐색(Binary Search) 활용 문제
 *      - 탐색 범위: 0부터 가장 높은 나무의 높이까지
 *      - mid 높이로 잘랐을 때 얻을 수 있는 나무의 총 길이 계산
 *      - 총 길이가 M 이상이면 높이를 더 높게 설정 (절단기 높이 증가)
 *      - 총 길이가 M 미만이면 높이를 더 낮게 설정 (절단기 높이 감소)
 *      - 오버플로우 주의: long 타입 사용 필요
 */

public class BOJ_2805 {

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int tallestTree = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            tallestTree = Math.max(tallestTree, tree);
            trees[i] = tree;
        }

        long result = binarySearch(trees, M, tallestTree);

        System.out.println(result);
        return String.valueOf(result);
    }

    private static long binarySearch(int[] trees, int M, int maxLength) {
        int minLength = 1;
        long result = 0;

        while (minLength <= maxLength) {
            int midLength = minLength + (maxLength - minLength) / 2;
            long count = 0;

            for (int tree : trees) {
                count = tree - midLength > 0 ? count + tree - midLength : count;
            }

            if (count >= M) {
                result = midLength;
                minLength = midLength + 1;
            } else
                maxLength = midLength - 1;
        }

        return result;
    }

    public static void main(String[] args) {
    }
}