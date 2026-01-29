package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 홀수로 나누기
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/32711
 * <p>
 * 문제 :
 * - 양의 정수로 이루어진 길이 N의 수열 A를 한 개 이상의 연속된 부분 수열로 나눔.
 * - 각 부분 수열의 합은 홀수여야 함.
 * - 부분 수열의 개수가 홀수개가 되도록 나누는 것이 가능한지 판별.
 * <p>
 * 입력 :
 * - 첫째 줄에 수열의 길이 N이 주어짐.
 * - 둘째 줄에 수열 A의 원소 A_1, A_2, ..., A_N이 공백으로 구분되어 주어짐.
 * <p>
 * 출력 :
 * - 조건을 만족하도록 나눌 수 있으면 1, 없으면 0을 출력.
 * <p>
 * 문제 풀이 :
 * - 전체 합이 홀수인 경우: 1개로 나누면 되므로 항상 가능 (1).
 * - 전체 합이 짝수인 경우:
 * 1. 홀수 원소가 2개 이상이고, 양 끝을 제외한 부분에서 적절히 나눠 홀수개의 덩어리를 만들 수 있는지 확인.
 * 2. 또는 모든 원소가 짝수인 경우 등 불가능한 케이스 판별.
 */
public class BOJ_32711 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        long sum = 0;
        int oddCount = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] % 2 != 0)
                oddCount++;
        }

        if (sum % 2 != 0) {
            System.out.println(1);
            return String.valueOf(1);
        }

        if (N == 1) {
            System.out.println(0);
            return String.valueOf(0);
        }

        if (oddCount == 0 || oddCount >= 4) {
            System.out.println(1);
            return String.valueOf(1);
        }

        int leftNum = arr[0];
        int rightNum = arr[N - 1];

        if (leftNum % 2 != 0 && rightNum % 2 != 0) {
            System.out.println(0);
            return String.valueOf(0);
        } else if (leftNum % 2 == 0 && rightNum % 2 == 0) {
            System.out.println(0);
            return String.valueOf(0);
        } else {
            System.out.println(1);
            return String.valueOf(1);
        }
    }

    public static void main(String[] args) {

    }
}