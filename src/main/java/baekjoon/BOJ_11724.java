package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 연결 요소의 개수
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/11724
 *
 * 문제 : 무방향 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 문제
 *       연결 요소란 하나의 정점에서 다른 모든 정점으로 이동 가능한 정점의 집합
 *
 * 입력 :
 *      - 첫째 줄에 정점의 개수 N (1 ≤ N ≤ 1,000)과 간선의 개수 M (0 ≤ M ≤ N×(N-1)/2)가 주어진다.
 *      - 다음 M개의 줄에는 간선의 양 끝점 u와 v (1 ≤ u, v ≤ N)가 주어진다.
 *
 * 출력 :
 *      - 연결 요소의 개수를 출력한다.
 *
 * 문제 풀이 :
 *      - BFS를 큐로 구현, visited 배열로 방문 체크 후 큐 처리
 */

public class BOJ_11724 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(visited[i])
                continue;
            BFS(i);
            result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        return String.valueOf(result);
    }

    private static void BFS(int startV) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startV);
        visited[startV] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int next : graph[v]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
