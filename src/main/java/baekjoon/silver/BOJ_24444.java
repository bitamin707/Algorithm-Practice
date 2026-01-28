package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 알고리즘 수업 - 너비 우선 탐색 1
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/24444
 * <p>
 * 문제 :
 * - N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어짐.
 * - 시작 정점 R에서 출발하여 BFS로 노드를 방문할 때, 각 노드의 방문 순서를 출력.
 * - 인접 정점은 오름차순으로 방문함.
 * <p>
 * 입력 :
 * - 첫째 줄에 정점의 수 N, 간선의 수 M, 시작 정점 R이 주어짐.
 * - 다음 M개 줄에 간선 정보 u, v가 주어짐.
 * <p>
 * 출력 :
 * - 1번 정점부터 N번 정점까지 순서대로 방문 순서를 출력. 방문하지 않는 경우 0 출력.
 * <p>
 * 문제 풀이 :
 * - 인접 리스트를 생성하고 각 리스트를 오름차순으로 정렬.
 * - Queue를 이용한 BFS를 수행하며 방문 순서를 배열에 기록.
 */
public class BOJ_24444 {

    private static int[] visit;
    private static List<List<Integer>> list;
    private static int count = 0;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(list.get(i));

        count++;
        bfs(R);

        for (int i = 1; i < visit.length; i++)
            sb.append(visit[i]).append("\n");

        System.out.println(sb);
        return sb.toString();
    }

    private static void bfs(int r) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(r);

        visit[r] = count;
        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int num : list.get(start)) {
                if (visit[num] == 0) {
                    queue.add(num);
                    count++;
                    visit[num] = count;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
