package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 토마토
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/7576
 *
 * 문제 :
 *      - 2차원 창고에 토마토가 저장되어 있음
 *      - 익은 토마토(1)는 인접한 4방향의 안 익은 토마토(0)를 하루에 하나씩 익게 함
 *      - 4방향: 왼쪽, 오른쪽, 앞, 뒤 (대각선 제외)
 *      - 모든 토마토가 익는 최소 일수를 구하기
 *      - 토마토가 모두 익지 못하는 상황이면 -1 출력
 *
 * 입력 :
 *      - 첫째 줄: M(가로), N(세로) (2 ≤ M, N ≤ 1,000)
 *      - 둘째 줄부터: N×M 크기의 토마토 정보
 *      - 1: 익은 토마토, 0: 안 익은 토마토, -1: 토마토가 없는 칸
 *
 * 출력 :
 *      - 모든 토마토가 익는 최소 일수
 *      - 이미 모두 익어있으면 0, 모두 익지 못하면 -1
 *
 * 문제 풀이 :
 *      - 2차원 BFS (Multi-Source BFS)
 *      - 처음부터 익은 토마토들을 모두 큐에 넣고 시작
 *      - 4방향 탐색: (±1,0), (0,±1)
 *      - 각 토마토가 익는 날짜를 배열에 저장
 *      - 마지막에 안 익은 토마토가 있는지 확인
 */

public class BOJ_7576 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                box[i][j] = num;

                if (num == 1)
                    queue.offer(new int[]{i, j});
            }
        }

        int result = bfs(box, queue);
        System.out.println(result);
        return String.valueOf(result);
    }

    private static int bfs(int[][] box, Queue<int[]> queue) {
        if (!hasUnripe(box))
            return 0;
        if (queue.isEmpty())
            return -1;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curX = curPos[0];
            int curY = curPos[1];

            for (int i = 0; i < dx.length; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= box.length || nextY < 0 || nextY >= box[0].length)
                    continue;
                if (box[nextX][nextY] == -1 || box[nextX][nextY] > 0)
                    continue;
                box[nextX][nextY] = box[curX][curY] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }

        int count = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0)
                    return -1;

                count = Math.max(count, box[i][j]);
            }
        }
        return count == 0 ? 0 : count - 1;
    }

    private static boolean hasUnripe(int[][] box) {
        boolean hasUnripe = false;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) {
                    hasUnripe = true;
                    break;
                }
            }
            if (hasUnripe) break;
        }

        return hasUnripe;
    }

    public static void main(String[] args) {
    }
}
