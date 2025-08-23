package programmers;

import java.util.*;

/**
 * 제목: 게임 맵 최단거리
 * 난이도: Level 2
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *
 * 문제 :
 *      - N x M 크기의 2차원 게임 맵이 주어진다.
 *      - 0은 벽, 1은 길을 의미한다.
 *      - 시작 지점 (1,1)에서 상대 팀 진영 (N,M)까지 가는 최단 거리를 구하라.
 *      - 도착할 수 없는 경우 -1을 반환한다.
 *
 * 입력 :
 *      - maps: 2차원 배열 (1 ≤ N, M ≤ 100)
 *        (maps[i][j]는 0 또는 1)
 *
 * 출력 :
 *      - 시작 지점에서 상대 진영까지의 최단 거리 (없으면 -1)
 *
 * 문제 풀이 :
 *      - BFS(너비 우선 탐색) 사용
 *      - 큐를 이용하여 상/하/좌/우 이동 탐색
 *      - 방문 처리 배열 필요
 */

public class PG_1844 {

    public static int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        int result = visited[maps.length - 1][maps[0].length -1];

        return result == 0 ? -1 : result;
    }

    private static void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int x = curPos[0];
            int y = curPos[1];

            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                if (nX < 0 || nX == maps.length || nY < 0 || nY == maps[0].length)
                    continue;

                if(visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[x][y] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }
}

