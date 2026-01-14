package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 나이트의 이동
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/7562
 * <p>
 * 문제 :
 * - 체스판 위에 한 나이트가 놓여져 있다.
 * - 나이트가 이동하려고 하는 칸이 주어졌을 때, 최소 몇 번만에 이동할 수 있는지 구하시오.
 * <p>
 * 입력 :
 * - 첫째 줄에 테스트 케이스의 개수가 주어진다.
 * - 각 테스트 케이스는 세 줄로 이루어져 있다.
 * - 첫째 줄: 체스판의 한 변의 길이 l (4 ≤ l ≤ 300)
 * - 둘째 줄: 나이트가 현재 있는 칸의 좌표
 * - 셋째 줄: 나이트가 이동하려고 하는 칸의 좌표
 * <p>
 * 출력 :
 * - 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
 */

public class BOJ_7562 {
    private static final int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    private static final int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};
    private static int boardSize;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] curPos = new int[2];
            int[] targetPos = new int[2];

            boardSize = Integer.parseInt(br.readLine());

            String[] getCurPose = br.readLine().split(" ");
            curPos[0] = Integer.parseInt(getCurPose[0]);
            curPos[1] = Integer.parseInt(getCurPose[1]);

            String[] getTargetPose = br.readLine().split(" ");
            targetPos[0] = Integer.parseInt(getTargetPose[0]);
            targetPos[1] = Integer.parseInt(getTargetPose[1]);

            sb.append(bfs(curPos, targetPos)).append("\n");
        }
        System.out.println(sb);
        return sb.toString().trim();
    }

    private static int bfs(int[] curPos, int[] targetPos) {
        int[][] visit = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                visit[i][j] = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(curPos);
        visit[curPos[0]][curPos[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == targetPos[0] && curY == targetPos[1])
                return visit[curX][curY];

            for (int i = 0; i < dx.length; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= boardSize || nextY < 0 || nextY >= boardSize)
                    continue;

                if (visit[nextX][nextY] == -1) {
                    visit[nextX][nextY] = visit[curX][curY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
    }
}