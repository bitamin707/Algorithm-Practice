package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 유기농 배추
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/1012
 *
 * 문제 :
 *      - 배추밭에서 서로 인접한 배추들로 이루어진 구역의 개수 구하기
 *      - 배추흰지렁이 한 마리는 상하좌우 인접한 모든 배추를 보호 가능
 *      - 각 배추 구역마다 지렁이 한 마리씩 필요
 *      - 연결된 배추 그룹(연결 요소)의 개수를 구하는 문제
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스 개수 T
 *      - 각 테스트 케이스마다:
 *        - M(가로 길이), N(세로 길이), K(배추 개수) (1 ≤ M,N ≤ 50, 1 ≤ K ≤ 2500)
 *        - 다음 K개 줄: 배추 위치 X, Y (0 ≤ X < M, 0 ≤ Y < N)
 *
 * 출력 :
 *      - 각 테스트 케이스마다 필요한 배추흰지렁이 마리 수 출력
 *
 * 문제 풀이 :
 *      - DFS 또는 BFS를 이용한 연결 요소 찾기 문제
 *      - 2차원 배열에 배추 위치 표시 후 그래프 탐색
 *      - 방문하지 않은 배추 발견 시 DFS/BFS로 연결된 모든 배추 방문 처리
 *      - 탐색 시작 횟수가 곧 필요한 지렁이 수
 *      - 알고리즘: DFS/BFS, 연결 요소, 그래프 탐색
 */

public class BOJ_1012 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visit;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[M][N];
            visit = new int[M][N];
            int count = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (matrix[x][y] == 1 && visit[x][y] == 0) {
                        count++;
                        dfs(matrix, new int[]{x, y});
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int[][] matrix, int[] pos) {
        int curX = pos[0];
        int curY = pos[1];

        if (curX < 0 || curX == matrix.length || curY < 0 || curY == matrix[0].length)
            return;

        if (matrix[curX][curY] == 0 || visit[curX][curY] == 1)
            return;

        visit[curX][curY] = 1;

        dfs(matrix, new int[]{curX - 1, curY});
        dfs(matrix, new int[]{curX + 1, curY});
        dfs(matrix, new int[]{curX, curY - 1});
        dfs(matrix, new int[]{curX, curY + 1});
    }

    public static void main(String[] args) {

    }
}
