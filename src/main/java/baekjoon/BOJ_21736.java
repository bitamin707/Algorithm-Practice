package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 헌내기는 친구가 필요해
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/21736
 *
 * 문제 :
 *      - 2020년에 입학한 헌내기 도연이가 캠퍼스에서 사람들과 친해지고 싶어함
 *      - N×M 크기의 캠퍼스에서 벽이 아닌 곳으로 상하좌우 이동 가능
 *      - 도연이가 만날 수 있는 사람의 수를 구하는 문제
 *
 * 입력 :
 *      - 첫째 줄: 캠퍼스의 크기 N, M (1 ≤ N, M ≤ 600)
 *      - 둘째 줄부터 N개의 줄: 캠퍼스의 정보
 *        - O: 빈 공간 (이동 가능)
 *        - X: 벽 (이동 불가)
 *        - I: 도연이의 위치 (시작점, 한 번만 주어짐)
 *        - P: 사람의 위치
 *
 * 출력 :
 *      - 도연이가 만날 수 있는 사람의 수
 *      - 아무도 만나지 못한 경우 "TT" 출력
 *
 * 문제 풀이 :
 *      - DFS(깊이 우선 탐색) 활용
 *      - 도연이의 시작 위치 'I'에서 시작하여 연결된 모든 공간 탐색
 *      - 탐색 중 'P'(사람)를 만날 때마다 카운트 증가
 *      - 방문 체크를 통해 중복 방문 방지
 *      - 상하좌우 4방향 이동 (dx, dy 배열 활용)
 */

public class BOJ_21736 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splitStr = br.readLine().split(" ");
        int N = Integer.parseInt(splitStr[0]);
        int M = Integer.parseInt(splitStr[1]);
        char[][] matrix = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        count = 0;

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'I') {
                    startX = i;
                    startY = j;
                }
                matrix[i][j] = c;
            }
        }

        dfs(matrix, visited, startX, startY);

        System.out.println(count == 0 ? "TT" : count);
        return String.valueOf(count == 0 ? "TT" : count);
    }

    private static void dfs(char[][] matrix, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return;

        if (visited[x][y] || matrix[x][y] == 'X')
            return;

        visited[x][y] = true;

        if (matrix[x][y] == 'P')
            count++;

        for (int i = 0; i < 4; i++)
            dfs(matrix, visited, x + dx[i], y + dy[i]);
    }

    public static void main(String[] args) {
    }
}