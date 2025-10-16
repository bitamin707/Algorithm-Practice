package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 곱셈
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1629
 *
 * 문제 :
 *      - 자연수 A를 B번 곱한 수를 C로 나눈 나머지를 구하기
 *      - (A^B) % C 계산
 *
 * 입력 :
 *      - 첫째 줄: A, B, C (모두 2,147,483,647 이하의 자연수)
 *
 * 출력 :
 *      - A를 B번 곱한 수를 C로 나눈 나머지
 *
 * 문제 풀이 :
 *      - 분할 정복을 이용한 거듭제곱 (Modular Exponentiation)
 *      - 모듈러 연산의 분배법칙: (A * B) % C = ((A % C) * (B % C)) % C
 *      - 분할 정복:
 *        · B가 짝수: A^B = (A^(B/2))^2
 *        · B가 홀수: A^B = (A^(B/2))^2 * A
 */

public class BOJ_1629 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long result = calculate(A, B, C);
        System.out.println(result);
        return String.valueOf(result);
    }

    private static long calculate(long a, long b, long c) {
        if (b == 0)
            return 1;

        if (b == 1)
            return a % c;

        long half = calculate(a, b / 2, c);

        long result = (half * half) % c;

        if (b % 2 == 1)
            result = (result * a) % c;

        return result;
    }

    public static void main(String[] args) {
    }
}
