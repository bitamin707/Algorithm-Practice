package programmers;

import java.io.*;
import java.util.*;

/**
 * 제목: 네트워크
 * 난이도: Level 3
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 * 문제 :
 *      - n개의 컴퓨터가 네트워크로 연결되어 있다.
 *      - 연결 정보는 2차원 배열 computers로 주어진다.
 *      - 서로 연결되어 있는 컴퓨터들은 하나의 네트워크로 본다.
 *      - 네트워크의 총 개수를 구하라.
 *
 * 입력 :
 *      - n: 컴퓨터의 개수 (1 ≤ n ≤ 200)
 *      - computers: n x n 2차원 배열 (computers[i][j] = 1이면 연결, 0이면 미연결)
 *
 * 출력 :
 *      - 네트워크의 개수 (정수)
 *
 * 문제 풀이 :
 *      - 그래프 탐색 (DFS / BFS)
 *      - 방문하지 않은 노드에서 DFS/BFS 시작 → 네트워크 개수 증가
 */

public class PG_43162 {
    public static int solution(int n, int[][] computers) {

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int[][] computers, boolean[]visited, int node) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i])
                dfs(computers, visited, i);
        }
    }
}
