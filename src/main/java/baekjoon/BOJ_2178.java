package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 미로 탐색
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/2178
 *
 * 문제 :
 *      - N×M 크기의 미로에서 (1,1)에서 (N,M)까지 최단 경로 길이 구하기
 *      - 1은 이동 가능한 칸, 0은 이동 불가능한 칸
 *      - 서로 인접한 칸(상하좌우)으로만 이동 가능
 *      - 시작 위치와 도착 위치도 칸 수에 포함
 *
 * 입력 :
 *      - 첫째 줄: 두 정수 N, M (2 ≤ N, M ≤ 100)
 *      - 다음 N개 줄: M개의 정수로 미로 구성 (붙어서 입력됨, 0 또는 1)
 *
 * 출력 :
 *      - (1,1)에서 (N,M)까지의 최단 경로의 칸 수
 *
 * 문제 풀이 :
 *      - BFS(너비 우선 탐색)를 이용한 최단 경로 탐색
 *      - Queue를 사용하여 현재 위치와 이동 거리 저장
 *      - 방문 배열로 중복 방문 방지
 *      - 상하좌우 4방향 탐색
 *      - 알고리즘: BFS, 그래프 탐색, 최단 경로
 */

public class BOJ_2178 {

    static int N, M;
    static Queue<int[]> queue;
    static int[][] matrix;
    static int[][] visit;


    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                matrix[i][j] = str.charAt(j) - '0';
        }

        bfs();

        System.out.println(visit[N - 1][M - 1]);
        return String.valueOf(visit[N - 1][M - 1]);
    }

    private static void bfs() {
        queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visit[0][0] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curX = curPos[0];
            int curY = curPos[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX == N || nextY < 0 || nextY == M)
                    continue;

                if (visit[nextX][nextY] == 0 && matrix[nextX][nextY] == 1) {
                    visit[nextX][nextY] = visit[curX][curY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
