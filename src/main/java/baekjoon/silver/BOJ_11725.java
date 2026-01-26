package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 트리의 부모 찾기
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/11725
 *
 * 문제 :
 *      - 루트 없는 트리가 주어진다
 *      - 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하기
 *      - 트리는 연결된 두 정점 쌍으로 주어짐 (부모-자식 관계를 알 수 없음)
 *
 * 입력 :
 *      - 첫째 줄: 노드의 개수 N (2 ≤ N ≤ 100,000)
 *      - 둘째 줄부터 N-1개 줄: 트리 상에서 연결된 두 정점
 *
 * 출력 :
 *      - 첫째 줄부터 N-1개 줄: 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
 *
 * 문제 풀이 :
 *      - 그래프 탐색(BFS 또는 DFS) 사용
 *      - 루트(1번 노드)부터 시작하여 탐색하면서 부모-자식 관계 설정
 *      - 인접 리스트로 양방향 그래프 구성 (부모-자식 관계를 모르므로)
 *      - 방문하지 않은 인접 노드는 현재 노드의 자식 → 부모 정보 저장
 *      - BFS: 큐를 이용한 레벨 순회
 */

public class BOJ_11725 {
    static List<List<Integer>> graph;
    static boolean[] visit;
    static int[] parent;
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visit = new boolean[N + 1];
        parent = new int[N + 1];

        bfs();

        for (int i = 2; i <= N; i++)
            sb.append(parent[i]).append("\n");
        System.out.println(sb);
        return sb.toString();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visit[1] = true;

          while (!queue.isEmpty()) {
              int cur = queue.poll();

               for (int n : graph.get(cur)) {
                  if (visit[n])
                      continue;
                visit[n] = true;
                parent[n] = cur;
                queue.offer(n);
            }
           }
     }

    public static void main(String[] args) {
    }
}
