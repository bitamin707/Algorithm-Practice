package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 단지번호붙이기
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/2667
 *
 * 문제 :
 *      - 정사각형 모양의 지도에서 1은 집이 있는 곳, 0은 집이 없는 곳
 *      - 연결된 집의 모임인 단지를 정의하고 단지에 번호를 붙이기
 *      - 연결: 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우 (대각선 제외)
 *      - 총 단지수와 각 단지내 집의 수를 오름차순으로 출력
 *
 * 입력 :
 *      - 첫째 줄: 지도의 크기 N (5 ≤ N ≤ 25)
 *      - 다음 N개 줄: 각각 N개의 자료 (0 또는 1)
 *
 * 출력 :
 *      - 첫째 줄: 총 단지수
 *      - 그 다음 줄부터: 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩
 *
 * 문제 풀이 :
 *      - DFS 또는 BFS 사용하여 연결 요소(Connected Component) 찾기
 *      - 플러드 필(Flood Fill) 알고리즘
 *      - 방향: 상하좌우 4방향 탐색
 *      - 방문 처리 필요
 *      - 각 단지의 집 개수를 저장하고 마지막에 정렬
 */

public class BOJ_2667 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] matrix;
    static boolean[][] visit;
    static List<Integer> address;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visit = new boolean[N][N];
        address = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++)
                matrix[i][j] = str.charAt(j) - '0';
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1 && !visit[i][j])
                    dfs(i, j);
            }
        }

        Collections.sort(address);

        sb.append(address.size()).append("\n");

        for (int num : address)
            sb.append(num).append("\n");

        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        int count = 0;
        stack.push(new int[]{x, y});
        visit[x][y] = true;

        while (!stack.isEmpty()) {
            int[] curPos = stack.pop();
            int curX = curPos[0];
            int curY = curPos[1];
            count++;

            for (int i = 0; i < dx.length; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix.length)
                    continue;
                if (matrix[nextX][nextY] == 0 || visit[nextX][nextY])
                    continue;

                visit[nextX][nextY] = true;
                stack.push(new int[]{nextX, nextY});
            }
        }

        address.add(count);
    }

    public static void main(String[] args) {
    }
}
