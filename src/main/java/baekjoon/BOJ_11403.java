package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 경로 찾기
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/11403
 *
 * 문제 :
 *      - 가중치 없는 방향 그래프 G가 주어졌을 때
 *      - 모든 정점 (i, j)에 대해서 i에서 j로 가는 길이가 양수인 경로가 있는지 구하기
 *      - 인접 행렬이 주어지고, 경로 존재 여부를 인접 행렬로 출력
 *
 * 입력 :
 *      - 첫째 줄: 정점의 개수 N (1 ≤ N ≤ 100)
 *      - 둘째 줄부터 N개 줄: 그래프의 인접 행렬
 *      - i번째 줄의 j번째 숫자가 1이면 i에서 j로 가는 간선이 존재
 *      - 0이면 간선이 없음, i번째 줄의 i번째 숫자는 항상 0
 *
 * 출력 :
 *      - 총 N개의 줄에 걸쳐서 인접행렬 형식으로 출력
 *      - 정점 i에서 j로 가는 길이가 양수인 경로가 있으면 1, 없으면 0
 *
 * 문제 풀이 :
 *      - 방법 1: 플로이드 워셜(Floyd-Warshall) 알고리즘 - O(N³)
 *        * 모든 정점 쌍 간의 경로 존재 여부를 한 번에 구함
 *        * 거쳐가는 정점 k를 기준으로 경로 갱신
 *        * if (graph[i][k] && graph[k][j]) graph[i][j] = 1
 */

public class BOJ_11403 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1)
                        matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sb.append(matrix[i][j]).append(" ");

            sb.append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}