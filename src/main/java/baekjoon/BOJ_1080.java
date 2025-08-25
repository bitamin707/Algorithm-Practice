package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 행렬
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1080
 *
 * 문제 :
 *      - 0과 1로 이루어진 행렬 A를 행렬 B로 바꾸는 최소 연산 횟수 구하기
 *      - 연산: 3×3 크기의 부분 행렬의 모든 원소를 뒤집기 (0→1, 1→0)
 *      - 변환이 불가능하면 -1 출력
 *
 * 입력 :
 *      - 첫째 줄: 행렬 크기 N M (N, M ≤ 50)
 *      - 다음 N개 줄: 행렬 A (0 또는 1로 구성)
 *      - 다음 N개 줄: 행렬 B (0 또는 1로 구성)
 *
 * 출력 :
 *      - A를 B로 바꾸는 최소 연산 횟수 (불가능하면 -1)
 *
 * 문제 풀이 :
 *      - 그리디 알고리즘: 왼쪽 위부터 순차적으로 확인
 *      - A[i][j] != B[i][j]이면 3×3 연산 수행 (가능한 경우만)
 *      - 3×3 연산이 불가능한 위치에서 다른 값이 있으면 -1
 *      - 알고리즘: 그리디, 구현
 */

public class BOJ_1080 {

    static char[][] matrixA;
    static char[][] matrixB;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int M = Integer.parseInt(testCase[1]);

        matrixA = new char[N][M];
        matrixB = new char[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                matrixA[i][j] = str.charAt(j);
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                matrixB[i][j] = str.charAt(j);
        }

        if (N < 3 || M < 3) {
            String result = Arrays.deepEquals(matrixA, matrixB) ? "0" : "-1";
            System.out.println(result);
            return result;
        } else {
            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < M - 2; j++) {
                    if (matrixA[i][j] != matrixB[i][j]) {
                        count++;
                        flip(i, j);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    System.out.println(-1);
                    return "-1";
                }
            }
        }

        System.out.println(count);
        return String.valueOf(count);
    }

    private static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++)
                matrixA[i][j] = matrixA[i][j] == '1' ? '0' : '1';
        }
    }

    public static void main(String[] args) {
    }
}
