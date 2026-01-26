package baekjoon.silver;

import java.io.*;

/**
 * 제목: 피보나치 함수
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/1003
 *
 * 문제 : 다음과 같은 피보나치 수 재귀 호출이 있을 때,
 *       함수 호출 과정에서 0과 1이 각각 몇 번 출력되는지 구하는 문제.
 *
 *      fib(0) = 0을 출력, fib(1) = 1을 출력
 *      fib(n) = fib(n-1) + fib(n-2) (n ≥ 2)
 *
 * 입력 :
 *      - 첫째 줄에 테스트 케이스 개수 T (1 ≤ T ≤ 40)
 *      - 다음 T개의 줄에 정수 N (0 ≤ N ≤ 40)이 주어진다.
 *
 * 출력 :
 *      - 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해 출력
 *
 * 문제 풀이 :
 *      - 재귀 호출을 그대로 시뮬레이션하면 중복 호출로 인해 비효율적 (지수 시간 복잡도 발생)
 *      - DP(동적 계획법)를 사용하여 N에 대한 (0 호출 수, 1 호출 수)를 미리 계산 후 출력
 */

public class BOJ_1003 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1; one[0] = 0; // fib(0)
        zero[1] = 0; one[1] = 1; // fib(1)

        for (int i = 2; i < 41; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(zero[num]).append(" ").append(one[num]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
