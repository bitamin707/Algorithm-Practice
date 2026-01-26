package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 뱀과 사다리 게임
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/16928
 *
 * 문제 :
 *      - 10×10 보드판(1~100 칸)에서 주사위를 굴려 100번 칸에 도달하는 게임
 *      - 주사위: 1~6의 눈금이 나옴
 *      - 사다리: 특정 칸에 도착하면 더 높은 칸으로 이동 (x < y)
 *      - 뱀: 특정 칸에 도착하면 더 낮은 칸으로 이동 (u > v)
 *      - 100번 칸을 넘어가면 이동 불가
 *      - 1번 칸에서 시작하여 100번 칸에 도달하는 최소 주사위 굴림 횟수 구하기
 *
 * 입력 :
 *      - 첫째 줄: 사다리의 수 N, 뱀의 수 M (1 ≤ N, M ≤ 15)
 *      - 다음 N개 줄: 사다리 정보 x y (x번 칸 → y번 칸, x < y)
 *      - 다음 M개 줄: 뱀 정보 u v (u번 칸 → v번 칸, u > v)
 *
 * 출력 :
 *      - 100번 칸에 도착하기 위한 최소 주사위 굴림 횟수
 *
 * 문제 풀이 :
 *      - BFS를 사용한 최단 경로 찾기
 *      - 1번 칸부터 시작하여 주사위 눈금(1~6)만큼 이동
 *      - 도착한 칸에 사다리나 뱀이 있으면 해당 위치로 이동
 *      - 100번 칸에 도착하면 현재까지의 주사위 굴림 횟수 반환
 */

public class BOJ_16928 {
    static Map<Integer, Integer> event;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        event = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            event.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int result = bfs();
        System.out.println(result);
        return String.valueOf(result);
    }

    private static int bfs() {
        int[] visit = new int[101];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            if (curPos == 100)
                return visit[100];

            for (int i = 1; i < 7; i++) {
                int next = curPos + i;
                if (next > 100)
                    continue;

                if (event.containsKey(next))
                    next = event.get(next);

                if (visit[next] == 0) {
                    visit[next] = visit[curPos] + 1;
                    queue.offer(next);
                }
            }
        }
        return visit[100];
    }

    public static void main(String[] args) {
    }
}
