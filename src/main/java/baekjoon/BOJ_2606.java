package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 바이러스
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/2606
 *
 * 문제 : 신종 바이러스가 컴퓨터 네트워크를 통해 퍼진다.
 *       1번 컴퓨터가 바이러스에 걸렸을 때,
 *       네트워크 상에서 1번 컴퓨터와 연결된 모든 컴퓨터가 감염된다.
 *       이때, 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 문제.
 *
 * 입력 :
 *      - 첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 100)
 *      - 둘째 줄에 네트워크 상에서 직접 연결된 간선 수 M (1 ≤ M ≤ N(N-1)/2)
 *      - 다음 M개의 줄에 네트워크 연결 정보 (양방향 연결) u v (1 ≤ u, v ≤ N)가 주어진다.
 *
 * 출력 :
 *      - 1번 컴퓨터를 통해 감염되는 컴퓨터의 수를 출력한다. (1번 제외)
 *
 * 문제 풀이 :
 *      - 그래프 탐색 문제 (DFS 또는 BFS)
 *      - 인접 리스트를 구성한 뒤 1번 컴퓨터에서 탐색을 시작
 *      - 방문한 노드 개수 - 1 (1번 컴퓨터 제외)을 출력
 */

public class BOJ_2606 {

    static int computerNum;
    static int lineNum;

    static int[][] graph;
    static boolean[] visited;
    static int count = 0;


    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerNum = Integer.parseInt(br.readLine());
        lineNum = Integer.parseInt(br.readLine());

        graph = new int[computerNum + 1][computerNum + 1];
        visited = new boolean[computerNum + 1];

        for (int i = 0; i < lineNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(1);

        System.out.println(count - 1);
        return String.valueOf(count - 1);
    }

    private static void dfs(int num) {
        visited[num] = true;
        count++;

        for (int i = 1; i <= computerNum; i++)
            if (graph[num][i] == 1 && !visited[i])
                dfs(i);
    }

    public static void main(String[] args) {

    }
}
