package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 케빈 베이컨의 6단계 법칙
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1389
 *
 * 문제 :
 *      - BOJ 유저들의 친구 관계가 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람을 구하기
 *      - 케빈 베이컨 수 = 모든 사람과 케빈 베이컨 게임을 했을 때 나오는 단계의 합
 *      - 케빈 베이컨 게임 = 임의의 두 사람이 최소 몇 단계만에 이어질 수 있는지 계산하는 게임
 *
 * 입력 :
 *      - 첫째 줄: 유저의 수 N (2 ≤ N ≤ 100), 친구 관계의 수 M (1 ≤ M ≤ 5,000)
 *      - 둘째 줄부터 M개 줄: 친구 관계 A B (A와 B는 친구)
 *
 * 출력 :
 *      - 케빈 베이컨의 수가 가장 작은 사람의 번호
 *      - 여러 명일 경우 번호가 가장 작은 사람 출력
 *
 * 문제 풀이 :
 *      - 방법 : 플로이드 워셜 - 모든 정점 쌍 간의 최단거리 구하기 (N ≤ 100이므로 가능)
 *      - 양방향 그래프 (A-B 친구면 B-A도 친구)
 *      - 가중치 없는 그래프 (모든 간선의 가중치는 1)
 */

public class BOJ_1389 {

    static int N, M;
    static int[][] matrix;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                matrix[i][j] = i == j? 0 : 99999;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            matrix[x][y] = matrix[y][x] = 1;
        }

        floyd_Warshall();

        int result = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 1; i <= N; i++) {
            int total = 0;

            for (int j = 1; j <= N; j++)
                total += matrix[i][j];

            if (result > total) {
                result = total;
                index = i;
            }
        }

        System.out.println(index);
        return String.valueOf(index);
    }

    private static void floyd_Warshall () {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 최단경로 설정
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
