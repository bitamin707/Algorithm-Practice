package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 쉬운 최단거리
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/14940
 *
 * 문제 :
 *      - 지도가 주어지면 모든 지점에 대해서 목표지점(2)까지의 거리를 구하라
 *      - 오직 가로와 세로로만 움직일 수 있다 (4방향 이동)
 *      - 0: 갈 수 없는 땅, 1: 갈 수 있는 땅, 2: 목표지점
 *
 * 입력 :
 *      - 첫째 줄: 지도의 크기 n(세로), m(가로) (2 ≤ n, m ≤ 1000)
 *      - 다음 n개 줄: 각 줄에 m개의 숫자 (0, 1, 2)
 *      - 2는 반드시 하나만 주어진다
 *
 * 출력 :
 *      - 각 지점에서 목표지점까지의 최단거리
 *      - 원래 0인 곳은 0, 갈 수 없는 곳은 -1 출력
 *
 * 문제 풀이 :
 *      - BFS를 사용하여 목표지점(2)에서 시작해서 모든 갈 수 있는 지점까지의 거리 계산
 *      - 목표지점에서 출발하여 역방향으로 거리를 계산하는 것이 핵심
 *      - 방문하지 못한 1인 지점은 -1로 출력
 */

public class BOJ_14940 {
    static int[][] matrix;
    static int[][] result;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        result = new int[N][M];
        visit = new boolean[N][M];
        int goalX = -1, goalY = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                matrix[i][j] = n;
                if (n == 2) {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        dfs(goalX, goalY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !visit[i][j])
                    result[i][j] = -1;

                sb.append(result[i][j]);
                if (j < M - 1) sb.append(" ");
            }
            if (i < N - 1) sb.append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int goalX, int goalY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{goalX, goalY});
        visit[goalX][goalY] = true;
        result[goalX][goalY] = 0;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curX = curPos[0];
            int curY = curPos[1];

            for (int i = 0; i < dx.length; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length)
                    continue;
                if (matrix[nextX][nextY] == 0 || visit[nextX][nextY])
                    continue;

                visit[nextX][nextY] = true;
                result[nextX][nextY] = result[curX][curY] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }

    public static void main(String[] args) {
    }
}
