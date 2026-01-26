package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 마인크래프트
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/18111
 *
 * 문제 :
 *      - N×M 크기의 집터에서 땅의 높이를 모두 동일하게 만드는 '땅 고르기' 작업
 *      - 두 가지 작업 가능:
 *        1) 블록 제거하여 인벤토리에 넣기 (2초)
 *        2) 인벤토리에서 블록을 꺼내어 놓기 (1초)
 *      - 땅 고르기 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 구하기
 *      - 답이 여러 개면 땅의 높이가 가장 높은 것을 출력
 *
 * 입력 :
 *      - 첫째 줄: N, M, B (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 10^7)
 *      - N: 세로, M: 가로, B: 인벤토리에 있는 블록의 개수
 *      - 둘째 줄부터 N개의 줄: 각각 M개의 정수로 땅의 높이
 *      - 땅의 높이는 256보다 작거나 같은 자연수 또는 0
 *
 * 출력 :
 *      - 첫째 줄: 땅을 고르는 데 걸리는 시간과 땅의 높이
 *      - 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력
 *
 * 문제 풀이 :
 *      - 브루트포스(완전탐색) 알고리즘 사용
 *      - 가능한 모든 높이 (0~256)에 대해 시간 계산
 *      - 각 높이에서 필요한 블록 수와 제거할 블록 수 계산
 *      - 인벤토리 블록 수를 고려하여 가능한지 판단
 *      - 최소 시간을 가지는 높이 중 가장 높은 높이 선택
 */

public class BOJ_18111 {

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        String result = solve(matrix, B);

        System.out.println(result);
        return result;
    }

    private static String solve(int[][] matrix, int B) {
        int minTime = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int height = 0; height <= 256; height++) {
            int time = 0, block = B;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] > height) {
                        time += (matrix[i][j] - height) * 2;
                        block += matrix[i][j] - height;
                    } else if (matrix[i][j] < height) {
                        time += height - matrix[i][j];
                        block -= height - matrix[i][j];
                    }
                }
            }

            if (block >= 0) {
                if (time < minTime || (time == minTime && height > maxHeight)) {
                    minTime = time;
                    maxHeight = height;
                }
            }
        }

        return minTime + " " + maxHeight;
    }

    public static void main(String[] args) {
    }
}