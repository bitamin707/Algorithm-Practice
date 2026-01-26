package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 토마토
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/7569
 *
 * 문제 :
 *      - 3차원 창고에 토마토가 저장되어 있음
 *      - 익은 토마토(1)는 인접한 6방향의 안 익은 토마토(0)를 하루에 하나씩 익게 함
 *      - 6방향: 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
 *      - 모든 토마토가 익는 최소 일수를 구하기
 *      - 토마토가 모두 익지 못하는 상황이면 -1 출력
 *
 * 입력 :
 *      - 첫째 줄: M(가로), N(세로), H(높이) (2 ≤ M,N ≤ 100, 1 ≤ H ≤ 100)
 *      - 둘째 줄부터: H개의 층, 각 층마다 N×M 크기의 토마토 정보
 *      - 1: 익은 토마토, 0: 안 익은 토마토, -1: 토마토가 없는 칸
 *
 * 출력 :
 *      - 모든 토마토가 익는 최소 일수
 *      - 이미 모두 익어있으면 0, 모두 익지 못하면 -1
 *
 * 문제 풀이 :
 *      - 3차원 BFS (Multi-Source BFS)
 *      - 처음부터 익은 토마토들을 모두 큐에 넣고 시작
 *      - 6방향 탐색: (±1,0,0), (0,±1,0), (0,0,±1)
 *      - 각 토마토가 익는 날짜를 배열에 저장
 *      - 마지막에 안 익은 토마토가 있는지 확인
 */

public class BOJ_7569 {

    static int M, N, H;
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dn = {-1, 1, 0, 0, 0, 0};
    static int[] dm = {0, 0, -1, 1, 0, 0};

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][k] = num;

                    if (num == 1)
                        queue.offer(new int[]{i, j, k});
                }
            }
        }
        int result = bfs(box, queue);
        System.out.println(result);
        return String.valueOf(result);
    }

    private static int bfs(int[][][] box, Queue<int[]> queue) {
        if (queue.isEmpty())
            return -1;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            for (int i = 0; i < dh.length; i++) {
                int nextH = curPos[0] + dh[i];
                int nextN = curPos[1] + dn[i];
                int nextM = curPos[2] + dm[i];

                if (nextH < 0 || nextH >= H || nextN < 0 || nextN >= N || nextM < 0 || nextM >= M)
                    continue;
                if (box[nextH][nextN][nextM] == 0) {
                    queue.offer(new int[]{nextH, nextN, nextM});
                    box[nextH][nextN][nextM] = box[curPos[0]][curPos[1]][curPos[2]] + 1;
                }
            }
        }

        int time = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0)
                        return -1;
                    else
                        time = Math.max(time, box[i][j][k]);
                }
            }
        }
        return time - 1;
    }

    public static void main(String[] args) {
    }
}
