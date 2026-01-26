package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 숨바꼭질
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1697
 *
 * 문제 :
 *      - 수빈이는 현재 점 N에 있고, 동생은 점 K에 있음
 *      - 수빈이는 걷거나 순간이동을 할 수 있음
 *      - X에서 1초 후에 X-1, X+1, 2*X로 이동 가능
 *      - 수빈이가 동생을 찾을 수 있는 가장 빠른 시간 구하기
 *
 * 입력 :
 *      - 첫째 줄: 수빈이의 위치 N, 동생의 위치 K (0 ≤ N, K ≤ 100,000)
 *
 * 출력 :
 *      - 수빈이가 동생을 찾는 가장 빠른 시간(초)
 *
 * 문제 풀이 :
 *      - BFS(너비 우선 탐색) 사용
 *      - 각 위치에서 X-1, X+1, 2*X로 이동 가능
 *      - 방문 처리를 통해 중복 탐색 방지
 *      - 범위 체크 필요 (0 ≤ 위치 ≤ 100,000)
 *      - 최단 시간을 구하는 문제이므로 BFS가 적합
 */

public class BOJ_1697 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[100001];

        int result = bfs(visit, N, K);

        System.out.println(result);
        return String.valueOf(result);
    }

    private static int bfs(boolean[] visit, int x, int y) {
        if (x == y) return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];

            int[] nextPos = {pos - 1, pos + 1, pos * 2};

            for (int next : nextPos) {
                if (next == y)
                    return time + 1;

                if (next >= 0 && next < visit.length && !visit[next]) {
                    visit[next] = true;
                    queue.offer(new int[]{next, time + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}