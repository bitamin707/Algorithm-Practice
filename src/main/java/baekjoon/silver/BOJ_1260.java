package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: DFS와 BFS
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/1260
 *
 * 문제 : 그래프가 주어졌을 때, DFS와 BFS를 수행한 결과를 출력하는 문제
 *       시작 정점에서 DFS는 재귀적으로 깊이 우선 탐색, BFS는 큐를 이용한 너비 우선 탐색을 수행
 *
 * 입력 :
 *      - 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 시작 정점 번호 V가 주어진다.
 *      - 다음 M개의 줄에 간선이 연결하는 두 정점의 번호가 주어진다.
 *      - 정점 번호는 1부터 N까지이며, 간선은 양방향이다.
 *
 * 출력 :
 *      - 첫째 줄에 DFS 수행 결과
 *      - 둘째 줄에 BFS 수행 결과
 *      - 각 정점은 공백으로 구분하여 출력
 *
 * 문제 풀이 :
 *      - 각 노드마다 연결된 노드를 리스트로 저장
 *      - 간선을 양방향으로 저장 후 리스트에 정점들을 오름차순으로 정렬
 *      - DFS를 재귀로 구현, visited 배열을 사용하여 현재 노드 방문 후 방문하지 않은 정점을 재귀로 호출
 *      - BFS를 큐로 구현, visited 배열로 방문 체크 후 큐 처리
 */

public class BOJ_1260 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder dfsSB = new StringBuilder();
    static StringBuilder bfsSB = new StringBuilder();

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int M = Integer.parseInt(testCase[1]);
        int V = Integer.parseInt(testCase[2]);

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i <= N; i++)
            Collections.sort(graph[i]);

        visited = new boolean[N + 1];
        DFS(V);
        dfsSB.append("\n");

        visited = new boolean[N + 1];
        BFS(V);
        bw.write(dfsSB.toString());
        bw.write(bfsSB.toString());
        bw.flush();
        return dfsSB.toString().trim() + "\n" + bfsSB.toString().trim() + "\n";
    }

    private static void DFS(int v) {
        visited[v] = true;
        dfsSB.append(v).append(" ");

        for (int next : graph[v]) {
            if (!visited[next])
                DFS(next);
        }
    }

    private static void BFS(int startV) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startV);
        visited[startV] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            bfsSB.append(v).append(" ");

            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
