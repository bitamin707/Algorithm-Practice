package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: N과 M (1)
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/15649
 *
 * 문제 :
 *      - 자연수 N과 M이 주어졌을 때, 조건을 만족하는 길이가 M인 수열을 모두 구하기
 *      - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *      - 순서가 중요함 (1 2와 2 1은 다른 수열)
 *
 * 입력 :
 *      - 첫째 줄: 자연수 N과 M (1 ≤ M ≤ N ≤ 8)
 *
 * 출력 :
 *      - 한 줄에 하나씩 조건을 만족하는 수열을 출력
 *      - 중복되는 수열을 여러 번 출력하면 안됨
 *      - 각 수열은 공백으로 구분해서 출력
 *      - 수열은 사전 순으로 증가하는 순서로 출력
 *
 * 문제 풀이 :
 *      - 백트래킹(DFS)을 이용한 순열(Permutation) 구현
 *      - 방문 배열(visited)을 사용해 중복 방지
 *      - 현재까지 선택한 수열을 배열에 저장하며 탐색
 *      - 길이가 M에 도달하면 수열 출력 후 백트래킹
 */

public class BOJ_15649 {
    static StringBuilder sb;
    static int N, M;
    static boolean[] visit;
    static int[] numbers;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        numbers = new int[M];

        dfs(0);
        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int n : numbers)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            numbers[depth] = i + 1;
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
    }
}
