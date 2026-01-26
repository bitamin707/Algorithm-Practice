package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: Z
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1074
 *
 * 문제 :
 *      - 크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색
 *      - 2×2 배열: 왼쪽 위 → 오른쪽 위 → 왼쪽 아래 → 오른쪽 아래 순서
 *      - N > 1일 경우: 배열을 4등분하여 재귀적으로 Z 순서대로 방문
 *      - r행 c열을 몇 번째로 방문하는지 출력
 *
 * 입력 :
 *      - 첫째 줄: 정수 N, r, c (1 ≤ N ≤ 15, 0 ≤ r, c < 2^N)
 *
 * 출력 :
 *      - r행 c열을 몇 번째로 방문했는지 출력 (0-indexed)
 *
 * 문제 풀이 :
 *      - 분할정복(Divide and Conquer) 사용
 *      - 목표 위치(r,c)가 있는 사분면만 재귀적으로 탐색
 *      - 다른 사분면은 건너뛰고 해당 사분면의 크기만큼 카운트 추가
 *      - Z 순서: 1사분면(좌상) → 2사분면(우상) → 3사분면(좌하) → 4사분면(우하)
 */

public class BOJ_1074 {
    static int count = 0;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Z((int)Math.pow(2, N),r, c);

        System.out.println(count);
        return String.valueOf(count);
    }

    private static void Z(int n, int r, int c) {
        if (n == 1)
            return;

        int half = n / 2;
        if (r < half && c < half)
            Z(half, r, c);
        else if (r < half && c < half + half) {
            count += half * half;
            Z(n, r, c - half);
        } else if (r < half + half && c < half) {
            count += half * half * 2;
            Z(half, r - half, c);
        } else {
            count += half * half * 3;
            Z(n, r - half, c - half);
        }
    }

    public static void main(String[] args) {
    }
}
