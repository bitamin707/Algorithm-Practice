package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 최소비용 구하기
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/1916
 *
 * 문제 :
 *      - N개의 도시가 있고, 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다
 *      - A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화하려고 한다
 *      - 출발 도시에서 도착 도시까지 가는데 드는 최소비용을 구하라
 *
 * 입력 :
 *      - 첫째 줄: 도시의 개수 N (1 ≤ N ≤ 1,000)
 *      - 둘째 줄: 버스의 개수 M (1 ≤ M ≤ 100,000)
 *      - 셋째 줄부터 M+2줄: 버스의 정보 (출발 도시, 도착 도시, 버스 비용)
 *        * 버스 비용은 0 이상 100,000 미만의 정수
 *      - M+3째 줄: 구간 출발점의 도시번호와 도착점의 도시번호
 *      - 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다
 *
 * 출력 :
 *      - 첫째 줄: 출발 도시에서 도착 도시까지 가는데 드는 최소 비용
 *
 * 문제 풀이 :
 *      - 다익스트라(Dijkstra) 알고리즘을 사용하는 최단 경로 문제
 *      - 우선순위 큐를 사용하여 현재까지의 최소 비용이 작은 노드부터 방문
 *      - 같은 출발-도착 도시 쌍에 대해 버스가 여러 개 있을 수 있음 (중복 간선)
 *      - INF 값은 최대 경로 비용(N * 최대 버스 비용)보다 커야 함 (약 1억 이상)
 */

public class BOJ_1916 {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static List<List<Node>> list;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(arrive, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());
        int result = solve(start, arrive);

        System.out.println(result);
        return String.valueOf(result);
    }

    private static int solve(int start, int arrive) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        boolean[] visit = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.vertex;

            if (visit[cur])
                continue;

            if (cur == arrive)
                return dist[arrive];

            visit[cur] = true;

            for (Node nextNode : list.get(cur)) {
                if (!visit[nextNode.vertex]) {
                    int newDist = dist[cur] + nextNode.cost;

                    if (newDist < dist[nextNode.vertex]) {
                        dist[nextNode.vertex] = newDist;
                        queue.offer(new Node(nextNode.vertex, dist[nextNode.vertex]));
                    }
                }
            }
        }

        return dist[arrive];
    }

    public static void main(String[] args) {
    }
}
